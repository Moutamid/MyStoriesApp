package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConversationActivity extends AppCompatActivity {
    private static final String TAG = "ConversationActivity";

    private int counter;
    private Utils utils = new Utils();
    private boolean isTrial = true;

    private TextView username, onlinestatus;
    private CircleImageView profileImage;
    private String chatName;

    private RecyclerView conversationRecyclerView;
    private RecyclerViewAdapterMessages adapter;

    private RelativeLayout middleLayout;
    private Button nextBtn;

    private ImageView backBtn;
    private ImageView infoBtn;

    private ArrayList<ChatMessage> currentMessagesArrayList = new ArrayList<>();
    private ArrayList<ChatMessage> completeMessagesArrayList = new ArrayList<>();

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");

        if (utils.getStoredBoolean(ConversationActivity.this, "first_convno")) {
            Log.d(TAG, "onBackPressed: if (utils.getStoredBoolean(ConversationActivity.this, \"first_convno\")){");

            Intent intent = new Intent(ConversationActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            utils.storeBoolean(ConversationActivity.this, "first_convno", false);
        } else super.onBackPressed();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        Log.d(TAG, "onCreate: started");

        initViews();

        fillCompleteArrayListWithData();

        showPreviousMsgs();

        initRecyclerView();

        utils.storeString(ConversationActivity.this, "last_chat", chatName);

    }

    private void initViews() {
        Log.d(TAG, "initViews: ");
        infoBtn = findViewById(R.id.menu_btn_conversation);
        nextBtn = findViewById(R.id.nxt_btn_conversation_activity);
        middleLayout = findViewById(R.id.middle_layout_conversation);
        username = findViewById(R.id.user_name_conversation);
        profileImage = findViewById(R.id.user_profile_image_conversation);
        onlinestatus = findViewById(R.id.online_status_text_conversation);
        backBtn = findViewById(R.id.back_btn_conversation);

        nextBtn.setOnClickListener(nextBtnClickListener());
        backBtn.setOnClickListener(backBtnClickListener());
        infoBtn.setOnClickListener(infoBtnClickListener());
    }

    private View.OnClickListener infoBtnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startUnlockStoryActivity(username.getText().toString().toLowerCase());
            }
        };
    }

    private void startUnlockStoryActivity(String tag) {
        Log.d(TAG, "startUnlockStoryActivity: ");
        Intent intent = new Intent(ConversationActivity.this, UnlockStoriesActivity.class);

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

    private View.OnClickListener backBtnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: backBtnClickListener");
                if (utils.getStoredBoolean(ConversationActivity.this, "first_convno")) {

                    Intent intent = new Intent(ConversationActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    finish();
                    startActivity(intent);
                    utils.storeBoolean(ConversationActivity.this, "first_convno", false);
                } else finish();
            }
        };
    }

    private void showPreviousMsgs() {
        Log.d(TAG, "showPreviousMsgs: ");

        counter = utils.getStoredInteger(ConversationActivity.this, chatName + "counter");
        //currentMessagesArrayList.add(completeMessagesArrayList.get(counter));
        Log.d(TAG, "showPreviousMsgs1: " + counter);

        int i = 0;
        do {

//            if (completeMessagesArrayList.get(i) != null)
            if (completeMessagesArrayList != null && completeMessagesArrayList.size() > 0) {

                if (!completeMessagesArrayList.get(i).getMsgUser().equals("middle"))
                currentMessagesArrayList.add(completeMessagesArrayList.get(i));
            }
            i++;

        } while (i <= counter);

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

                    counter--;

                    nextBtn.setTranslationY(400f);

                    utils.storeString(ConversationActivity.this, chatName.toLowerCase(), "ended");
                }

                utils.storeInteger(ConversationActivity.this, chatName + "counter", counter);
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

        Stories stories = new Stories(ConversationActivity.this);

        Intent intent = getIntent();

        if (intent.hasExtra("chat_name")) {

            chatName = intent.getStringExtra("chat_name");

            if (chatName == null) {
                Toast.makeText(this, "No chat exist!", Toast.LENGTH_SHORT).show();
                return;
            }

            username.setText(chatName);

            switch (chatName.toLowerCase()) {
                case "john":
                    completeMessagesArrayList = stories.JohnFunny();
                    profileImage.setImageResource(R.drawable.john);
                    break;

                case "alice":
                    completeMessagesArrayList = stories.AliceFunny();
                    profileImage.setImageResource(R.drawable.alice);
                    break;

                case "charlie":
                    completeMessagesArrayList = stories.CharlieSuspense();
                    profileImage.setImageResource(R.drawable.charlie);
                    break;

                case "carl":
                    completeMessagesArrayList = stories.CarlSuspense();
                    profileImage.setImageResource(R.drawable.carl);
                    break;

                case "kathy":
                    completeMessagesArrayList = stories.KathyThriller();
                    profileImage.setImageResource(R.drawable.kathy);
                    break;

                case "william":
                    completeMessagesArrayList = stories.WilliamThriller();
                    profileImage.setImageResource(R.drawable.william);
                    break;

                case "sam":
                    completeMessagesArrayList = stories.SamOther();
                    profileImage.setImageResource(R.drawable.sam);
                    break;

                case "alex":
                    completeMessagesArrayList = stories.AlexOther();
                    profileImage.setImageResource(R.drawable.alex);
                    break;
            }
        }

        if (intent.hasExtra("trial")) {
            Log.d(TAG, "fillCompleteArrayListWithData: if (intent.hasExtra(\"trial\")) {");

            isTrial = intent.getBooleanExtra("trial", true);

        }
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");

        conversationRecyclerView = findViewById(R.id.recyclerView_conversation);
        adapter = new RecyclerViewAdapterMessages();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setStackFromEnd(true);

        conversationRecyclerView.setLayoutManager(linearLayoutManager);
//        conversationRecyclerView.setHasFixedSize(true);
//        conversationRecyclerView.setNestedScrollingEnabled(false);

        conversationRecyclerView.setAdapter(adapter);

        scrollRecyclerViewToEnd();

    }

    private void scrollRecyclerViewToEnd() {
        Log.d(TAG, "scrollRecyclerViewToEnd: ");
        conversationRecyclerView.scrollToPosition(conversationRecyclerView.getAdapter().getItemCount() - 1);

    }

    private class RecyclerViewAdapterMessages extends RecyclerView.Adapter
            <RecyclerView.ViewHolder> {

//        @NonNull
//        @Override
//        public ViewHolderMessages onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//            Log.d(TAG, "onCreateViewHolder: ");
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_msg_left, parent, false);
//            return new ViewHolderMessages(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolderMessages holder, int position) {
//            Log.d(TAG, "onBindViewHolder: " + position);
//
//            if (currentMessagesArrayList.get(holder.getAdapterPosition()).getMsgUser().equals("me")) {
//
//                holder.rightText.setText(currentMessagesArrayList.get(holder.getAdapterPosition()).getMsgText());
//
//                holder.leftText.setVisibility(View.GONE);
//
//            } else {
//
//                holder.leftText.setText(currentMessagesArrayList.get(holder.getAdapterPosition()).getMsgText());
//
//                holder.rightText.setVisibility(View.GONE);
//            }
//
//        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            if (viewType == 1) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_msg_left, parent, false);
                return new ViewHolderLeftMessage(view);

            } else {
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_msg_right, parent, false);
                return new ViewHolderRightMessage(view1);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if (holder.getItemViewType() == 1) {
                ViewHolderLeftMessage holderLeftMessage = (ViewHolderLeftMessage) holder;
                holderLeftMessage.leftText.setText(currentMessagesArrayList.get(holder.getAdapterPosition()).getMsgText());
            } else {
                ViewHolderRightMessage holderRightMessage = (ViewHolderRightMessage) holder;
                holderRightMessage.rightText.setText(currentMessagesArrayList.get(holder.getAdapterPosition()).getMsgText());
            }

        }

        @Override
        public int getItemCount() {
            if (currentMessagesArrayList == null)
                return 0;
            return currentMessagesArrayList.size();
        }

        @Override
        public int getItemViewType(int position) {

            /*

             * 1 Left Message
             * 2 Right Message
             */

            if (currentMessagesArrayList.get(position).getMsgUser().equals("me")) {
                return 2;
            } else {
                return 1;
            }
        }

        public class ViewHolderLeftMessage extends RecyclerView.ViewHolder {

            TextView leftText;

            public ViewHolderLeftMessage(@NonNull View v) {
                super(v);
                leftText = v.findViewById(R.id.leftText);
            }
        }

        public class ViewHolderRightMessage extends RecyclerView.ViewHolder {

            TextView rightText;

            public ViewHolderRightMessage(@NonNull View v) {
                super(v);
                rightText = v.findViewById(R.id.rightText);
            }
        }

//        public class ViewHolderMessages extends RecyclerView.ViewHolder {
//
//            TextView leftText, rightText;
//            //LinearLayout rightTextLayout;
//
//            public ViewHolderMessages(@NonNull View v) {
//                super(v);
//
//                leftText = v.findViewById(R.id.leftText);
//                rightText = v.findViewById(R.id.rightText);
//                //  rightTextLayout = v.findViewById(R.id.rightTextLayout);
//            }
//        }

        public void addMessage(ChatMessage c) {
            Log.d(TAG, "addMessage: ");

            currentMessagesArrayList.add(c);

            notifyItemInserted(currentMessagesArrayList.size() - 1);

            scrollRecyclerViewToEnd();

        }

    }

}
