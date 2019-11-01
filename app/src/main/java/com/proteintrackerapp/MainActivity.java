package com.proteintrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(myBtnSettingClick);
        SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin", null);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        if (statusLogin != null) {
            btnLogin.setText("Logout");
        } else {
            btnLogin.setText("Login");
        }
    }

    private View.OnClickListener myBtnSettingClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences preferences = MainActivity.this.getSharedPreferences("pref_file", MODE_PRIVATE);
            String statusLogin = preferences.getString("isLogin", null);
            SharedPreferences.Editor edit = preferences.edit();

            Button btnLogin = findViewById(R.id.btnLogin);
            if (statusLogin != null) {
                edit.putString("isLogin", null);
                btnLogin.setText("Login");
            } else {
                edit.putString("isLogin", "Admin");
                btnLogin.setText("Logout");
                edit.commit();
            }
        }
    };
}












