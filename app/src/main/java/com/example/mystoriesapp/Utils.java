package com.example.mystoriesapp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AlertDialog.Builder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
    private static final String PACKAGE_NAME = "dev.moutamid.mystoriesapp";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";
    private SharedPreferences sharedPreferences;

    public String getStoredString(Context context1, String name) {
        sharedPreferences = context1.getSharedPreferences(PACKAGE_NAME, 0);
        return sharedPreferences.getString(name, "Error");
    }

    public void storeString(Context context1, String name, String object) {
        sharedPreferences = context1.getSharedPreferences(PACKAGE_NAME, 0);
        sharedPreferences.edit().putString(name, object).apply();
    }

    public void storeBoolean(Context context1, String name, boolean value) {
        sharedPreferences = context1.getSharedPreferences(PACKAGE_NAME, 0);
        sharedPreferences.edit().putBoolean(name, value).apply();
    }

    public boolean getStoredBoolean(Context context1, String name) {
        sharedPreferences = context1.getSharedPreferences(PACKAGE_NAME, 0);
        return sharedPreferences.getBoolean(name, false);
    }

    public void storeInteger(Context context1, String name, int value) {
        sharedPreferences = context1.getSharedPreferences(PACKAGE_NAME, 0);
        sharedPreferences.edit().putInt(name, value).apply();
    }

    public int getStoredInteger(Context context1, String name) {
        sharedPreferences = context1.getSharedPreferences(PACKAGE_NAME, 0);
        return sharedPreferences.getInt(name, 0);
    }

//    public Integer getRandomNmbr(int length) {
//        return new Random().nextInt(length) + 1;
//    }
//
//    public String getTime() {
//        return new SimpleDateFormat("hh:mm a").format(new Date());
//    }


    public void showMessage(Context context1, String Title, String Data) {
        Builder builder = new Builder(context1);
        builder.setCancelable(true);
        builder.setTitle((CharSequence) Title);
        builder.setMessage((CharSequence) Data);
        builder.show();
    }

    // PUBLIC METHOD TO GET VIEW FROM ONE ACTIVITY OR FRAGMENT TO ANOTHER
    //-------------------------------------------------------------------
    //public Utils.NonSwipableViewPager getClassRoomViewPager() {
//
    //      // Class to set current item or change any view from any different activity
//
    //      if (null == classRoomViewPager) {
    //        classRoomViewPager = (Utils.NonSwipableViewPager) findViewById(R.id.class_room_viewPager);
    //  }
//
    //      return classRoomViewPager;
    //}
    //-------------------------------------------------------------------
    // Change View Pager from Classroom Activity
    //((FragmentVideoLectures)getActivity()).getVideoLecturesViewPager().setCurrentItem(1, true);
}
