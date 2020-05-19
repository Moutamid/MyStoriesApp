package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConversationActivity extends AppCompatActivity {
    private static final String TAG = "ConversationActivity";

    private int counter;
    private Utils utils = new Utils();
    private boolean isTrial = true;

    private TextView username, onlinestatus;
    private String chatName;

    private RecyclerView conversationRecyclerView;
    private RecyclerViewAdapterMessages adapter;

    private RelativeLayout middleLayout;
    private Button nextBtn;

    private ArrayList<ChatMessage> currentMessagesArrayList = new ArrayList<>();
    private ArrayList<ChatMessage> completeMessagesArrayList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        Log.d(TAG, "onCreate: started");

        nextBtn = findViewById(R.id.nxt_btn_conversation_activity);
        middleLayout = findViewById(R.id.middle_layout_conversation);
        username = findViewById(R.id.user_name_conversation);
        onlinestatus = findViewById(R.id.online_status_text_conversation);

        nextBtn.setOnClickListener(nextBtnClickListener());

        fillCompleteArrayListWithData();

        showPreviousMsgs();

        initRecyclerView();

        utils.storeString(ConversationActivity.this, "last_chat", chatName);

    }

    private void showPreviousMsgs() {

        counter = utils.getStoredInteger(ConversationActivity.this, chatName+"counter");
        //currentMessagesArrayList.add(completeMessagesArrayList.get(counter));

        for (int i = 0; i <= counter; i++){

            currentMessagesArrayList.add(completeMessagesArrayList.get(i));

        }

    }

    private View.OnClickListener nextBtnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: next Btn");

                counter++;

                // CHECKING IF CHAT MESSAGES ENDED OR NOT
                if (counter <= completeMessagesArrayList.size() - 1) {

                    // Checking if chat is trial and if chat is half completed or not
                    if (isTrial && counter == completeMessagesArrayList.size() / 2) {

                        counter--;

                        //Showing Trial Finished Dialog
                        utils.showMessage(ConversationActivity.this, "Trial Ended!", "Your trial has ended. You need to watch a complete video ad to unlock the full story.");

                    } else {

                        String msg = completeMessagesArrayList.get(counter).getMsgText();
                        String msgUser = completeMessagesArrayList.get(counter).getMsgUser();

                        if (msgUser.equals("middle"))
                            showMiddleScreen(msg);
                        else
                            adapter.addMessage(new ChatMessage(msg, msgUser));

                        utils.storeString(ConversationActivity.this, chatName.toLowerCase(), "incomplete");
                    }

                } else {
                    showMiddleScreen("CHAT ENDED");
                    onlinestatus.setText("Offline");
                    onlinestatus.setTextColor(getResources().getColor(R.color.red));

                    utils.storeString(ConversationActivity.this, chatName.toLowerCase(), "ended");
                }

                utils.storeInteger(ConversationActivity.this, chatName+"counter", counter);
            }
        };
    }

    private void showMiddleScreen(String msg) {
        Log.d(TAG, "showMiddleScreen");

        TextView middleScreenText = findViewById(R.id.middle_msg_textview);
        middleScreenText.setText(msg);
        nextBtn.setTranslationY(400f);

        middleLayout.animate().alpha(1).setDuration(1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                middleLayout.animate().alpha(0).setDuration(1500);
                nextBtn.animate().translationYBy(-400f).setDuration(400);
            }
        }, 3000);
    }

    private void fillCompleteArrayListWithData() {
        //completeMessagesArrayList.add(new ChatMessage("5 minutes later", "middle"));
        //completeMessagesArrayList.add(new ChatMessage("fillArrayListWithData Hi", "me"));
        //completeMessagesArrayList.add(new ChatMessage("fillArrayListWithData Hi, how are you2", "bot"));
        Log.d(TAG, "fillArrayListWithData: started");

        Stories stories = new Stories();

        Intent intent = getIntent();

        if (intent.hasExtra("chat_name")) {

            chatName = intent.getStringExtra("chat_name");
            username.setText(chatName);

            switch (chatName.toLowerCase()) {
                case "john":
                    completeMessagesArrayList = stories.JohnFunny();
                    break;

                case "alice":
                    completeMessagesArrayList = stories.AliceFunny();
                    break;

                case "charlie":
                    completeMessagesArrayList = stories.CharlieSuspense();
                    break;

                case "carl":
                    completeMessagesArrayList = stories.CarlSuspense();
                    break;

                case "kathy":
                    completeMessagesArrayList = stories.KathyThriller();
                    break;

                case "william":
                    completeMessagesArrayList = stories.WilliamThriller();
                    break;

                case "sam":
                    completeMessagesArrayList = stories.SamOther();
                    break;

                case "alex":
                    completeMessagesArrayList = stories.AlexOther();
                    break;
            }
        }

        if (intent.hasExtra("trial")) {

            isTrial = intent.getBooleanExtra("trial", true);

        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");

        conversationRecyclerView = findViewById(R.id.recyclerView_conversation);
        adapter = new RecyclerViewAdapterMessages();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setStackFromEnd(true);

        conversationRecyclerView.setLayoutManager(linearLayoutManager);
        conversationRecyclerView.setHasFixedSize(true);
        conversationRecyclerView.setNestedScrollingEnabled(false);

        conversationRecyclerView.setAdapter(adapter);

        scrollRecyclerViewToEnd();

    }

    private void scrollRecyclerViewToEnd() {
        conversationRecyclerView.scrollToPosition(conversationRecyclerView.getAdapter().getItemCount() - 1);
    }

    private class RecyclerViewAdapterMessages extends RecyclerView.Adapter
            <RecyclerViewAdapterMessages.ViewHolderMessages> {

        @NonNull
        @Override
        public ViewHolderMessages onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            Log.d(TAG, "onCreateViewHolder: ");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_msgs, parent, false);
            return new ViewHolderMessages(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderMessages holder, int position) {
            Log.d(TAG, "onBindViewHolder: " + position);

            if (currentMessagesArrayList.get(position).getMsgUser().equals("me")) {

                holder.rightText.setText(currentMessagesArrayList.get(position).getMsgText());

                holder.leftText.setVisibility(View.GONE);

            } else {

                holder.leftText.setText(currentMessagesArrayList.get(position).getMsgText());

                holder.rightText.setVisibility(View.GONE);
            }

        }

        @Override
        public int getItemCount() {
            if (currentMessagesArrayList == null)
                return 0;
            return currentMessagesArrayList.size();
        }

        public class ViewHolderMessages extends RecyclerView.ViewHolder {

            TextView leftText, rightText;
            //LinearLayout rightTextLayout;

            public ViewHolderMessages(@NonNull View v) {
                super(v);

                leftText = v.findViewById(R.id.leftText);
                rightText = v.findViewById(R.id.rightText);
                //  rightTextLayout = v.findViewById(R.id.rightTextLayout);
            }
        }

        public void addMessage(ChatMessage c) {

            currentMessagesArrayList.add(c);

            notifyItemInserted(currentMessagesArrayList.size() - 1);

            scrollRecyclerViewToEnd();

        }

    }

}
