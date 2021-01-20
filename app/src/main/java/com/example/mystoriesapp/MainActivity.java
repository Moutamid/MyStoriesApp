package com.example.mystoriesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";

    private Button button;

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

        data();

        utils.storeString(MainActivity.this, "current_activity", "main");
    }

    private void data() {
        Log.d(TAG, "data: ");

        this.onBoardViewPager = findViewById(R.id.viewPagerMainActivity);
        this.button = (Button) findViewById(R.id.get_started_btn_fragment_welcome);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        viewPagerFragmentAdapter.addFragment(new FragmentWelcomeOnBoard());
        viewPagerFragmentAdapter.addFragment(new FragmentRegistrationOnBoard());
        this.onBoardViewPager.setOffscreenPageLimit(2);

        this.onBoardViewPager.setAdapter(viewPagerFragmentAdapter);
        this.onBoardViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int position, float v, int i1) {
                Log.d(MainActivity.TAG, "onPageScrolled: ");
                if (position == 0) {
                    button.setText("GET STARTED");
                } else if (position == 1) {
                    button.setText("REGISTER");
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
                if (onBoardViewPager.getCurrentItem() == 0) {
                    onBoardViewPager.setCurrentItem(1);
                    return;
                }

                String username = utils.getStoredString(MainActivity.this, MainActivity.USER_NAME);
                String usergender = utils.getStoredString(MainActivity.this, MainActivity.USER_GENDER);

                if (username.equals("Error") || username.equals("") || username.isEmpty()) {

                    RelativeLayout layout = (RelativeLayout) findViewById(R.id.name_edittext_layout_fragment_registration);
                    YoYo.with(Techniques.Shake).duration(700).playOn(layout);

                    //Toast.makeText(MainActivity.this, "Please enter a name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!utils.getStoredBoolean(MainActivity.this, "isgenderselected")) {

                    LinearLayout layout = (LinearLayout) findViewById(R.id.genderLayout_fragment_registration);
                    YoYo.with(Techniques.Shake).duration(700).playOn(layout);

                    //Toast.makeText(MainActivity.this, "Gender not selected", Toast.LENGTH_SHORT).show();
                    return;
                }

                finish();
                startActivity(new Intent(MainActivity.this, StoriesListActivity.class));

                utils.storeBoolean(MainActivity.this, "first_convno", true);

                Toast.makeText(MainActivity.this, username + " " + usergender, Toast.LENGTH_SHORT).show();

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
