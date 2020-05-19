package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UnlockStoriesActivity extends AppCompatActivity {
    private static final String TAG = "UnlockStoriesActivity";

    private TextView name, intro;
    private String chatName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock_stories);
        Log.d(TAG, "onCreate: started");

        name = findViewById(R.id.textView_name_unlock_story);
        intro = findViewById(R.id.textView_intro_unlock_story);

        Intent intent = getIntent();

        if (intent.hasExtra("chat_name")) {

            chatName = intent.getStringExtra("chat_name");
            name.setText(chatName);

            Introductions introductions = new Introductions();

            switch (chatName.toLowerCase()){
                case "john":
                    intro.setText(introductions.JohnFunny());
                    break;

                case "alice":
                    intro.setText(introductions.AliceFunny());
                    break;

                case "charlie":
                    intro.setText(introductions.CharlieSuspense());
                    break;

                case "carl":
                    intro.setText(introductions.CarlSuspense());
                    break;

                case "kathy":
                    intro.setText(introductions.KathyThriller());
                    break;

                case "william":
                    intro.setText(introductions.WilliamThriller());
                    break;

                case "sam":
                    intro.setText(introductions.SamOther());
                    break;

                case "alex":
                    intro.setText(introductions.AlexOther());
                    break;
            }
        }
        findViewById(R.id.begin_trial_btn).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Intent intent1 = new Intent(UnlockStoriesActivity.this, ConversationActivity.class);
                intent1.putExtra("chat_name", chatName);
                intent1.putExtra("trial", true);
                startActivity(intent1);
            }
        });

        findViewById(R.id.unlock_chat_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(UnlockStoriesActivity.this, ConversationActivity.class);
                intent1.putExtra("chat_name", chatName);
                intent1.putExtra("trial", false);
                startActivity(intent1);
            }
        });
    }
}
