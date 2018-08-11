package ru.yandexschool.hacka2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BallView  extends View{
    private float ballRadius;
    private Paint paint;
    final PointF ball = new PointF();
    private float height, weight;
    private float x = height/2;
    private float y = weight/2;


    private static final float BALL_RADIUS = 15.0f;


    public BallView(Context context) {
        super(context);
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        final float scale = getContext().getResources().getDisplayMetrics().density;
        ballRadius = scale * BALL_RADIUS;
        paint = new Paint();
        paint.setColor(0xFFFF0000);
    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.height = h;
        this.weight = w;
    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);



    }

    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawCircle(y,x,ballRadius,paint);
    }
    float lastX = 0, lastY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            lastX = event.getX();
            lastY = event.getY();
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            /*update(event.getX() - lastX, event.getY() - lastY);
            lastX = event.getX();
            lastY = event.getY();*/
            return true;
        }
        return super.onTouchEvent(event);


    }
}
