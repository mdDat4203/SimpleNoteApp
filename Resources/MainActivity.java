package com.example.simplenoteapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNotes;
    private FloatingActionButton fabAddNote;
    private NoteDAO noteDAO;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewNotes = findViewById(R.id.listViewNotes);
        fabAddNote = findViewById(R.id.fabAddNote);

        noteDAO = new NoteDAO(this);
        loadNotes();

        fabAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
            startActivity(intent);
        });

        // Đăng ký context menu cho ListView
        registerForContextMenu(listViewNotes);

        listViewNotes.setOnItemClickListener((parent, view, position, id) -> {
            Note selectedNote = (Note) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, NoteDetailActivity.class);
            intent.putExtra("noteTitle", selectedNote.getTitle());
            intent.putExtra("noteContent", selectedNote.getContent());
            startActivity(intent);
        });
    }

    private void loadNotes() {
        List<Note> notes = noteDAO.getAllNotes();
        adapter = new NoteAdapter(this, notes);
        listViewNotes.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noteDAO.close();
    }

    // Tạo context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_note_options, menu);
    }

    // Xử lý khi một item trong context menu được chọn
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Note selectedNote = (Note) listViewNotes.getItemAtPosition(info.position);

        switch (item.getItemId()) {
            case R.id.action_edit:
                Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
                intent.putExtra("noteId", selectedNote.getId());
                startActivity(intent);
                return true;

            case R.id.action_delete:
                new AlertDialog.Builder(this)
                        .setTitle("Delete Note")
                        .setMessage("Are you sure you want to delete this note?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            noteDAO.deleteNote(selectedNote.getId());
                            loadNotes(); // Tải lại danh sách ghi chú sau khi xóa
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
