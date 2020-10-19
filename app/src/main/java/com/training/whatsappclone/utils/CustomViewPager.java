package com.training.whatsappclone.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {
    private String TAG = "VIEWPAGERTAG";
    ViewPagerListener listener;
    public CustomViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        listener = (ViewPagerListener) context;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        listener.onScrollListener(l);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public interface ViewPagerListener {
        public void onScrollListener(int x);
    }

}
