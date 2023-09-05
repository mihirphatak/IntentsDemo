package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class SelectMood extends AppCompatActivity {

    SeekBar mood;
    TextView moodValue;
    ImageView moodImage;

    public static final String KEY_MOOD = "MOOD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        setTitle("Set Mood");

        mood = findViewById(R.id.seekBarMood);
        moodValue = findViewById(R.id.textViewMoodValue);
        moodImage = findViewById(R.id.imageViewMood);

        mood.setProgress(2);
        moodImage.setImageResource(R.drawable.ok);
        moodValue.setText(String.valueOf(2));

        mood.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                moodValue.setText(String.valueOf(i));
                switch (i) {
                    case 0:
                        moodImage.setImageResource(R.drawable.not_well);
                        break;
                    case 1:
                        moodImage.setImageResource(R.drawable.sad);
                        break;
                    case 2:
                        moodImage.setImageResource(R.drawable.ok);
                        break;
                    case 3:
                        moodImage.setImageResource(R.drawable.good);
                        break;
                    case 4:
                        moodImage.setImageResource(R.drawable.very_good);
                        break;
                    default:
                        moodImage.setImageDrawable(null);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        findViewById(R.id.buttonMoodCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.buttonMoodSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(KEY_MOOD, String.valueOf(moodValue.getText()));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}