package com.example.simplenoteapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonSupport;
    private Button buttonSettings;
    private Button buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSupport = findViewById(R.id.buttonSupport);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonInfo = findViewById(R.id.buttonInfo);

        // Chức năng Đăng nhập
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic đăng nhập
                Intent loginIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/"));
                startActivity(loginIntent);
            }
        });

        // Chức năng Hỗ trợ
        buttonSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic hỗ trợ (ví dụ mở trình duyệt để tìm kiếm hỗ trợ)
                Intent supportIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://support.google.com/"));
                startActivity(supportIntent);
            }
        });

        // Chức năng Cài đặt
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(MenuActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        // Chức năng Thông tin
        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logic hiển thị thông tin về ứng dụng
                Intent aboutIntent = new Intent(MenuActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });
    }
}
