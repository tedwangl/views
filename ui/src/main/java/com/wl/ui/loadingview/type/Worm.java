package com.wl.ui.loadingview.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import com.wl.ui.loadingview.model.Circle;


/**
 * Created by Tuyen Nguyen on 2/12/17.
 */

public class Worm extends LoaderView {
  private Circle[] circles;
  private int circlesSize;
  private float radius;
  private int[] transformations;

  public Worm() {
    circlesSize = 5;
    transformations = new int[]{-2, -1, 0, 1, 2};
    valueAnimators = new ValueAnimator[5];
  }

  @Override
  public void initializeObjects() {
    circles = new Circle[circlesSize];
    radius = width / 10f - width / 100f;

    for (int i = 0; i < circlesSize; i++) {
      circles[i] = new Circle();
      circles[i].setColor(color);
      circles[i].setRadius(radius);
      circles[i].setCenter(center.x, center.y);
    }
  }

  @Override
  public void setUpAnimation() {
    for (int i = 0; i < circlesSize; i++) {
      final int index = i;
      valueAnimators[i] = ValueAnimator.ofFloat(center.y, height / 4f, height * 3 / 4f, center.y);
      valueAnimators[i].setDuration(1000);
      valueAnimators[i].setStartDelay(index * 120);
      valueAnimators[i].setRepeatCount(ValueAnimator.INFINITE);
      valueAnimators[i].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
          circles[index].setCenter(center.x, (float)animation.getAnimatedValue());
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
      canvas.translate(2 * radius * transformations[i], 0);
      circles[i].draw(canvas);
      canvas.restore();
    }
  }

}
