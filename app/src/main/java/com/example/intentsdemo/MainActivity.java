package com.example.intentsdemo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText name, age;
    ImageView moodImage;
    int moodState;

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
                    } else {
                        moodState = -1;
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
                
            }
        });
    }
}