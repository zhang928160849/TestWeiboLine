package com.example.remin.testweiboline.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by remin.
 * Created Time 2017/8/30 ${Time}
 */

public class DynamicLine extends View {

    private float startX,stopX;//起始的x和终止的x
    private Paint paint;
    private RectF rectF = new RectF(startX,0,stopX,0);//float精度的矩形
    public DynamicLine(Context context) {
        this(context,null);
    }

    public DynamicLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DynamicLine(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        init();
    }


    public void init(){
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setStyle(Paint.Style.FILL);//填充
        paint.setStrokeWidth(5);//设置画笔高度
        paint.setShader(new LinearGradient(0,100,getScreenWidth(),100,
                Color.parseColor("#ffc125"),Color.parseColor("#ff4500"), Shader.TileMode.MIRROR));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(20,MeasureSpec.getMode(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rectF.set(startX,0,stopX,10);
        canvas.drawRoundRect(rectF,5,5,paint);//rectF矩形对象，paint画笔
        super.onDraw(canvas);
    }

    /*
    * 根据起始点，终止点进行重新绘制
    * */
    public void updateDraw(float startX,float stopX){
        this.startX = startX;
        this.stopX = stopX;
        invalidate();
    }

    public float getScreenWidth(){
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        return width;
    }





}
