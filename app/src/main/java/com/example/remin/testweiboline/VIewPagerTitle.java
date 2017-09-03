package com.example.remin.testweiboline;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.remin.testweiboline.Listener.MyPageChangeListener;
import com.example.remin.testweiboline.View.DynamicLine;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by remin.
 * Created Time 2017/8/31 ${Time}
 */

public class VIewPagerTitle extends LinearLayout {
    private int allTextViewLength;

    private String[] titles;
    private ArrayList<TextView> textViews = new ArrayList<>();
    private onTextViewClick onTextViewClick;
    private ViewPager viewPager;
    private MyPageChangeListener pageChangeListener;
    private DynamicLine dynamicLine;

    public VIewPagerTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public VIewPagerTitle(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public VIewPagerTitle(Context context) {
        this(context,null);
    }

    public ArrayList<TextView> getTextViews(){
        return textViews;
    }

    private void init(){
        setOrientation(VERTICAL);
    }

    public void initData(String[] titles,ViewPager viewPager,int defaultIndex){
        this.titles = titles;
        this.viewPager = viewPager;
        createDynamLine();

            createTextViews(titles);
        setCurrentItems(defaultIndex);

        pageChangeListener = new MyPageChangeListener(getContext(),viewPager,dynamicLine,this,0,0,0);

    }

    private void createDynamLine(){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dynamicLine = new DynamicLine(getContext());
        dynamicLine.setLayoutParams(params);
    }

    private void createTextViews(String[] titles){
        LinearLayout textViewLl = new LinearLayout(getContext());
        LinearLayout.LayoutParams linerLayoutparams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLl.setOrientation(HORIZONTAL);
        LinearLayout.LayoutParams params = new LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        for(int i =0 ;i<titles.length;i++){
            TextView textView = new TextView(getContext());
            textView.setText(titles[i]);
            textView.setTextColor(Color.GRAY);
            textView.setTextSize(18);
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setOnClickListener(onClickListener);
            textView.setTag(i);
            textViews.add(textView);
            textViewLl.addView(textView);
        }
        addView(textViewLl);
        addView(dynamicLine);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            for(int i = 0;i<textViews.size();i++){
                if(i==(int)v.getTag()){
                    ((TextView)v).setTextSize(22);
                    ((TextView)v).setTextColor(Color.BLACK);
                }else{
                    textViews.get(i).setTextColor(Color.GRAY);
                    textViews.get(i).setTextSize(18);
                }
            }
            viewPager.setCurrentItem((int)v.getTag());
            if(onTextViewClick != null){
                onTextViewClick.textViewCLick((TextView)v,(int)v.getTag());
            }
        }
    };
    public void setCurrentItems(int index){
        for(int i = 0;i<textViews.size();i++){
            if(i==index){
                textViews.get(i).setTextColor(Color.BLACK);
                textViews.get(i).setTextSize(22);
            }else{
                textViews.get(i).setTextColor(Color.GRAY);
                textViews.get(i).setTextSize(18);
            }
        }
    }

    public interface onTextViewClick{
        void textViewCLick(TextView textView,int index);
    }

    public void setOnTextViewClickListener(onTextViewClick onTextViewClick){
        this.onTextViewClick = onTextViewClick;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        viewPager.removeOnPageChangeListener(pageChangeListener);
    }

}
