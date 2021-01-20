package com.example.mystoriesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class FragmentWelcomeOnBoard extends Fragment {
    private static final String TAG = "FragmentWelcomeOnBoard";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: started");
        View view = inflater.inflate(R.layout.fragment_welcome_on_board, container, false);

        YoYo.with(Techniques.BounceInLeft)
                .duration(700)
                .delay(500)
                .playOn(view.findViewById(R.id.image_view_fragment_welcome));

        YoYo.with(Techniques.BounceInLeft)
                .duration(700)
                .delay(500)
                .playOn(view.findViewById(R.id.text_view_title_fragment_welcome));

        YoYo.with(Techniques.BounceInLeft)
                .duration(700)
                .delay(500)
                .playOn(view.findViewById(R.id.text_view_desc_fragment_welcome));


        return view;
    }

}
