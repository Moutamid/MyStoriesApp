package com.example.mystoriesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentWelcomeOnBoard extends Fragment {
    private static final String TAG = "FragmentWelcomeOnBoard";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        return inflater.inflate(R.layout.fragment_welcome_on_board, container, false);
    }

}
