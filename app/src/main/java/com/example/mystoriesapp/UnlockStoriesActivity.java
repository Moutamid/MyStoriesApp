package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;

public class UnlockStoriesActivity extends AppCompatActivity {
    private static final String TAG = "UnlockStoriesActivity";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock_stories);
        Log.d(TAG, "onCreate: started");


        findViewById(R.id.begin_trial_btn).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                UnlockStoriesActivity.this.startActivity(new Intent(UnlockStoriesActivity.this, ConversationActivity.class));
            }
        });
    }
}
