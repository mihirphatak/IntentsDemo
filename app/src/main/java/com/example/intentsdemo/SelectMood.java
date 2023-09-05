package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

public class SelectMood extends AppCompatActivity {

    SeekBar mood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        setTitle("Set Mood");
    }
}