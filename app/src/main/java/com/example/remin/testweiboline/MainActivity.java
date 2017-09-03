package com.example.remin.testweiboline;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.remin.testweiboline.Adapter.MyViewPageAdapter;
import com.example.remin.testweiboline.View.DynamicLine;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<View> views = new ArrayList<>();
    private View view1;
    private View view2;
    private View view3;
    private ViewPager viewPager;
    private VIewPagerTitle viewPagerTitle;
    private DynamicLine dynamicLine;
    private MyViewPageAdapter adapter;
    private float startX,stopX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initalView();
    }
//        MyViewPageAdapter adapter = new MyViewPageAdapter();
//        adapter.setViews(views);
//        viewPager.setAdapter(adapter);
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                startX = ev.getRawX();//getRawx以屏幕左上角为点，获得x轴上的值
//                break;
//            case MotionEvent.ACTION_MOVE:
//                stopX = ev.getRawX();
//                dynamicLine.updateDraw(startX,stopX);
//                break;
//        }
//
//        return super.dispatchTouchEvent(ev);
//    }

    public void initalView(){
        viewPagerTitle = (VIewPagerTitle)findViewById(R.id.pager_title);
        viewPager = (ViewPager)findViewById(R.id.viewPager1);
        viewPagerTitle.initData(new String[]{"layout1","layout2","layout3"},viewPager,0);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout1,null);
        view2 = inflater.inflate(R.layout.layout2,null);
        view3 = inflater.inflate(R.layout.layout3,null);

        views.add(view1);
        views.add(view2);
        views.add(view3);
        adapter = new MyViewPageAdapter(views);
        viewPager.setAdapter(adapter);
        }
    }
//        dynamicLine = (DynamicLine)findViewById(R.id.dynamicline);
//        viewPager = (ViewPager)findViewById(R.id.viewPager1);
//        View pageOne = LayoutInflater.from(this).inflate(R.layout.page,null);
//        View pageTwo = LayoutInflater.from(this).inflate(R.layout.page,null);
//        TextView textView = (TextView)pageOne.findViewById(R.id.text);
//        textView.setText("slide me please");
//
//        views.add(pageOne);
//        views.add(pageTwo);

//        for(int i = 0; i<views.size();i++){
//            View view = views.get(i);
//            Button button = (Button)view.findViewById(R.id.button);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    StringBuilder builder = new StringBuilder();
//                    builder.append("you clicked me");
//                    String str = builder.toString();
//                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }

