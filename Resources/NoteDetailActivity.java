package com.example.simplenoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NoteDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        TextView titleTextView = findViewById(R.id.textViewNoteTitle);
        TextView contentTextView = findViewById(R.id.textViewNoteContent);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String noteTitle = intent.getStringExtra("noteTitle");
        String noteContent = intent.getStringExtra("noteContent");

        // Hiển thị dữ liệu lên màn hình
        titleTextView.setText(noteTitle);
        contentTextView.setText(noteContent);
    }
}
