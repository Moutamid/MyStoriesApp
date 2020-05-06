package com.example.mystoriesapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentRegistrationOnBoard extends Fragment {
    private static final String TAG = "FragmentRegistrationOnB";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";

    private Button alienBtn;

    private Button femaleBtn;

    private Button maleBtn;
    private EditText nameEt;

    private Utils utils = new Utils();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_on_board, container, false);
        Log.d(TAG, "onCreateView: started");
        this.maleBtn = (Button) view.findViewById(R.id.maleGenderLayoutOnboardRegistration);
        this.femaleBtn = (Button) view.findViewById(R.id.femaleGenderLayoutOnboardRegistration);
        this.alienBtn = (Button) view.findViewById(R.id.alienGenderLayoutOnboardRegistration);
        this.nameEt = (EditText) view.findViewById(R.id.name_edittext_fragment_registration);
        this.maleBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(FragmentRegistrationOnBoard.TAG, "onClick: malebtn");
                FragmentRegistrationOnBoard.this.utils.storeString(FragmentRegistrationOnBoard.this.getActivity(), FragmentRegistrationOnBoard.USER_GENDER, "male");
                FragmentRegistrationOnBoard.this.utils.storeBoolean(FragmentRegistrationOnBoard.this.getActivity(), "isgenderselected", true);
                FragmentRegistrationOnBoard.this.maleBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                FragmentRegistrationOnBoard.this.maleBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.white));
                FragmentRegistrationOnBoard.this.femaleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                FragmentRegistrationOnBoard.this.femaleBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.orange));
                FragmentRegistrationOnBoard.this.alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                FragmentRegistrationOnBoard.this.alienBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.orange));
            }
        });
        this.femaleBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(FragmentRegistrationOnBoard.TAG, "onClick: femalebtn");
                FragmentRegistrationOnBoard.this.utils.storeString(FragmentRegistrationOnBoard.this.getActivity(), FragmentRegistrationOnBoard.USER_GENDER, "female");
                FragmentRegistrationOnBoard.this.utils.storeBoolean(FragmentRegistrationOnBoard.this.getActivity(), "isgenderselected", true);
                FragmentRegistrationOnBoard.this.femaleBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                FragmentRegistrationOnBoard.this.femaleBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.white));
                FragmentRegistrationOnBoard.this.maleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                FragmentRegistrationOnBoard.this.maleBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.orange));
                FragmentRegistrationOnBoard.this.alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                FragmentRegistrationOnBoard.this.alienBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.orange));
            }
        });
        this.alienBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(FragmentRegistrationOnBoard.TAG, "onClick: alienbtn");
                FragmentRegistrationOnBoard.this.utils.storeString(FragmentRegistrationOnBoard.this.getActivity(), FragmentRegistrationOnBoard.USER_GENDER, "alien");
                FragmentRegistrationOnBoard.this.utils.storeBoolean(FragmentRegistrationOnBoard.this.getActivity(), "isgenderselected", true);
                FragmentRegistrationOnBoard.this.alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                FragmentRegistrationOnBoard.this.alienBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.white));
                FragmentRegistrationOnBoard.this.femaleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                FragmentRegistrationOnBoard.this.femaleBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.orange));
                FragmentRegistrationOnBoard.this.maleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                FragmentRegistrationOnBoard.this.maleBtn.setTextColor(FragmentRegistrationOnBoard.this.getResources().getColor(R.color.orange));
            }
        });
        this.nameEt.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                FragmentRegistrationOnBoard.this.utils.storeString(FragmentRegistrationOnBoard.this.getActivity(), FragmentRegistrationOnBoard.USER_NAME, s.toString());
            }

            public void afterTextChanged(Editable s) {
                Log.d(FragmentRegistrationOnBoard.TAG, "afterTextChanged: ");
            }
        });
        return view;
    }
}
