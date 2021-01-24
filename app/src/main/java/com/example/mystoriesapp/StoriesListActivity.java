package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class StoriesListActivity extends AppCompatActivity {
    private static final String TAG = "StoriesListActivity";
    //private Stories stories = new Stories();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_list);
        Log.d(TAG, "onCreate: started");

        findViewById(R.id.back_btn_stories_list_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void StoryClickedMethod(View v) {
        Log.d(TAG, "StoryClickedMethod: started");

        RelativeLayout layout = (RelativeLayout) v;
        String tag = layout.getTag().toString();

        Intent intent = new Intent(StoriesListActivity.this, UnlockStoriesActivity.class);

        switch (tag) {
            case "john":
                intent.putExtra("chat_name", "John");
                break;

            case "alice":
                intent.putExtra("chat_name", "Alice");
                break;

            case "charlie":
                intent.putExtra("chat_name", "Charlie");
                break;

            case "carl":
                intent.putExtra("chat_name", "Carl");
                break;

            case "kathy":
                intent.putExtra("chat_name", "Kathy");
                break;

            case "william":
                intent.putExtra("chat_name", "William");
                break;

            case "sam":
                intent.putExtra("chat_name", "Sam");
                break;

            case "alex":
                intent.putExtra("chat_name", "Alex");
                break;
        }


        new Utils().storeString(StoriesListActivity.this, "current_activity", "home");
        startActivity(intent);
    }
}
