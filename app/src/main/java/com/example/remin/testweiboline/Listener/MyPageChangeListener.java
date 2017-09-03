package com.example.remin.testweiboline.Listener;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.remin.testweiboline.VIewPagerTitle;
import com.example.remin.testweiboline.View.DynamicLine;

import static android.support.v4.view.ViewPager.SCROLL_STATE_SETTLING;
import java.util.List;

/**
 * Created by remin.
 * Created Time 2017/8/31 ${Time}
 */

public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
    private DynamicLine dynamicLine;
    private VIewPagerTitle vIewPagerTitle;
    private ViewPager viewPager;
    private Context context;
    private List<TextView> textViews;
    private int pagerCount;
    private int scrrenWidth;
    private int everyLength;
    private int lastPosition;
    private int lineWidth;
    private int dis;
    public MyPageChangeListener(Context context, ViewPager viewPager, DynamicLine dynamicLine,
                                VIewPagerTitle viewPagerTitle, int allLength, int margin, int fixLeftDis) {
        this.context = context;
        this.viewPager = viewPager;
        this.vIewPagerTitle = viewPagerTitle;
        this.textViews = viewPagerTitle.getTextViews();
        this.dynamicLine = dynamicLine;
        scrrenWidth = (int)getScreenWidth();
        pagerCount = textViews.size();
        lineWidth = (int)getTextViewLength(textViews.get(0));
        everyLength = scrrenWidth/pagerCount;
        dis = (everyLength - lineWidth)/2;

    }

    public float getScreenWidth(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return width;
    }

    public float getTextViewLength(TextView textView){
        TextPaint textPaint = textView.getPaint();
        return textPaint.measureText(textView.getText().toString());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(lastPosition>position){
            dynamicLine.updateView((position + positionOffset)*everyLength + dis,(lastPosition+1)*everyLength - dis);
        }else{
            if(positionOffset>0.5f){
                positionOffset = 0.5f;
            }
            dynamicLine.updateView(lastPosition*everyLength+dis,(position+positionOffset*2)*everyLength+dis+lineWidth);

        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(state == SCROLL_STATE_SETTLING){
            lastPosition=viewPager.getCurrentItem();
        }
    }

    @Override
    public void onPageSelected(int position) {
        vIewPagerTitle.setCurrentItems(position);
    }
}
