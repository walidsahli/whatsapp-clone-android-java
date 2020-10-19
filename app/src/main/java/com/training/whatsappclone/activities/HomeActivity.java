package com.training.whatsappclone.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.training.whatsappclone.R;
import com.training.whatsappclone.adapter.TabAdapter;
import com.training.whatsappclone.fragments.CallsFragment;
import com.training.whatsappclone.fragments.CameraFragment;
import com.training.whatsappclone.fragments.ChatFragment;
import com.training.whatsappclone.fragments.StatusFragment;
import com.training.whatsappclone.utils.CustomViewPager;

public class HomeActivity extends AppCompatActivity implements CustomViewPager.ViewPagerListener {

    Toolbar toolbar;
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    private ViewGroup header;
    private Display display;
    private Point size = new Point();
    private int screenWidth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("WhatsApp");
        display = getWindowManager(). getDefaultDisplay();
        display.getSize(size);
        screenWidth = (int) size.x;
        header = findViewById(R.id.header);
        toolbar = findViewById(R.id.my_toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setTitleTextColor(getResources().getColor(R.color.whiteColor));
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment() , "Camera");
        adapter.addFragment(new ChatFragment(), "Chat");
        adapter.addFragment(new StatusFragment(), "Status");
        adapter.addFragment(new CallsFragment(), "Calls");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(3);
        TabLayout.Tab cameraTab = tabLayout.getTabAt(0);
        cameraTab.setIcon(R.drawable.ic_camera_alt_black_24dp);
        cameraTab.setText(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_toolbar_menu, menu);
        return true;
    }

    @Override
    public void onScrollListener(int x) {
        if(x < 0) {
            float translationY = ((float) x) / screenWidth * (getResources().getDimension(R.dimen.headerTranslation));
            header.setTranslationY(translationY);
        }else if (x >= 0) {
            header.setTranslationY(0);
        }
    }




}
