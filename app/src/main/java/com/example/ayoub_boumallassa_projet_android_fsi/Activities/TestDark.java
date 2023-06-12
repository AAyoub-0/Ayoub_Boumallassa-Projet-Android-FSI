package com.example.ayoub_boumallassa_projet_android_fsi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ToggleButton;

import com.example.ayoub_boumallassa_projet_android_fsi.R;

public class TestDark extends AppCompatActivity {

    private ToggleButton toggle;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean night_mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dark);

        toggle = findViewById(R.id.toggleButton);

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        night_mode = sharedPreferences.getBoolean("night", false);

        if (night_mode){
            toggle.setChecked(true);
        }

        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor = sharedPreferences.edit();
                editor.putBoolean("night", false);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor = sharedPreferences.edit();
                editor.putBoolean("night", true);
            }
            editor.apply();
        });
    }
}