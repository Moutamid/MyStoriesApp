package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";

    private Button button;
    private boolean isGenderSelected = false;
    private ViewPagerFragmentAdapter onBoardAdapter;

    private ViewPager onBoardViewPager;

    private Utils utils = new Utils();

    private static class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();

        public void addFragment(Fragment fragment) {
            this.mFragmentList.add(fragment);
        }

        public ViewPagerFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            return (Fragment) this.mFragmentList.get(position);
        }

        public int getCount() {
            return this.mFragmentList.size();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        startActivity(new Intent(MainActivity.this, StoriesListActivity.class));

        data();
    }

    private void data() {
        this.onBoardViewPager =  findViewById(R.id.viewPagerMainActivity);
        this.button = (Button) findViewById(R.id.get_started_btn_fragment_welcome);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        this.onBoardAdapter = viewPagerFragmentAdapter;
        viewPagerFragmentAdapter.addFragment(new FragmentWelcomeOnBoard());
        this.onBoardAdapter.addFragment(new FragmentRegistrationOnBoard());
        this.onBoardViewPager.setOffscreenPageLimit(2);

        this.onBoardViewPager.setAdapter(this.onBoardAdapter);
        this.onBoardViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int position, float v, int i1) {
                Log.d(MainActivity.TAG, "onPageScrolled: ");
                if (position == 0) {
                    MainActivity.this.button.setText("GET STARTED");
                } else if (position == 1) {
                    MainActivity.this.button.setText("REGISTER");
                }
            }

            public void onPageSelected(int i) {
            }

            public void onPageScrollStateChanged(int i) {
            }
        });

        this.button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Log.d(MainActivity.TAG, "onClick: btn");
                if (MainActivity.this.onBoardViewPager.getCurrentItem() == 0) {
                    MainActivity.this.onBoardViewPager.setCurrentItem(1);
                    return;
                }
                String g = MainActivity.this.utils.getStoredString(MainActivity.this, MainActivity.USER_NAME);
                String h = MainActivity.this.utils.getStoredString(MainActivity.this, MainActivity.USER_GENDER);
                if (MainActivity.this.utils.getStoredBoolean(MainActivity.this, "isgenderselected")) {
                    Utils access$200 = MainActivity.this.utils;
                    MainActivity mainActivity = MainActivity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(g);
                    sb.append("\n");
                    sb.append(h);
                    access$200.showShortToast(mainActivity, sb.toString());
                    MainActivity.this.startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    return;
                }
                MainActivity.this.utils.showShortToast(MainActivity.this, "Gender not selected");
            }
        });
    }

    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
        if (this.onBoardViewPager.getCurrentItem() == 1) {
            this.onBoardViewPager.setCurrentItem(0);
        } else {
            super.onBackPressed();
        }
    }
}
