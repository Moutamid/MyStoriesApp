package com.example.mystoriesapp;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: started");

        if (utils.getStoredString(HomeActivity.this, "userName").equals("Error")) {
            finish();
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            return;
        }
        //startActivity(new Intent(HomeActivity.this, MainActivity.class));
        fillNames();
        initLayouts();
        setClickListeners();

        TextView username = findViewById(R.id.user_name_textview_home);

        // Setting user name
        username.setText(utils.getStoredString(HomeActivity.this, "username"));

        // Setting last chat name
        setLastChatLayoutDetails();

        findViewById(R.id.showAllStoriesBtnChatList).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, StoriesListActivity.class));
            }
        });

        setIncompleteChatsRecyclerView();

        if (utils.getStoredString
                (HomeActivity.this, last_chat_name.getText().toString().toLowerCase())
                .equals("incomplete")) {

            YoYo.with(Techniques.StandUp).duration(800).onEnd(new YoYo.AnimatorCallback() {
                @Override
                public void call(Animator animator) {
                    YoYo.with(Techniques.Shake).duration(800).delay(5000).playOn(lastChatlayout);
                }
            }).playOn(lastChatlayout);
        }

        YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(username);

    }

    private void setLastChatLayoutDetails() {

        last_chat_name.setText(utils.getStoredString(HomeActivity.this, "last_chat"));

        if (last_chat_name.getText().toString().equals("Error")) {
            finish();
            startActivity(new Intent(HomeActivity.this, StoriesListActivity.class));
            return;
        }

        ImageView profileImage = findViewById(R.id.last_chat_profile_img_home);

        switch (last_chat_name.getText().toString().toLowerCase()) {
            case "john":
                profileImage.setImageResource(R.drawable.john);
                break;

            case "alice":
                profileImage.setImageResource(R.drawable.alice);
                break;

            case "charlie":
                profileImage.setImageResource(R.drawable.charlie);
                break;

            case "carl":
                profileImage.setImageResource(R.drawable.carl);
                break;

            case "kathy":
                profileImage.setImageResource(R.drawable.kathy);
                break;

            case "william":
                profileImage.setImageResource(R.drawable.william);
                break;

            case "sam":
                profileImage.setImageResource(R.drawable.sam);
                break;

            case "alex":
                profileImage.setImageResource(R.drawable.alex);
                break;
        }
    }

    private void fillNames() {
        Log.d(TAG, "fillNames: ");

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

    private void initLayouts() {
        Log.d(TAG, "initLayouts: ");
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

        nmbrChatRecyclerView = findViewById(R.id.incomplete_chats_list_recyclerview);
        lastChatlayout = findViewById(R.id.last_chat_layout_home);
        last_chat_name = findViewById(R.id.last_chat_textview_home);
    }

    private void setClickListeners() {
        Log.d(TAG, "setClickListeners: ");
        funnyBtn.setOnClickListener(funnyBtnClickListener());
        thrillerBtn.setOnClickListener(thrillerBtnClickListener());
        suspenseBtn.setOnClickListener(suspenseBtnClickListener());
        alienBtn.setOnClickListener(alienBtnClickListener());
        lastChatlayout.setOnClickListener(lastChatlayoutClickListener());

        findViewById(R.id.credits_img_home_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                new AlertDialog.Builder(HomeActivity.this)
//                        .setMessage("Do you want to watch a video ad before showing credits?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
                // TODO: Show a video ad here before opening activity and un-comment these upper and below lines
                startActivity(new Intent(HomeActivity.this, DeveloperInfoActivity.class));
//                            }
//                        })
//                        .setCancelable(true)
//                        .show();
            }
        });
        findViewById(R.id.developer_info_img_home_activity).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                new AlertDialog.Builder(HomeActivity.this)
//                        .setMessage("Do you want to watch a video ad before showing developer information?")
////                        .setMessage("Do you want to watch a video ad before showing developer information?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
                // TODO: Show a video ad here before opening activity and un-comment these upper and below lines
                startActivity(new Intent(HomeActivity.this, DeveloperInfoActivity.class));
//                            }
//                        })
//                        .setCancelable(true)
//                        .show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

        fillNames();
        incompleteChatAdapter.notifyDataSetChanged();

        // Setting last chat name and image
        setLastChatLayoutDetails();
    }

    private OnClickListener lastChatlayoutClickListener() {
        Log.d(TAG, "lastChatlayoutClickListener: ");
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "lastChatlayoutClickListener onClick: ");

                String tag = last_chat_name.getText().toString().toLowerCase();

                startUnlockStoryActivity(tag);
            }
        };
    }

    private void startUnlockStoryActivity(String tag) {
        Log.d(TAG, "startUnlockStoryActivity: ");
        Intent intent = new Intent(HomeActivity.this, UnlockStoriesActivity.class);

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

        startActivity(intent);
    }

    private OnClickListener alienBtnClickListener() {
        Log.d(TAG, "alienBtnClickListener: ");
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: alienBtnClickListener");

                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.white));

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


                alexLayout.setVisibility(View.VISIBLE);
                samLayout.setVisibility(View.VISIBLE);

                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(alexLayout);
                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(samLayout);
            }
        };
    }

    private OnClickListener suspenseBtnClickListener() {
        Log.d(TAG, "suspenseBtnClickListener: ");
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: suspenseBtnClickListener");

                suspenseBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                suspenseBtn.setTextColor(getResources().getColor(R.color.white));

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

                charlieLayout.setVisibility(View.VISIBLE);
                carlLayout.setVisibility(View.VISIBLE);

                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(charlieLayout);
                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(carlLayout);
            }
        };
    }

    private OnClickListener thrillerBtnClickListener() {
        Log.d(TAG, "thrillerBtnClickListener: ");
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: thrillerBtnClickListener");

                thrillerBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                thrillerBtn.setTextColor(getResources().getColor(R.color.white));

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

                kathyLayout.setVisibility(View.VISIBLE);
                williamLayout.setVisibility(View.VISIBLE);

                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(kathyLayout);
                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(williamLayout);
            }
        };
    }

    private OnClickListener funnyBtnClickListener() {
        Log.d(TAG, "funnyBtnClickListener: ");
        return new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: funnyBtnClickListener");

                funnyBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                funnyBtn.setTextColor(getResources().getColor(R.color.white));

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

                johnLayout.setVisibility(View.VISIBLE);
                aliceLayout.setVisibility(View.VISIBLE);

                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(johnLayout);
                YoYo.with(Techniques.FadeInUp).duration(500).delay(500).playOn(aliceLayout);
            }
        };
    }

    public void HomeStoryClickedMethod(View v) {
        Log.d(TAG, "HomeStoryClickedMethod: started");

        RelativeLayout layout = (RelativeLayout) v;
        String tag = layout.getTag().toString();

        startUnlockStoryActivity(tag);
    }

    private void setIncompleteChatsRecyclerView() {
        Log.d(TAG, "setIncompleteChatsRecyclerView: started");

        incompleteChatAdapter = new IncompleteChatAdapter();
        this.nmbrChatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        this.nmbrChatRecyclerView.setHasFixedSize(true);
//        this.nmbrChatRecyclerView.setNestedScrollingEnabled(false);
        this.nmbrChatRecyclerView.setAdapter(incompleteChatAdapter);

        if (incompleteChatAdapter.getItemCount() == 0)
            findViewById(R.id.recent_chats_layout_home).setVisibility(View.GONE);
    }

    private class IncompleteChatAdapter extends Adapter<IncompleteChatAdapter.ViewHolderChats> {

        public class ViewHolderChats extends RecyclerView.ViewHolder {
            RelativeLayout layout;
            TextView name;
            ImageView profileImage, readStatus;

            public ViewHolderChats(View v) {
                super(v);

                layout = v.findViewById(R.id.parent_layout_chats);
                name = v.findViewById(R.id.chat_name_layout_chats);
                profileImage = v.findViewById(R.id.chat_profile_img_layout_chats);
                readStatus = v.findViewById(R.id.chat_read_status_layout_chats);
            }
        }

        public ViewHolderChats onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolderChats(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_chats, parent, false));
        }

        public void onBindViewHolder(ViewHolderChats holder, final int position) {

            holder.name.setText(names.get(position));

            switch (names.get(position).toLowerCase()) {
                case "john":
                    holder.profileImage.setImageResource(R.drawable.john);
                    break;

                case "alice":
                    holder.profileImage.setImageResource(R.drawable.alice);
                    break;

                case "charlie":
                    holder.profileImage.setImageResource(R.drawable.charlie);
                    break;

                case "carl":
                    holder.profileImage.setImageResource(R.drawable.carl);
                    break;

                case "kathy":
                    holder.profileImage.setImageResource(R.drawable.kathy);
                    break;

                case "william":
                    holder.profileImage.setImageResource(R.drawable.william);
                    break;

                case "sam":
                    holder.profileImage.setImageResource(R.drawable.sam);
                    break;

                case "alex":
                    holder.profileImage.setImageResource(R.drawable.alex);
                    break;
            }


            String status = utils.getStoredString(HomeActivity.this, names.get(position).toLowerCase());

            if (status.equals("incomplete"))
                holder.readStatus.setImageResource(R.drawable.ic_chat_incomplete);

            if (status.equals("ended"))
                holder.readStatus.setImageResource(R.drawable.ic_chat_completed);


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
