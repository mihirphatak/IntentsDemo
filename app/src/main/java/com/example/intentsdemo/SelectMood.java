package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SelectMood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        setTitle("Set Mood");
    }
}