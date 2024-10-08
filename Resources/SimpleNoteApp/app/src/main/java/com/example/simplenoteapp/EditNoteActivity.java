package com.example.simplenoteapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditNoteActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextContent;
    private Button buttonSave;
    private NoteDAO noteDAO;
    private int noteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.buttonSave);

        noteDAO = new NoteDAO(this);

        if (getIntent().hasExtra("noteId")) {
            noteId = getIntent().getIntExtra("noteId", -1);
            Note note = noteDAO.getNoteById(noteId);
            if (note != null) {
                editTextTitle.setText(note.getTitle());
                editTextContent.setText(note.getContent());
            }
        }

        buttonSave.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString().trim();
            String content = editTextContent.getText().toString().trim();

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Title and content cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            if (noteId == -1) {
                noteDAO.insertNote(new Note(title, content));
            } else {
                Note note = new Note(noteId, title, content);
                noteDAO.updateNote(note);
            }

            finish(); // Quay trở lại MainActivity sau khi lưu
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noteDAO.close();
    }
}
