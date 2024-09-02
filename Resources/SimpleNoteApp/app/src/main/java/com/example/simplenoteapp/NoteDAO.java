package com.example.simplenoteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public NoteDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertNote(Note note) {
        ContentValues values = new ContentValues();
        values.put("title", note.getTitle());
        values.put("content", note.getContent());
        values.put("createdAt", note.getCreatedAt());
        values.put("updatedAt", note.getUpdatedAt());
        db.insert("notes", null, values);
    }

    public void updateNote(Note note) {
        ContentValues values = new ContentValues();
        values.put("title", note.getTitle());
        values.put("content", note.getContent());
        values.put("createdAt", note.getCreatedAt());
        values.put("updatedAt", note.getUpdatedAt());
        db.update("notes", values, "id = ?", new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(long noteId) {
        db.delete("notes", "id = ?", new String[]{String.valueOf(noteId)});
    }

    public Note getNoteById(long noteId) {
        Cursor cursor = db.query("notes", null, "id = ?", new String[]{String.valueOf(noteId)},
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Note note = new Note(
                    cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("title")),
                    cursor.getString(cursor.getColumnIndexOrThrow("content")),
                    cursor.getString(cursor.getColumnIndexOrThrow("createdAt")),
                    cursor.getString(cursor.getColumnIndexOrThrow("updatedAt"))
            );
            cursor.close();
            return note;
        }
        return null;
    }

    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        Cursor cursor = db.query("notes", null, null, null, null, null, "id DESC");
        while (cursor.moveToNext()) {
            notes.add(new Note(
                    cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                    cursor.getString(cursor.getColumnIndexOrThrow("title")),
                    cursor.getString(cursor.getColumnIndexOrThrow("content")),
                    cursor.getString(cursor.getColumnIndexOrThrow("createdAt")),
                    cursor.getString(cursor.getColumnIndexOrThrow("updatedAt"))
            ));
        }
        cursor.close();
        return notes;
    }
}
