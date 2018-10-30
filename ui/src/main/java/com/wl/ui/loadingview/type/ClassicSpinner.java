package com.wl.ui.loadingview.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.wl.ui.loadingview.model.Circle;

/**
 * Created by Tuyen Nguyen on 2/10/17.
 */

public class ClassicSpinner extends LoaderView {
    private Circle[] circles;
    private int circlesSize;

    public ClassicSpinner() {
        circlesSize = 8;
        valueAnimators= new ValueAnimator[circlesSize];
    }

    @Override
    public void initializeObjects() {
        final float size = Math.min(width, height);
        final float circleRadius = size / 10.0f;
        circles = new Circle[circlesSize];

        for (int i = 0; i < circlesSize; i++) {
            circles[i] = new Circle();
            circles[i].setCenter(center.x, circleRadius);
            circles[i].setColor(color);
            circles[i].setAlpha(126);
            circles[i].setRadius(circleRadius);
        }
    }

    @Override
    public void setUpAnimation() {
        for (int i = 0; i < circlesSize; i++) {
            final int index = i;

            valueAnimators[i] = ValueAnimator.ofInt(126, 255, 126);
            valueAnimators[i].setRepeatCount(ValueAnimator.INFINITE);
            valueAnimators[i].setDuration(1000);
            valueAnimators[i].setStartDelay(index * 120);
            valueAnimators[i].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    circles[index].setAlpha((int) animation.getAnimatedValue());
                    if (invalidateListener != null) {
                        invalidateListener.reDraw();
                    }
                }
            });
            valueAnimators[i].start();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < circlesSize; i++) {
            canvas.save();
            canvas.rotate(45 * i, center.x, center.y);
            circles[i].draw(canvas);
            canvas.restore();
        }
    }


}
