package com.example.intentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileDisplay extends AppCompatActivity {

    TextView nameDisplay, ageDisplay, moodValue, moodCaption;
    ImageView moodImage;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_display);

        nameDisplay = findViewById(R.id.textViewNameValue);
        ageDisplay = findViewById(R.id.textViewAgeValue);
        moodValue = findViewById(R.id.textViewMoodStatus);
        moodCaption = findViewById(R.id.textViewMoodTag);
        moodImage = findViewById(R.id.imageViewDisplay);

        if(getIntent() != null && getIntent().hasExtra(MainActivity.KEY_USER)) {
            User user = (User) getIntent().getSerializableExtra(MainActivity.KEY_USER);
            nameDisplay.setText(user.getName());
            ageDisplay.setText(user.getAge());
            switch (user.moodState) {
                case 0:
                    moodImage.setImageResource(R.drawable.not_well);
                    moodValue.setText("0 out of 4");
                    moodCaption.setText("Not well");
                    break;
                case 1:
                    moodImage.setImageResource(R.drawable.sad);
                    moodValue.setText("1 out of 4");
                    moodCaption.setText("Sad");
                    break;
                case 2:
                    moodImage.setImageResource(R.drawable.ok);
                    moodValue.setText("2 out of 4");
                    moodCaption.setText("Ok");
                    break;
                case 3:
                    moodImage.setImageResource(R.drawable.good);
                    moodValue.setText("3 out of 4");
                    moodCaption.setText("Good");
                    break;
                case 4:
                    moodImage.setImageResource(R.drawable.very_good);
                    moodValue.setText("4 out of 4");
                    moodCaption.setText("Very good");
                    break;
                default:
                    moodImage.setImageDrawable(null);
            }
        }

        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}