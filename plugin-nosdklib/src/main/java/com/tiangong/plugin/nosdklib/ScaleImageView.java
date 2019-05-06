package com.tiangong.plugin.nosdklib;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

public class ScaleImageView extends ImageView {
    Display display = ((Activity)this.getContext()).getWindowManager().getDefaultDisplay();
    double width = display.getWidth();
    int height = display.getHeight();
    private double realHeight;
    public ScaleImageView(Context context) {
        this(context,null);
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       double widthTemp =  getMeasuredWidth();
        double heightTemp =  getMeasuredHeight();
       if(widthTemp>0&&heightTemp>0){
           realHeight = (width/widthTemp)*heightTemp;

       }
       setMeasuredDimension((int) width,(int) realHeight);
    }

}
