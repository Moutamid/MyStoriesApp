package com.example.mystoriesapp;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConversationActivity extends AppCompatActivity {
    private static final String TAG = "ConversationActivity";

    //private ArrayList<String> chatList = new ArrayList<>();

    private Handler handler;
    int counter = 0;

    private Button nextBtn;
    private ImageView myMsgStatusImg;
    private RecyclerView nmbrChatRecyclerView;
    private RecyclerViewAdapterMessages adapter;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<ChatMessage> messagesArrayList = new ArrayList<>();
    private ArrayList<ChatMessage> chatFullList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        Log.d(TAG, "onCreate: started");

        nextBtn = findViewById(R.id.nxt_btn_conversation_activity);
        myMsgStatusImg = findViewById(R.id.myMessageStatus);
        nextBtn.setOnClickListener(nextBtnClickListener());

        handler = new Handler();

        fillArrayListWithData();
        messagesArrayList.add(new ChatMessage("fillArrayListWithData Hi", "user"));
        initRecyclerView();

        setMyMsgStatusImg();
        disableNextBtnFor3Secs();

//        ChatsRecyclerViewAdapter nmbrChatAdapter = new ChatsRecyclerViewAdapter();
//
//        nmbrChatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        nmbrChatRecyclerView.setHasFixedSize(true);
//
//        nmbrChatRecyclerView.setNestedScrollingEnabled(false);
//
//        nmbrChatRecyclerView.setAdapter(nmbrChatAdapter);
    }

    private View.OnClickListener nextBtnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: next Btn");

                counter++;

                if (counter <= chatFullList.size() - 1) {
                    String msg = chatFullList.get(counter).getMsgText();
                    String msgUser = chatFullList.get(counter).getMsgUser();

                    adapter.addMessage(new ChatMessage(msg, msgUser));

                    if (msgUser.equals("user")) {
                        setMyMsgStatusImg();
                        disableNextBtnFor3Secs();
                    }

                } else
                    Toast.makeText(ConversationActivity.this, "Chat ended", Toast.LENGTH_SHORT).show();


            }
        };
    }

    private void disableNextBtnFor3Secs(){
        nextBtn.setEnabled(false);
        nextBtn.setTranslationY(400f);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextBtn.animate().translationYBy(-400f).setDuration(100);
                nextBtn.setEnabled(true);
            }
        }, 3100);
    }

    private void setMyMsgStatusImg() {
        Log.d(TAG, "setMyMsgStatusImg: ");

        myMsgStatusImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_circle_blue));

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: handler.postDelayed");
                myMsgStatusImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_delivered_circle));
                setDeliveredImage();
            }
        }, 1000);

    }

    private void setDeliveredImage() {
        Log.d(TAG, "setDeliveredImage: ");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: handler.postDelayed");
                myMsgStatusImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_double_tick_blue));
                setSeenImage();
            }
        }, 1000);

    }

    private void setSeenImage() {
        Log.d(TAG, "setSeenImage: ");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: handler.postDelayed");
                myMsgStatusImg.setImageDrawable(getResources().getDrawable(R.drawable.image));

                Toast.makeText(ConversationActivity.this, "Timer ended", Toast.LENGTH_SHORT).show();
                //uploadMessageAndGetResponse(message);
                //sharedPreferences.edit().putString("msgStatus", "true").apply();
            }
        }, 1000);

    }


    private void fillArrayListWithData() {
        Log.d(TAG, "fillArrayListWithData: started");

        chatFullList.add(new ChatMessage("fillArrayListWithData Hi", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi, how are you2", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi3", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi4", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi5", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi6", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi7", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi8", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi9", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi1", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi2", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi3", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi4", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi5", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi6", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi7", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi8", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi9", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi, how are you2", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi3", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi4", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi5", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi6", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi7", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi8", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi9", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi1", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi2", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi3", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi4", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi5", "bot"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi6", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi7", "user"));
        chatFullList.add(new ChatMessage("fillArrayListWithData Hi8", "bot"));
        chatFullList.add(new ChatMessage("Hello how are you? Hi9", "bot"));
        chatFullList.add(new ChatMessage("Last Message", "user"));


//        String str = "alice Hi";
//        this.chatList.add(str);
//        String str2 = "john Hi 2";
//        this.chatList.add(str2);
//        String str3 = "alice Hi, how are you?";
//        this.chatList.add(str3);
//        String str4 = "john Hi, how are you 2?";
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add(str);
//        this.chatList.add(str2);
//        this.chatList.add(str3);
//        this.chatList.add(str4);
//        this.chatList.add("middle");

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");

        nmbrChatRecyclerView = findViewById(R.id.recyclerView_conversation);
        adapter = new RecyclerViewAdapterMessages();

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);

        nmbrChatRecyclerView.setLayoutManager(linearLayoutManager);
        nmbrChatRecyclerView.setHasFixedSize(true);
        nmbrChatRecyclerView.setNestedScrollingEnabled(false);

        nmbrChatRecyclerView.setAdapter(adapter);

        scrollRecyclerViewToEnd();

        //recyclerViewConversation.addOnScrollListener(new RecyclerView.OnScrollListener() {
        //            @Override
        //            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        //                super.onScrolled(recyclerView, dx, dy);
        //
        //                if (!ConversationActivity.this.recyclerViewConversation.canScrollVertically(1)) {
        //
        //                    Log.d(TAG, "onScrolled: onScrolledToBottom");
        //
        //                    scrollBtn.setVisibility(View.GONE);
        //                }
        //
        //                if (dy < 0) {
        //
        //                    Log.d(TAG, "onScrolled: onScrollUp");
        //
        //                    scrollBtn.setVisibility(View.VISIBLE);
        //
        //                }
        //            }
        //        });

    }

    private void scrollRecyclerViewToEnd(){
        nmbrChatRecyclerView.scrollToPosition(nmbrChatRecyclerView.getAdapter().getItemCount() - 1);
    }

    private class ChatMessage {

        private String msgText;
        private String msgUser;

        public ChatMessage(String msgText, String msgUser) {
            this.msgText = msgText;
            this.msgUser = msgUser;

        }

        public ChatMessage() {
        }

        public String getMsgText() {
            return msgText;
        }

        public void setMsgText(String msgText) {
            this.msgText = msgText;
        }

        public String getMsgUser() {
            return msgUser;
        }

        public void setMsgUser(String msgUser) {
            this.msgUser = msgUser;
        }
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

            //holder.receivedImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.boy));

//            if (msgUser.get(position).equals("user")) {
            if (messagesArrayList.get(position).getMsgUser().equals("user")) {

                holder.rightText.setText(messagesArrayList.get(position).getMsgText());

                holder.rightText.setVisibility(View.VISIBLE);
                holder.leftText.setVisibility(View.GONE);

            } else {

                holder.leftText.setText(messagesArrayList.get(position).getMsgText());

                holder.rightText.setVisibility(View.GONE);
                holder.leftText.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public int getItemCount() {
            if (messagesArrayList == null)
                return 0;
            return messagesArrayList.size();
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

            messagesArrayList.add(c);

            notifyItemInserted(messagesArrayList.size() - 1);

            scrollRecyclerViewToEnd();

        }

    }

//    private class ChatsRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
//        private ChatsRecyclerViewAdapter() {
//        }
//
//        public int getItemViewType(int position) {
//
//            int viewType = 1;
//
//            if (chatList == null || chatList.get(position) == null) {
//                Log.d(TAG, "getItemViewType: NULL");
//
//            }
//            if ((chatList.get(position)).equals("alice")) {
//                Log.d(TAG, "getItemViewType: alice");
//                //viewType = 1;
//
//            }
//            if ((chatList.get(position)).equals("john")) {
//
//                viewType = 2;
//
//            }
//            if ((chatList.get(position)).equals("middle")) {
//
//                viewType = 3;
//
//            }
//            return viewType;
//        }
//
//        public int getItemCount() {
//            return chatList.size();
//        }
//
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            Log.d(TAG, "onCreateViewHolder: started");
//
//            ViewHolder viewHolder = new ViewHolderMiddle(parent);
//
//            if (viewType == 1) {
//
//                viewHolder = new ViewHolderRight(
//                        LayoutInflater.from(parent.getContext())
//                                .inflate(R.layout.layout_msg_right, parent, false));
//
//            }
//            if (viewType == 2) {
//
//                viewHolder = new ViewHolderLeft(
//                        LayoutInflater.from(parent.getContext())
//                                .inflate(R.layout.layout_msg_left, parent, false));
//
//            }
//            if (viewType == 3) {
//                Log.d(TAG, "onCreateViewHolder: viewType 2 (Middle)");
//                viewHolder = new ViewHolderMiddle(
//                        LayoutInflater.from(parent.getContext())
//                                .inflate(R.layout.layout_msg_left, parent, false));
//            }
////            } else if (viewType == 4){
////                Log.d(TAG, "onCreateViewHolder: NULL");
////
////            }
//
//            return viewHolder;
//        }
//
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            int itemViewType = holder.getItemViewType();
//
//            if (itemViewType == 1) {
//                Log.d(TAG, "onBindViewHolder: itemViewType " + 1);
//
//                ViewHolderRight holderRight = (ViewHolderRight) holder;
//                holderRight.rightTextView.setText((chatList.get(position)).replace("alice", "").trim());
//
//            } else if (itemViewType == 2) {
//                Log.d(TAG, "onBindViewHolder: itemViewType " + 2);
//
//                ViewHolderLeft holderLeft = (ViewHolderLeft) holder;
//                holderLeft.leftTextView.setText((chatList.get(position)).replace("john", "").trim());
//
//            } else if (itemViewType == 3) {
//                Log.d(TAG, "onBindViewHolder: itemViewType " + 3);
//
//                final RelativeLayout layout = findViewById(R.id.middle_layout_conversation);
//                layout.setVisibility(View.VISIBLE);
////                layout.animate().alpha(1.0f).setDuration(500).setListener(new AnimatorListener() {
////                    public void onAnimationStart(Animator animation) {
////                    }
////
////                    public void onAnimationEnd(Animator animation) {
////                        Log.d(TAG, "onAnimationEnd: started");
////                        layout.animate().alpha(0.0f).setDuration(500);
////                    }
////
////                    public void onAnimationCancel(Animator animation) {
////                    }
////
////                    public void onAnimationRepeat(Animator animation) {
////                    }
////                });
//            } else {
//                Log.d(TAG, "onBindViewHolder: Showing No Data Dialog");
//
//                Utils utils = new Utils();
//                utils.showMessage(ConversationActivity.this, "Alert!", "Sorry no Data Found!");
//
//            }
//
//            Log.d(TAG, "onBindViewHolder: running at " + position);
//        }
//
//        class ViewHolderLeft extends ViewHolder {
//            TextView leftTextView;
//
//            public ViewHolderLeft(View v) {
//                super(v);
//                this.leftTextView = (TextView) v.findViewById(R.id.leftText);
//            }
//        }
//
//        class ViewHolderMiddle extends ViewHolder {
//            public ViewHolderMiddle(View v) {
//                super(v);
//            }
//        }
//
//        class ViewHolderRight extends ViewHolder {
//            TextView rightTextView;
//
//            public ViewHolderRight(View v) {
//                super(v);
//                this.rightTextView = (TextView) v.findViewById(R.id.rightText);
//            }
//        }
//
//    }

}
