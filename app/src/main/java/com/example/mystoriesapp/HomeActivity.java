package com.example.mystoriesapp;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "ChatListActivity";

    private RecyclerView nmbrChatRecyclerView;
    private IncompleteChatAdapter incompleteChatAdapter;
    private RelativeLayout johnLayout, aliceLayout, charlieLayout, carlLayout, kathyLayout, williamLayout, samLayout, alexLayout, lastChatlayout;

    private Button funnyBtn, thrillerBtn, suspenseBtn, alienBtn;
    private ArrayList<String> names = new ArrayList<>();
    private Utils utils = new Utils();
    private TextView last_chat_name;

    private void fillNames(){

        names.clear();

        if (utils.getStoredString(HomeActivity.this, "john").equals("incomplete")
                || utils.getStoredString(HomeActivity.this, "john").equals("ended"))
            names.add("John");

        if (utils.getStoredString(HomeActivity.this, "charlie").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "charlie").equals("ended"))
            names.add("Charlie");

        if (utils.getStoredString(HomeActivity.this, "carl").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "carl").equals("ended"))
            names.add("Carl");

        if (utils.getStoredString(HomeActivity.this, "kathy").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "kathy").equals("ended"))
            names.add("Kathy");

        if (utils.getStoredString(HomeActivity.this, "alice").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "alice").equals("ended"))
            names.add("Alice");

        if (utils.getStoredString(HomeActivity.this, "william").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "william").equals("ended"))
            names.add("William");

        if (utils.getStoredString(HomeActivity.this, "sam").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "sam").equals("ended"))
            names.add("Sam");

        if (utils.getStoredString(HomeActivity.this, "alex").equals("incomplete")
        || utils.getStoredString(HomeActivity.this, "alex").equals("ended"))
            names.add("Alex");

    }

    private void initLayouts(){
        johnLayout = findViewById(R.id.john_layout_home);
        aliceLayout = findViewById(R.id.alice_layout_home);
        charlieLayout = findViewById(R.id.charlie_layout_home);
        carlLayout = findViewById(R.id.carl_layout_home);
        williamLayout = findViewById(R.id.william_layout_home);
        alexLayout = findViewById(R.id.alex_layout_home);
        samLayout = findViewById(R.id.sam_layout_home);
        kathyLayout = findViewById(R.id.kathy_layout_home);

        funnyBtn = findViewById(R.id.funny_btn_home);
        thrillerBtn = findViewById(R.id.thriller_btn_home);
        suspenseBtn = findViewById(R.id.suspense_btn_home);
        alienBtn = findViewById(R.id.alien_btn_home);

        nmbrChatRecyclerView =  findViewById(R.id.incomplete_chats_list_recyclerview);
        lastChatlayout = findViewById(R.id.last_chat_layout_home);
        last_chat_name = findViewById(R.id.last_chat_textview_home);
    }

    private void setClickListeners(){
        funnyBtn.setOnClickListener(funnyBtnClickListener());
        thrillerBtn.setOnClickListener(thrillerBtnClickListener());
        suspenseBtn.setOnClickListener(suspenseBtnClickListener());
        alienBtn.setOnClickListener(alienBtnClickListener());
        lastChatlayout.setOnClickListener(lastChatlayoutClickListener());
    }

    @Override
    protected void onResume() {
        super.onResume();
        fillNames();
        incompleteChatAdapter.notifyDataSetChanged();

        // Setting last chat name
        last_chat_name.setText(utils.getStoredString(HomeActivity.this, "last_chat"));
    }

    private OnClickListener lastChatlayoutClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {

                String tag = last_chat_name.getText().toString().toLowerCase();

                startUnlockStoryActivity(tag);
            }
        };
    }

    private void startUnlockStoryActivity(String tag) {
        Intent intent = new Intent(HomeActivity.this, UnlockStoriesActivity.class);

        switch (tag){
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

        startActivity(intent);
    }

    private OnClickListener alienBtnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {

                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.white));

                alexLayout.setVisibility(View.VISIBLE);
                samLayout.setVisibility(View.VISIBLE);

                funnyBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                funnyBtn.setTextColor(getResources().getColor(R.color.orange));
                thrillerBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                thrillerBtn.setTextColor(getResources().getColor(R.color.orange));
                suspenseBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                suspenseBtn.setTextColor(getResources().getColor(R.color.orange));


                johnLayout.setVisibility(View.GONE);
                aliceLayout.setVisibility(View.GONE);
                kathyLayout.setVisibility(View.GONE);
                williamLayout.setVisibility(View.GONE);
                charlieLayout.setVisibility(View.GONE);
                carlLayout.setVisibility(View.GONE);

            }
        };
    }

    private OnClickListener suspenseBtnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {

                suspenseBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                suspenseBtn.setTextColor(getResources().getColor(R.color.white));

                charlieLayout.setVisibility(View.VISIBLE);
                carlLayout.setVisibility(View.VISIBLE);

                funnyBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                funnyBtn.setTextColor(getResources().getColor(R.color.orange));
                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.orange));
                thrillerBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                thrillerBtn.setTextColor(getResources().getColor(R.color.orange));


                johnLayout.setVisibility(View.GONE);
                aliceLayout.setVisibility(View.GONE);
                alexLayout.setVisibility(View.GONE);
                samLayout.setVisibility(View.GONE);
                kathyLayout.setVisibility(View.GONE);
                williamLayout.setVisibility(View.GONE);


            }
        };
    }

    private OnClickListener thrillerBtnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {

                thrillerBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                thrillerBtn.setTextColor(getResources().getColor(R.color.white));

                kathyLayout.setVisibility(View.VISIBLE);
                williamLayout.setVisibility(View.VISIBLE);

                funnyBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                funnyBtn.setTextColor(getResources().getColor(R.color.orange));
                suspenseBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                suspenseBtn.setTextColor(getResources().getColor(R.color.orange));
                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.orange));

                charlieLayout.setVisibility(View.GONE);
                johnLayout.setVisibility(View.GONE);
                aliceLayout.setVisibility(View.GONE);
                carlLayout.setVisibility(View.GONE);
                alexLayout.setVisibility(View.GONE);
                samLayout.setVisibility(View.GONE);

            }
        };
    }

    private OnClickListener funnyBtnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View view) {

                funnyBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                funnyBtn.setTextColor(getResources().getColor(R.color.white));

                johnLayout.setVisibility(View.VISIBLE);
                aliceLayout.setVisibility(View.VISIBLE);

                thrillerBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                thrillerBtn.setTextColor(getResources().getColor(R.color.orange));
                suspenseBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                suspenseBtn.setTextColor(getResources().getColor(R.color.orange));
                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.orange));

                charlieLayout.setVisibility(View.GONE);
                carlLayout.setVisibility(View.GONE);
                kathyLayout.setVisibility(View.GONE);
                williamLayout.setVisibility(View.GONE);
                alexLayout.setVisibility(View.GONE);
                samLayout.setVisibility(View.GONE);
            }
        };
    }

    public void HomeStoryClickedMethod(View v){
        Log.d(TAG, "HomeStoryClickedMethod: started");

        RelativeLayout layout = (RelativeLayout) v;
        String tag = layout.getTag().toString();

        startUnlockStoryActivity(tag);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started");

        if (utils.getStoredString(HomeActivity.this, "current_activity").equals("stories")){
            finish();
            startActivity(new Intent(HomeActivity.this, StoriesListActivity.class));
            return;
        }

        if (utils.getStoredString(HomeActivity.this, "current_activity").equals("main")){
            finish();
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            return;
        }
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        fillNames();
        initLayouts();
        setClickListeners();

        TextView username = findViewById(R.id.user_name_textview_home);

        // Setting user name
        username.setText(utils.getStoredString(HomeActivity.this, "username"));

        // Setting last chat name
        last_chat_name.setText(utils.getStoredString(HomeActivity.this, "last_chat"));

        findViewById(R.id.showAllStoriesBtnChatList).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, StoriesListActivity.class));
            }
        });

        setIncompleteChatsRecyclerView();

        YoYo.with(Techniques.StandUp).duration(800).onEnd(new YoYo.AnimatorCallback() {
            @Override
            public void call(Animator animator) {
                YoYo.with(Techniques.Shake).duration(800).delay(5000).playOn(lastChatlayout);
            }
        }).playOn(lastChatlayout);

        YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(username);

    }

    private void setIncompleteChatsRecyclerView() {
        Log.d(TAG, "setIncompleteChatsRecyclerView: started");

        incompleteChatAdapter = new IncompleteChatAdapter();
        this.nmbrChatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.nmbrChatRecyclerView.setHasFixedSize(true);
        this.nmbrChatRecyclerView.setNestedScrollingEnabled(false);
        this.nmbrChatRecyclerView.setAdapter(incompleteChatAdapter);

        if (incompleteChatAdapter.getItemCount() == 0)
            findViewById(R.id.recent_chats_layout_home).setVisibility(View.GONE);
    }

    private class IncompleteChatAdapter extends Adapter<IncompleteChatAdapter.ViewHolderChats> {

        public class ViewHolderChats extends RecyclerView.ViewHolder {
            RelativeLayout layout;
            TextView name;

            public ViewHolderChats(View v) {
                super(v);

                layout = v.findViewById(R.id.parent_layout_chats);
                name = v.findViewById(R.id.chat_name_layout_chats);
            }
        }

        public ViewHolderChats onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolderChats(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_chats, parent, false));
        }

        public void onBindViewHolder(ViewHolderChats holder, final int position) {

            holder.name.setText(names.get(position));
            holder.layout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = names.get(position);
                    startUnlockStoryActivity(name.toLowerCase());
                }
            });

        }

        public int getItemCount() {
            if (names == null)
                return 0;

            return names.size();
        }
    }

}
