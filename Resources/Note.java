package com.example.simplenoteapp;

public class Note {
    private long id;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    public Note(long id, String title, String content, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String toString() {
        return this.getTitle(); // Assuming getTitle() is a method in your Note class that returns the title of the note.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
