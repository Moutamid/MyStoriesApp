package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UnlockStoriesActivity extends AppCompatActivity {
    private static final String TAG = "UnlockStoriesActivity";

    private String chatName;
    private Utils utils = new Utils();
    private Button trialBtn, unlockBtn, openBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock_stories);
        Log.d(TAG, "onCreate: started");

        TextView name = findViewById(R.id.textView_name_unlock_story);
        TextView intro = findViewById(R.id.textView_intro_unlock_story);

        trialBtn = findViewById(R.id.begin_trial_btn);
        unlockBtn = findViewById(R.id.unlock_chat_btn);
        openBtn = findViewById(R.id.open_chat_btn);

        Intent intent = getIntent();

        if (intent.hasExtra("chat_name")) {
            Log.d(TAG, "onCreate: if (intent.hasExtra(\"chat_name\")) {");

            chatName = intent.getStringExtra("chat_name");
            name.setText(chatName);

            Introductions introductions = new Introductions();

            switch (chatName.toLowerCase()) {
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

        if (utils.getStoredBoolean(UnlockStoriesActivity.this, chatName + "trial"))
            trialBtn.setVisibility(View.GONE);

        if (utils.getStoredBoolean(UnlockStoriesActivity.this, chatName + "unlock")) {
            Log.d(TAG, "onCreate: if(utils.getStoredBoolean(UnlockStoriesActivity.this, chatName+\"unlock\")) {");
            unlockBtn.setVisibility(View.GONE);
            trialBtn.setVisibility(View.GONE);
            openBtn.setVisibility(View.VISIBLE);
        }

        setTrialBtnClickListener();

        setUnlockBtnClickListsner();

        setOpenBtnClickListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        if (utils.getStoredBoolean(UnlockStoriesActivity.this, chatName + "trial"))
            trialBtn.setVisibility(View.GONE);

        if (utils.getStoredBoolean(UnlockStoriesActivity.this, chatName + "unlock")) {
            unlockBtn.setVisibility(View.GONE);
            trialBtn.setVisibility(View.GONE);
            openBtn.setVisibility(View.VISIBLE);
        }
    }

    private void setOpenBtnClickListener() {
        Log.d(TAG, "setOpenBtnClickListener: ");
        openBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: setOpenBtnClickListener");
                Intent intent1 = new Intent(UnlockStoriesActivity.this, ConversationActivity.class);
                intent1.putExtra("chat_name", chatName);
                intent1.putExtra("trial", false);

                startActivity(intent1);
            }
        });
    }

    private void setUnlockBtnClickListsner() {
        Log.d(TAG, "setUnlockBtnClickListsner: ");
        unlockBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: setUnlockBtnClickListsner");
                Intent intent1 = new Intent(UnlockStoriesActivity.this, ConversationActivity.class);
                intent1.putExtra("chat_name", chatName);
                intent1.putExtra("trial", false);

                utils.storeBoolean(UnlockStoriesActivity.this, chatName + "unlock", true);

                startActivity(intent1);
            }
        });
    }

    private void setTrialBtnClickListener() {
        Log.d(TAG, "setTrialBtnClickListener: ");
        trialBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: setTrialBtnClickListener");

                Intent intent1 = new Intent(UnlockStoriesActivity.this, ConversationActivity.class);
                intent1.putExtra("chat_name", chatName);
                intent1.putExtra("trial", true);

                utils.storeBoolean(UnlockStoriesActivity.this, chatName + "trial", true);

                startActivity(intent1);
            }
        });

    }
}
