package com.training.whatsappclone.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ViewWithMoveListener extends LinearLayout {
    private final String TAG = "ViewWithMoveListener";
    public ViewWithMoveListener(Context context) {
        super(context);
    }

    public ViewWithMoveListener(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewWithMoveListener(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewWithMoveListener(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: " + event.getY());
        return super.onTouchEvent(event);
    }
}
