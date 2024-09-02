package com.example.simplenoteapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchDarkMode;
    private Button buttonSync;
    private Button buttonChangeFontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchDarkMode = findViewById(R.id.switchDarkMode);
        buttonSync = findViewById(R.id.buttonSync);
        buttonChangeFontSize = findViewById(R.id.buttonChangeFontSize);

        // Chuyển đổi chế độ tối (Dark Mode)
        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Chuyển sang Dark Mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    // Chuyển về Light Mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        // Đồng bộ hóa ghi chú
        buttonSync.setOnClickListener(v -> {
            // Logic để đồng bộ hóa ghi chú
            Toast.makeText(SettingsActivity.this, "Notes synced successfully", Toast.LENGTH_SHORT).show();
        });

        // Thay đổi cỡ chữ
        buttonChangeFontSize.setOnClickListener(v -> {
            // Logic để thay đổi cỡ chữ
            Toast.makeText(SettingsActivity.this, "Font size changed", Toast.LENGTH_SHORT).show();
        });
    }
}
