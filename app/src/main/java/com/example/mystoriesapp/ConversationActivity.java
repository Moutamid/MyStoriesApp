package com.example.mystoriesapp;

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

    private int counter = 0;
    private Utils utils = new Utils();

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
        nextBtn.setOnClickListener(nextBtnClickListener());

        fillArrayListWithData();

        currentMessagesArrayList.add(completeMessagesArrayList.get(counter));

        initRecyclerView();

    }

    private View.OnClickListener nextBtnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: next Btn");

                counter++;

                // CHECKING IF CHAT MESSAGES ENDED OR NOT
                if (counter <= completeMessagesArrayList.size() - 1) {
                    String msg = completeMessagesArrayList.get(counter).getMsgText();
                    String msgUser = completeMessagesArrayList.get(counter).getMsgUser();

                    if (msgUser.equals("middle"))
                        showMiddleScreen(msg);

                     else
                        adapter.addMessage(new ChatMessage(msg, msgUser));

                } else
                    showMiddleScreen("CHAT ENDED");

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

    private void fillArrayListWithData() {
        //completeMessagesArrayList.add(new ChatMessage("5 minutes later", "middle"));
        //completeMessagesArrayList.add(new ChatMessage("fillArrayListWithData Hi", "me"));
        //completeMessagesArrayList.add(new ChatMessage("fillArrayListWithData Hi, how are you2", "bot"));
        Log.d(TAG, "fillArrayListWithData: started");

        Stories stories = new Stories();
        completeMessagesArrayList = stories.John();

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
