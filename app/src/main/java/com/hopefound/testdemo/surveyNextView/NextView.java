package com.hopefound.testdemo.surveyNextView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 王震 on 2018/4/24 0024.
 */

public class NextView extends View{

    /**
     * 外圆半径
     */
    private int outCircleR;

    /**
     * 圆心x
     */
    private float centerX;

    /**
     * 圆心y
     */
    private float centerY;

    /**
     * 内圆半径
     */
    private int inCircleR;

    /**
     * 题目的进度
     */
    private int progress;

    /**
     * 是否可用
     */
    private boolean isClicked;

    /**
     * 外圆的画笔
     */
    private Paint outPaint;

    /**
     * 内圆的画笔
     */
    private Paint inPaint;

    /**
     * 进度条的画笔
     */
    private Paint progPaint;

    /**
     * 箭头的画笔
     */
    private Paint arrowPaint;

    private int OUTCITCLE_COLOR = Color.parseColor("#dca3f4");
    private int INCIRCLE_COLOR = Color.parseColor("#b63ee9");
    private int PROCIRCLE_COLOR = Color.parseColor("#f98d2f");
    private int ARROW_COLOR = Color.parseColor("#ffffff");

    public NextView(Context context) {
        super(context);
    }

    public NextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    /**
     * 设置画笔初始数值
     */
    private void init() {
        outPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        outPaint.setColor(OUTCITCLE_COLOR);
        outPaint.setStyle(Paint.Style.FILL);

        inPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        inPaint.setColor(OUTCITCLE_COLOR);
        inPaint.setStyle(Paint.Style.FILL);

        progPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progPaint.setColor(PROCIRCLE_COLOR);
        progPaint.setStyle(Paint.Style.STROKE);
        progPaint.setStrokeWidth(5);

        arrowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arrowPaint.setColor(ARROW_COLOR);
        arrowPaint.setStyle(Paint.Style.STROKE);
        arrowPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        centerX = getWidth()  / 2;
        centerY = getHeight()  / 2;
        canvas.drawCircle(centerX,centerY,centerX-10,outPaint);
        canvas.drawCircle(centerX,centerY,centerX-15,inPaint);

        Path path = new Path();
        path.moveTo(centerX-10,centerY-10);
        path.lineTo(centerX+10,centerY);
        path.lineTo(centerX-10,centerY+10);
        canvas.drawPath(path,arrowPaint);
        canvas.drawArc(15,15,getWidth() - 15,getHeight() - 15,-90,progress,false,progPaint);

    }

    public void setProgress(int progress){
        this.progress = progress;
        invalidate();
    }

    public void setIsClick(boolean isAnswer){
        if (isAnswer){
            inPaint.setColor(INCIRCLE_COLOR);
        }else {
            inPaint.setColor(outCircleR);
        }
        invalidate();
    }
}
