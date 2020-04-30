package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class StoriesListActivity extends AppCompatActivity {
    private static final String TAG = "StoriesListActivity";
    RelativeLayout layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_list);
        Log.d(TAG, "onCreate: started");

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.btn_stories_list_activity);
        this.layout = relativeLayout;
        relativeLayout.setTranslationY(200.0f);
        findViewById(R.id.lisa_chat_item_layout).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                StoriesListActivity.this.startActivity(new Intent(StoriesListActivity.this, UnlockStoriesActivity.class));
            }
        });
    }

    public void btnClicked(View view) {
        this.layout.animate().translationYBy(-200.0f).setDuration(300);
    }
}
