package com.example.mystoriesapp;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class Stories {
    private static final String TAG = "Stories";

    private Utils utils = new Utils();
    private Context context;

    public Stories(Context context) {
        this.context = context;
    }

    public ArrayList<ChatMessage> JohnFunny() {
        Log.d(TAG, "john: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("She wants to get married!", "bot"));
        msgs.add(new ChatMessage("who?", "me"));
        msgs.add(new ChatMessage("that tinder girl? the one on dating site?", "me"));
        msgs.add(new ChatMessage("you told me yesterday", "me"));
        msgs.add(new ChatMessage("yeah", "bot"));
        msgs.add(new ChatMessage("what should i do?", "bot"));
        msgs.add(new ChatMessage("isn't she lie 50?", "me"));
        msgs.add(new ChatMessage("52*", "bot"));
        msgs.add(new ChatMessage("and you are....", "me"));
        msgs.add(new ChatMessage("25 next month", "bot"));
        msgs.add(new ChatMessage("cool cool", "me"));
        msgs.add(new ChatMessage("I know we're just coworkers", "me"));
        msgs.add(new ChatMessage("BUT THAT SOUNDS CRAZY", "me"));
        msgs.add(new ChatMessage("I know it does...", "bot"));
        msgs.add(new ChatMessage("What should i do?", "bot"));
        msgs.add(new ChatMessage("why are you asking me?", "me"));
        msgs.add(new ChatMessage("Ur the only one i told about her", "bot"));
        msgs.add(new ChatMessage("i didnt tell any of my friends", "bot"));
        msgs.add(new ChatMessage("because they'd just be annoying", "bot"));
        msgs.add(new ChatMessage("i mean she's DOUBLE your age!", "me"));
        msgs.add(new ChatMessage("She's great though", "bot"));
        msgs.add(new ChatMessage("totally gets me", "bot"));
        msgs.add(new ChatMessage("yeah but", "me"));
        msgs.add(new ChatMessage("you are so young", "me"));
        msgs.add(new ChatMessage("didn't you say she has kids?", "me"));
        msgs.add(new ChatMessage("Yeah a son. He's my age", "bot"));
        msgs.add(new ChatMessage("But they don't talk that much", "bot"));
        msgs.add(new ChatMessage("HE'S YOUR AGE?", "me"));
        msgs.add(new ChatMessage("Does that matter?", "bot"));
        msgs.add(new ChatMessage("IT KINDA DOES", "me"));
        msgs.add(new ChatMessage("So you think i should say no?", "bot"));
        msgs.add(new ChatMessage("Even if i love her?", "bot"));
        msgs.add(new ChatMessage("you really love her?", "me"));
        msgs.add(new ChatMessage("i do. She's amazing", "bot"));
        msgs.add(new ChatMessage("then i think you should marry her", "me"));
        msgs.add(new ChatMessage("really?", "bot"));
        msgs.add(new ChatMessage("so what if she's a little older?", "me"));
        msgs.add(new ChatMessage("If she makes you happy and you make her happy, that's all that matters", "me"));
        msgs.add(new ChatMessage("What if people judge us?", "bot"));
        msgs.add(new ChatMessage("Just ignore them", "me"));
        msgs.add(new ChatMessage("Love is a rare thing", "me"));
        msgs.add(new ChatMessage("you are lucky you found her!", "me"));
        msgs.add(new ChatMessage("You're right", "bot"));
        msgs.add(new ChatMessage("okay im gonna text her", "bot"));
        msgs.add(new ChatMessage("and from what you've told me ", "me"));
        msgs.add(new ChatMessage("You have UNREAL chemistry", "me"));
        msgs.add(new ChatMessage("Oh yeah she's a freak", "bot"));
        msgs.add(new ChatMessage("", "bot"));


        //        msgs.add(new ChatMessage("Hey " + utils.getStoredString(context, "userName"), "bot"));
//        msgs.add(new ChatMessage("I'm john", "bot"));
//        msgs.add(new ChatMessage("How are you?", "bot"));
//        msgs.add(new ChatMessage("5 minutes later", "middle"));
//        msgs.add(new ChatMessage("My lawyer says I don’t have to answer that question \uD83E\uDD2D", "me"));
//        msgs.add(new ChatMessage("Lawyer??", "bot"));
//        msgs.add(new ChatMessage("Which lawyer \uD83E\uDD14\uD83E\uDD14", "bot"));
//        msgs.add(new ChatMessage("Do you really care?", "me"));
//        msgs.add(new ChatMessage("No", "bot"));
//        msgs.add(new ChatMessage("Go to hell \uD83D\uDE02", "bot"));
//        msgs.add(new ChatMessage("No one cares for me \uD83D\uDE2D\uD83D\uDE2D", "me"));
//        msgs.add(new ChatMessage("Bro, take it easy!", "bot"));
//        //msgs.add(new ChatMessage("10 minutes later", "middle"));
//        msgs.add(new ChatMessage("Guess what!", "bot"));
//        msgs.add(new ChatMessage("You're single & I'm single too", "bot"));
//        msgs.add(new ChatMessage("You know what that means?", "bot"));
//        msgs.add(new ChatMessage("What?", "me"));
//        //msgs.add(new ChatMessage("15 minutes later", "middle"));
//        msgs.add(new ChatMessage("We're both ugly! \uD83D\uDE02", "bot"));
//        msgs.add(new ChatMessage("Stop it \uD83D\uDE02", "me"));

        return msgs;
    }

    public ArrayList<ChatMessage> AliceFunny() {
        Log.d(TAG, "Alice: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hey " + utils.getStoredString(context, "userName"), "bot"));
        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("I think we should breakup...", "bot"));
        msgs.add(new ChatMessage("what", "me"));
        msgs.add(new ChatMessage("im sorry. its over", "bot"));
        msgs.add(new ChatMessage("WHY", "me"));
        msgs.add(new ChatMessage("I hope we can still be friends", "bot"));
        msgs.add(new ChatMessage("NO WAIT", "me"));
        msgs.add(new ChatMessage("please dont try to call me", "bot"));
        msgs.add(new ChatMessage("i dont want to talk", "bot"));
        msgs.add(new ChatMessage("WHAT?", "me"));
        msgs.add(new ChatMessage("UR JUST GONNA DUMP ME", "me"));
        msgs.add(new ChatMessage("OVER THE MESSAGE???", "me"));
        msgs.add(new ChatMessage("its better this way", "bot"));
        msgs.add(new ChatMessage("trust me", "bot"));
        msgs.add(new ChatMessage("i dont understand", "me"));
        msgs.add(new ChatMessage("atleast give me reason", "me"));
        msgs.add(new ChatMessage("i could give you my reasons", "bot"));
        msgs.add(new ChatMessage("but it wouldnt make you feel better", "bot"));
        msgs.add(new ChatMessage("are you serous???", "me"));
        msgs.add(new ChatMessage("please dont be upset", "bot"));
        msgs.add(new ChatMessage("upset??", "me"));
        msgs.add(new ChatMessage("we just had a great dinner together", "me"));
        msgs.add(new ChatMessage("you came over to my house", "bot"));
        msgs.add(new ChatMessage("hung out with my family", "me"));
        msgs.add(new ChatMessage("and then right after you leave...", "me"));
        msgs.add(new ChatMessage("YOU DUMP ME OVER TEXT??", "me"));
        msgs.add(new ChatMessage("yup", "bot"));
        msgs.add(new ChatMessage("IM COMING OVER", "me"));
        msgs.add(new ChatMessage("no please dont!", "bot"));
        msgs.add(new ChatMessage("right now i just need space", "bot"));
        msgs.add(new ChatMessage("the give me a reason??", "me"));
        msgs.add(new ChatMessage("is it something i did?", "me"));
        msgs.add(new ChatMessage("omg fine", "bot"));
        msgs.add(new ChatMessage("u really want to know the reason?", "bot"));
        msgs.add(new ChatMessage("YES", "me"));
        msgs.add(new ChatMessage("im in love with someone else", "bot"));//TODO: CHANGE GENDER
        msgs.add(new ChatMessage("WHAT", "me"));
        msgs.add(new ChatMessage("WHO??", "me"));
        msgs.add(new ChatMessage("cmon dont do this", "bot"));
        msgs.add(new ChatMessage("screw you!", "me"));
        msgs.add(new ChatMessage("im glad we're done", "me"));
        msgs.add(new ChatMessage("i dont need you!", "me"));
        msgs.add(new ChatMessage("im glad you're taking this well", "bot"));
        msgs.add(new ChatMessage("shutup!", "me"));
        msgs.add(new ChatMessage("k", "bot"));
        msgs.add(new ChatMessage("you think you're so cute?", "me"));
        msgs.add(new ChatMessage("but guess what??", "me"));
        msgs.add(new ChatMessage("last week, i found a new girl!", "me"));
        msgs.add(new ChatMessage("you cheated on me?", "bot"));
        msgs.add(new ChatMessage("yep", "me"));
        msgs.add(new ChatMessage("with who", "bot"));
        msgs.add(new ChatMessage("i dont have to tell you anything!", "me"));
        msgs.add(new ChatMessage("you are an ugly and creepy witch!", "me"));
        msgs.add(new ChatMessage("and guess what? she's more beautiful than you!", "me"));
        msgs.add(new ChatMessage("tell me who is she!", "bot"));
        msgs.add(new ChatMessage("why should i", "me"));
        msgs.add(new ChatMessage("you didnt tell me either!", "me"));
        msgs.add(new ChatMessage("fine", "bot"));
        msgs.add(new ChatMessage("if you tell me who is she", "bot"));
        msgs.add(new ChatMessage("i will tell who im in love with", "bot"));
        msgs.add(new ChatMessage("fine! she is Becca", "me"));
        msgs.add(new ChatMessage("who is Becca?", "bot"));
        msgs.add(new ChatMessage("oh shut up", "me"));
        msgs.add(new ChatMessage("you guys play soccer together", "me"));
        msgs.add(new ChatMessage("oh right lol", "bot"));
        msgs.add(new ChatMessage("now its your turn!", "me"));
        msgs.add(new ChatMessage("ok. you sure you wanna know?", "bot"));
        msgs.add(new ChatMessage("WHO IS HE?", "me"));
        msgs.add(new ChatMessage("its your brother", "bot"));
        msgs.add(new ChatMessage("what", "me"));
        msgs.add(new ChatMessage("yep", "bot"));
        msgs.add(new ChatMessage("my brother", "me"));
        msgs.add(new ChatMessage("my little brother?", "me"));
        msgs.add(new ChatMessage("ya. you shouldnt be surprised", "bot"));
        msgs.add(new ChatMessage("he's like a better version of you", "bot"));
        msgs.add(new ChatMessage("if you were'nt a loser lol", "bot"));
        msgs.add(new ChatMessage("my brother is 11", "me"));
        msgs.add(new ChatMessage("so what?", "bot"));
        msgs.add(new ChatMessage("he's already cooler than you", "bot"));
        msgs.add(new ChatMessage("and in a few years, he'll be awesome", "bot"));
        msgs.add(new ChatMessage("WHAT", "me"));
        msgs.add(new ChatMessage("think about it??", "bot"));
        msgs.add(new ChatMessage("he's great at video games", "bot"));
        msgs.add(new ChatMessage("ur parents love him more", "bot"));
        msgs.add(new ChatMessage("ur brother is cute AF", "bot"));
        msgs.add(new ChatMessage("NEVER TALK TO ME AGAIN!", "me"));
        msgs.add(new ChatMessage("ALICE CALLED YOU FROM UNKNOWN NUMBER", "middle"));
        msgs.add(new ChatMessage("...AND TOLD YOU THAT SHE LEFT HER PHONE", "middle"));
        msgs.add(new ChatMessage("...IN YOUR BROTHER'S ROOM", "middle"));
        msgs.add(new ChatMessage("you should honestly look up to him", "bot"));
        msgs.add(new ChatMessage("SHUT UP YOU NERD", "me"));
        msgs.add(new ChatMessage("I KNOW WHO THIS IS", "me"));
        msgs.add(new ChatMessage("I AM GONNA KILL YOU", "me"));
        msgs.add(new ChatMessage("HAHAHAHAHAHA 😂😂 \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("wow that was fun!", "bot"));
        msgs.add(new ChatMessage("YOU ARE SO DEAD", "me"));
        msgs.add(new ChatMessage("not so fast bro", "bot"));
        msgs.add(new ChatMessage("you're not going to do anything", "bot"));
        msgs.add(new ChatMessage("OH REALLY?? WATCH ME", "me"));
        msgs.add(new ChatMessage("don't forget... i know about Becca", "bot"));
        msgs.add(new ChatMessage("oh crap", "me"));
        msgs.add(new ChatMessage("yep. so if you do anything to me", "bot"));
        msgs.add(new ChatMessage("ur girlfriend finds out about becca", "bot"));
        msgs.add(new ChatMessage("wait. hold on", "me"));
        msgs.add(new ChatMessage("so are you gonna hurt me?", "bot"));
        msgs.add(new ChatMessage("no ", "me"));
        msgs.add(new ChatMessage("cool", "bot"));
        msgs.add(new ChatMessage("oh and one more thing", "bot"));
        msgs.add(new ChatMessage("i want your new AirPods", "bot"));
        msgs.add(new ChatMessage("what?? no way!", "me"));
        msgs.add(new ChatMessage("ok then i hope u like being single", "bot"));
        msgs.add(new ChatMessage("FINE YOU CAN HAVE MY AIRPODS", "me"));
        msgs.add(new ChatMessage("aww ur such a nice big bro", "bot"));
        msgs.add(new ChatMessage("I HATE YOU!!", "me"));

        return msgs;
    }

    public ArrayList<ChatMessage> CharlieSuspense() {
        Log.d(TAG, "Charlie: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Charlie \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("This will be the conversation between us!", "me"));
        msgs.add(new ChatMessage("Yeah, it will be fun", "bot"));
        msgs.add(new ChatMessage("I hope \uD83D\uDE02", "me"));

        return msgs;
    }

    public ArrayList<ChatMessage> CarlSuspense() {
        Log.d(TAG, "Carl: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Carl \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("This will be the conversation between us!", "me"));
        msgs.add(new ChatMessage("Yeah, it will be fun", "bot"));
        msgs.add(new ChatMessage("I hope \uD83D\uDE02", "me"));

        return msgs;
    }

    public ArrayList<ChatMessage> KathyThriller() {
        Log.d(TAG, "Kathy: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Kathy \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("This will be the conversation between us!", "me"));
        msgs.add(new ChatMessage("Yeah, it will be fun", "bot"));
        msgs.add(new ChatMessage("I hope \uD83D\uDE02", "me"));
        return msgs;
    }

    public ArrayList<ChatMessage> WilliamThriller() {
        Log.d(TAG, "William: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm William \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("This will be the conversation between us!", "me"));
        msgs.add(new ChatMessage("Yeah, it will be fun", "bot"));
        msgs.add(new ChatMessage("I hope \uD83D\uDE02", "me"));

        return msgs;
    }

    public ArrayList<ChatMessage> SamOther() {
        Log.d(TAG, "Sam: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Sam \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("This will be the conversation between us!", "me"));
        msgs.add(new ChatMessage("Yeah, it will be fun", "bot"));
        msgs.add(new ChatMessage("I hope \uD83D\uDE02", "me"));

        return msgs;
    }

    public ArrayList<ChatMessage> AlexOther() {
        Log.d(TAG, "Alex: returned");

        ArrayList<ChatMessage> msgs = new ArrayList<>();

        msgs.add(new ChatMessage("Hi!", "me"));
        msgs.add(new ChatMessage("Hey", "bot"));
        msgs.add(new ChatMessage("I'm Alex \uD83D\uDE02", "bot"));
        msgs.add(new ChatMessage("This will be the conversation between us!", "me"));
        msgs.add(new ChatMessage("Yeah, it will be fun", "bot"));
        msgs.add(new ChatMessage("I hope \uD83D\uDE02", "me"));

        return msgs;
    }

}
