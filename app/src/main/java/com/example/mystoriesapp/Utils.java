package com.example.mystoriesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog.Builder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
    private static final String PACKAGE_NAME = "com.example.mystoriesapp";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";
    private SharedPreferences sharedPreferences;

    public String getStoredString(Context context1, String name) {
        SharedPreferences sharedPreferences2 = context1.getSharedPreferences(PACKAGE_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
        return sharedPreferences2.getString(name, "Error");
    }

    public void storeString(Context context1, String name, String object) {
        SharedPreferences sharedPreferences2 = context1.getSharedPreferences(PACKAGE_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
        sharedPreferences2.edit().putString(name, object).apply();
    }

    public void storeBoolean(Context context1, String name, boolean value) {
        SharedPreferences sharedPreferences2 = context1.getSharedPreferences(PACKAGE_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
        sharedPreferences2.edit().putBoolean(name, value).apply();
    }

    public boolean getStoredBoolean(Context context1, String name) {
        SharedPreferences sharedPreferences2 = context1.getSharedPreferences(PACKAGE_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
        return sharedPreferences2.getBoolean(name, false);
    }

    public void storeInteger(Context context1, String name, int value) {
        SharedPreferences sharedPreferences2 = context1.getSharedPreferences(PACKAGE_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
        sharedPreferences2.edit().putInt(name, value).apply();
    }

    public int getStoredInteger(Context context1, String name) {
        SharedPreferences sharedPreferences2 = context1.getSharedPreferences(PACKAGE_NAME, 0);
        this.sharedPreferences = sharedPreferences2;
        return sharedPreferences2.getInt(name, 0);
    }

    public Integer getRandomNmbr(int length) {
        return new Random().nextInt(length) + 1;
    }

    public String getTime() {
        return new SimpleDateFormat("hh:mm a").format(new Date());
    }

    public void showShortToast(Context context1, String Message) {
        Toast.makeText(context1, Message, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(Context context1, String Message) {
        Toast.makeText(context1, Message, Toast.LENGTH_LONG).show();
    }

    public void showMessage(Context context1, String Title, String Data) {
        Builder builder = new Builder(context1);
        builder.setCancelable(true);
        builder.setTitle((CharSequence) Title);
        builder.setMessage((CharSequence) Data);
        builder.show();
    }
}
