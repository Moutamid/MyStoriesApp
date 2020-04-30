package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ChatListActivity extends AppCompatActivity {
    private static final String TAG = "ChatListActivity";

    private ChatsRecyclerViewAdapter nmbrChatAdapter;
    private RecyclerView nmbrChatRecyclerView;
    private StoriesRecyclerViewAdapter storiesChatAdapter;
    private RecyclerView storiesRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        Log.d(TAG, "onCreate: started");

        this.nmbrChatRecyclerView = (RecyclerView) findViewById(R.id.incomplete_chats_list_recyclerview);
        this.storiesRecyclerView = (RecyclerView) findViewById(R.id.stories_recyclerview);
        findViewById(R.id.showAllStoriesBtnChatList).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ChatListActivity.this.startActivity(new Intent(ChatListActivity.this, StoriesListActivity.class));
            }
        });
        setStoriesChatsRecyclerView();
        setIncompleteChatsRecyclerView();
    }

    private void setStoriesChatsRecyclerView() {
        Log.d(TAG, "setStoriesChatsRecyclerView: started");

        LinearLayoutManager layoutManagerUserOwn = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        this.storiesChatAdapter = new StoriesRecyclerViewAdapter();
        this.storiesRecyclerView.setLayoutManager(layoutManagerUserOwn);
        this.storiesRecyclerView.setHasFixedSize(true);
        this.storiesRecyclerView.setAdapter(this.storiesChatAdapter);
    }

    private void setIncompleteChatsRecyclerView() {
        Log.d(TAG, "setIncompleteChatsRecyclerView: started");

        this.nmbrChatAdapter = new ChatsRecyclerViewAdapter();
        this.nmbrChatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.nmbrChatRecyclerView.setHasFixedSize(true);
        this.nmbrChatRecyclerView.setNestedScrollingEnabled(false);
        this.nmbrChatRecyclerView.setAdapter(this.nmbrChatAdapter);
    }

    private class ChatsRecyclerViewAdapter extends Adapter<ChatsRecyclerViewAdapter.ViewHolderChats> {

        public class ViewHolderChats extends RecyclerView.ViewHolder {
            public ViewHolderChats(View v) {
                super(v);
            }
        }

        public ViewHolderChats onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolderChats(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_chats, parent, false));
        }

        public void onBindViewHolder(ViewHolderChats holder, int position) {
        }

        public int getItemCount() {
            return 5;
        }
    }

    private class StoriesRecyclerViewAdapter extends Adapter<StoriesRecyclerViewAdapter.ViewHolderStories> {

        public class ViewHolderStories extends RecyclerView.ViewHolder {
            public ViewHolderStories(View v) {
                super(v);
            }
        }

        public ViewHolderStories onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolderStories(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_stories_people, parent, false));
        }

        public void onBindViewHolder(ViewHolderStories holder, int position) {
        }

        public int getItemCount() {
            return 10;
        }
    }

}
