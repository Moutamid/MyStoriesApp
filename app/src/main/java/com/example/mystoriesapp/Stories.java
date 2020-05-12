package com.example.mystoriesapp;

import android.util.Log;

import java.util.ArrayList;

public class Stories {
    private static final String TAG = "Stories";
    
    public ArrayList<ChatMessage> John(){
        Log.d(TAG, "john: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm john \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("How are you?", "bot"));
        msgs.add(new ChatMessage("My lawyer says I don’t have to answer that question \uD83E\uDD2D", "me"));
        msgs.add(new ChatMessage("Lawyer??", "bot"));
        msgs.add(new ChatMessage("Which lawyer \uD83E\uDD14\uD83E\uDD14", "bot"));
        msgs.add(new ChatMessage("Do you really care?", "me"));
        msgs.add(new ChatMessage("No \uD83D\uDE02 ", "bot"));
        msgs.add(new ChatMessage("Go to hell ", "bot"));
        msgs.add(new ChatMessage("No one cares for me \uD83D\uDE2D\uD83D\uDE2D", "me"));
        msgs.add(new ChatMessage("Bro, take it easy!", "bot"));
        msgs.add(new ChatMessage("Guess what!", "bot"));
        msgs.add(new ChatMessage("You're single & I'm single too", "bot"));
        msgs.add(new ChatMessage("You know what that means?", "bot"));
        msgs.add(new ChatMessage("What?", "me"));
        msgs.add(new ChatMessage("We're both ugly! \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("Stop it \uD83D\uDE02", "me"));
        
        return msgs;
    }

    public ArrayList<ChatMessage> Alice(){
        Log.d(TAG, "Alice: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Alice \uD83D\uDE02", "bot"));

        return msgs;
    }

    public ArrayList<ChatMessage> Charlie(){
        Log.d(TAG, "Charlie: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Charlie \uD83D\uDE02", "bot"));

        return msgs;
    }
    
}
