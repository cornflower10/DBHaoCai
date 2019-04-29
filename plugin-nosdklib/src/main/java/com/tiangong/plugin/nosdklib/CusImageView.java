package com.tiangong.plugin.nosdklib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CusImageView extends ImageView {
    public CusImageView(Context context) {
        this(context,null);
    }

    public CusImageView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CusImageView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       int width =  getMeasuredWidth();
       setMeasuredDimension(width,width);
    }
}
