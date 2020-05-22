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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

public class FragmentRegistrationOnBoard extends Fragment {
    private static final String TAG = "FragmentRegistrationOnB";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";

    private Button alienBtn;

    private Button femaleBtn;

    private Button maleBtn;
    private EditText nameEt;
    private RelativeLayout etlayout;
    private LinearLayout genderLayout;
    private Utils utils = new Utils();

    public RelativeLayout getEtlayout() {

        return etlayout;
    }

    public LinearLayout getGenderLayout() {
        return genderLayout;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_on_board, container, false);
        Log.d(TAG, "onCreateView: started");

        maleBtn = (Button) view.findViewById(R.id.maleGenderLayoutOnboardRegistration);
        femaleBtn = (Button) view.findViewById(R.id.femaleGenderLayoutOnboardRegistration);
        alienBtn = (Button) view.findViewById(R.id.alienGenderLayoutOnboardRegistration);
        nameEt = (EditText) view.findViewById(R.id.name_edittext_fragment_registration);
        etlayout = view.findViewById(R.id.name_edittext_layout_fragment_registration);
        genderLayout = view.findViewById(R.id.genderLayout_fragment_registration);

        setMaleBtnClickListener();
        setFemaleBtnClickListener();
        setAlienBtnClickListener();
        setNameEditTextWatcher();

        return view;
    }

    private void setFemaleBtnClickListener() {
        femaleBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(FragmentRegistrationOnBoard.TAG, "onClick: femalebtn");
                utils.storeString(getActivity(), FragmentRegistrationOnBoard.USER_GENDER, "female");
                utils.storeBoolean(getActivity(), "isgenderselected", true);
                femaleBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                femaleBtn.setTextColor(getResources().getColor(R.color.white));
                maleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                maleBtn.setTextColor(getResources().getColor(R.color.orange));
                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.orange));
            }
        });
    }

    private void setNameEditTextWatcher() {
        nameEt.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                utils.storeString(getActivity(), USER_NAME, s.toString());
            }

            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: ");
            }
        });
    }

    private void setAlienBtnClickListener() {
        alienBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(FragmentRegistrationOnBoard.TAG, "onClick: alienbtn");
                utils.storeString(getActivity(), USER_GENDER, "alien");
                utils.storeBoolean(getActivity(), "isgenderselected", true);
                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.white));
                femaleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                femaleBtn.setTextColor(getResources().getColor(R.color.orange));
                maleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                maleBtn.setTextColor(getResources().getColor(R.color.orange));
            }
        });
    }

    private void setMaleBtnClickListener() {
        maleBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(FragmentRegistrationOnBoard.TAG, "onClick: malebtn");
                utils.storeString(getActivity(), FragmentRegistrationOnBoard.USER_GENDER, "male");
                utils.storeBoolean(getActivity(), "isgenderselected", true);
                maleBtn.setBackgroundResource(R.drawable.bg_gender_btn_clicked_registration_on_board);
                maleBtn.setTextColor(getResources().getColor(R.color.white));
                femaleBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                femaleBtn.setTextColor(getResources().getColor(R.color.orange));
                alienBtn.setBackgroundResource(R.drawable.bg_gender_btn_unclicked_registration_on_board);
                alienBtn.setTextColor(getResources().getColor(R.color.orange));
            }
        });
    }

}
