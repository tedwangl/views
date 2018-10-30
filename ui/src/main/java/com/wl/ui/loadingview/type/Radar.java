package com.wl.ui.loadingview.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.wl.ui.loadingview.model.Line;

/**
 * Created by Tuyen Nguyen on 2/12/17.
 */

public class Radar extends LoaderView {
  private Line line;
  private float degree;

  @Override
  public void initializeObjects() {
    final float size = Math.min(width, height);
    line = new Line();
    line.setPoint1(center);
    line.setPoint2(new PointF(0, size / 2f));
    line.setColor(color);
    line.setWidth(5);
    valueAnimators = new ValueAnimator[1];
  }

  @Override
  public void setUpAnimation() {
    valueAnimators[0] = ValueAnimator.ofFloat(0, 359);
    valueAnimators[0].setDuration(1000);
    valueAnimators[0].setRepeatCount(ValueAnimator.INFINITE);
    valueAnimators[0].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        degree = (float)animation.getAnimatedValue();
        if (invalidateListener != null) {
          invalidateListener.reDraw();
        }
      }
    });

    valueAnimators[0].start();
  }

  @Override
  public void draw(Canvas canvas) {
    canvas.save();
    canvas.rotate(degree, center.x, center.y);
    line.draw(canvas);
    canvas.restore();
  }

}
