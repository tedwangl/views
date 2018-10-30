package com.wl.ui.loadingview.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.wl.ui.loadingview.model.Arc;

/**
 * Created by Tuyen Nguyen on 2/13/17.
 */

public class PhoneWave extends LoaderView {
  private Arc[] arcs;
  private int numberOfArc;

  public PhoneWave() {
    numberOfArc = 3;
  }

  @Override
  public void initializeObjects() {
    float r = Math.min(width, height) / 2f;
    arcs = new Arc[numberOfArc];
    valueAnimators = new ValueAnimator[numberOfArc];
    for (int i = 0; i < numberOfArc; i++) {
      float d = r / 4 + i * r / 4;
      arcs[i] = new Arc();
      arcs[i].setColor(color);
      arcs[i].setAlpha(126);
      arcs[i].setOval(new RectF(center.x - d, center.y - d + r / 3, center.x + d, center.y + d + r / 3));
      arcs[i].setStartAngle(225);
      arcs[i].setSweepAngle(90);
      arcs[i].setStyle(Paint.Style.STROKE);
      arcs[i].setWidth(r / 10f);
    }
  }

  @Override
  public void setUpAnimation() {
    for (int i = 0; i < numberOfArc; i++) {
      final int index = i;

      valueAnimators[i] = ValueAnimator.ofInt(126, 255, 126);
      valueAnimators[i].setRepeatCount(ValueAnimator.INFINITE);
      valueAnimators[i].setDuration(1000);
      valueAnimators[i].setStartDelay(i * 120);
      valueAnimators[i].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
          arcs[index].setAlpha((int)animation.getAnimatedValue());
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
    for (int i = 0; i < numberOfArc; i++) {
      arcs[i].draw(canvas);
    }
  }

}
