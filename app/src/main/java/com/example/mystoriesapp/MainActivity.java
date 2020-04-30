package com.example.mystoriesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Scroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String USER_GENDER = "user_gender";
    private static final String USER_NAME = "username";

    private Button button;
    private boolean isGenderSelected = false;
    private ViewPagerFragmentAdapter onBoardAdapter;

    private NonSwipableViewPager onBoardViewPager;

    private Utils utils = new Utils();

    public static class NonSwipableViewPager extends ViewPager {

        public class MyScroller extends Scroller {
            public MyScroller(Context context) {
                super(context, new DecelerateInterpolator());
            }

            public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                super.startScroll(startX, startY, dx, dy, 350);
            }
        }

        public NonSwipableViewPager(Context context) {
            super(context);
        }

        public NonSwipableViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return false;
        }

        public boolean onTouchEvent(MotionEvent ev) {
            return false;
        }

        public void setMyScroller() {
            Log.d(MainActivity.TAG, "setMyScroller: ");
            try {
                Field scroller = ViewPager.class.getDeclaredField("mScroller");
                scroller.setAccessible(true);
                scroller.set(this, new MyScroller(getContext()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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

        startActivity(new Intent(MainActivity.this, ConversationActivity.class));

        //data();
    }

    private void data() {
        this.onBoardViewPager = (NonSwipableViewPager) findViewById(R.id.viewPagerMainActivity);
        this.button = (Button) findViewById(R.id.get_started_btn_fragment_welcome);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        this.onBoardAdapter = viewPagerFragmentAdapter;
        viewPagerFragmentAdapter.addFragment(new FragmentWelcomeOnBoard());
        this.onBoardAdapter.addFragment(new FragmentRegistrationOnBoard());
        this.onBoardViewPager.setOffscreenPageLimit(2);
        this.onBoardViewPager.setMyScroller();
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
                    MainActivity.this.startActivity(new Intent(MainActivity.this, ChatListActivity.class));
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
