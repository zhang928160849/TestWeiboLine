package com.example.remin.testweiboline.Listener;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.remin.testweiboline.View.DynamicLine;

import java.util.List;

/**
 * Created by remin.
 * Created Time 2017/8/31 ${Time}
 */

public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
    private DynamicLine dynamicLine;
    private ViewPager viewPager;
    private Context context;
    private List<TextView> textViews;
    private int pagerCount;
    private float scrrenWidth,lineWidth;
    public MyPageChangeListener(Context context, ViewPager viewPager, DynamicLine dynamicLine,
                                List<TextView> views,int allLength,int margin,int fixLeftDis) {
        this.context = context;
        this.viewPager = viewPager;
        this.textViews = views;
        this.dynamicLine = dynamicLine;
        scrrenWidth = getScreenWidth();
        pagerCount = textViews.size();
        textViews.get(0).
        lineWidth = (int)
    }

    public float getScreenWidth(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return width;
    }

}
