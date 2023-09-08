// Assignment 2
// MainActivity.java
// Mihir Phatak and Aniket Shendre - Group 3

package com.example.intentsdemo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    ImageView moodImage;
    TextView moodCaption;
    int moodState;

    public static final String KEY_USER = "USER";

    private ActivityResultLauncher<Intent> startMoodForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        moodState = Integer.parseInt(data.getStringExtra(SelectMood.KEY_MOOD));
                        switch (moodState) {
                            case 0:
                                moodImage.setImageResource(R.drawable.not_well);
                                moodCaption.setText(moodState + " out of 4");
                                break;
                            case 1:
                                moodImage.setImageResource(R.drawable.sad);
                                moodCaption.setText(moodState + " out of 4");
                                break;
                            case 2:
                                moodImage.setImageResource(R.drawable.ok);
                                moodCaption.setText(moodState + " out of 4");
                                break;
                            case 3:
                                moodImage.setImageResource(R.drawable.good);
                                moodCaption.setText(moodState + " out of 4");
                                break;
                            case 4:
                                moodImage.setImageResource(R.drawable.very_good);
                                moodCaption.setText(moodState + " out of 4");
                                break;
                            default:
                                moodImage.setImageDrawable(null);
                        }
                    } else {
                        moodState = -1;
                        moodCaption.setText("");
                        moodImage.setImageDrawable(null);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Mood");

        moodImage = (ImageView) findViewById(R.id.imageViewMoodView);
        moodCaption = (TextView) findViewById(R.id.textViewMoodCaption);
        moodCaption.setText("");
        moodState = -1;
        moodImage.setImageDrawable(null);

        name = findViewById(R.id.editTextName);
        age = findViewById(R.id.editTextAge);

        findViewById(R.id.buttonSelectMood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelectMood.class);
                startMoodForResult.launch(intent);
            }
        });

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formName = name.getText().toString();
                String formAge = age.getText().toString();
                Log.d("moodstate", "onClick: " + moodState);
                int mood = moodState;

                if (formName != null && formName.length() > 0 && formAge != null && formAge.length() > 0 && mood != -1) {
                    User user = new User(formName, formAge, mood);
                    Intent intent = new Intent(MainActivity.this, ProfileDisplay.class);
                    intent.putExtra(KEY_USER, user);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter all input fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}