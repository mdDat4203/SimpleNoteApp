package com.example.simplenoteapp;

public class Note {
    private long id; // Nếu bạn đang dùng int, hãy chuyển thành int
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    // Constructor với id, title, và content
    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Constructor đơn giản khi thêm ghi chú mới
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Constructor đầy đủ với các tham số khác
    public Note(long id, String title, String content, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter và Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
