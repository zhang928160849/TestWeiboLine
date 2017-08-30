package com.example.remin.testweiboline;

import android.content.Context;
import android.text.TextPaint;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by remin.
 * Created Time 2017/8/31 ${Time}
 */

public class VIewPagerTitle extends HorizontalScrollView {
    private int defaultSize = 20;
    private int getTextViewMarigns(String[] titleAry){
        int defaultMarigns = 20;
        float currentLength = 0;

        TextView textView = new TextView(getContext());
        textView.setTextSize(defaultSize);
        TextPaint paint = textView.getPaint();
        for(int i = 0;i<titleAry.length;i++){
            currentLength = currentLength + defaultMarigns +
                    paint.measureText(titleAry[i])+defaultMarigns;
        }
        int screenWidth =

    }
    public float getScreenWidth(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return width;
    }
}
