package com.wl.ui.loadingview.type;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.wl.ui.loadingview.model.Circle;

/**
 * Created by Tuyen Nguyen on 2/13/17.
 */

public class Sharingan extends LoaderView {
  private Circle eye;
  private Circle eyeBound;
  private Circle[] sharingans;
  private int numberOfSharingan;
  private float rotate;
  private float scale;
  private float eyeBoundRadius;
  private float eyeBoundRadiusScale;
  private AnimatorSet animatorSet;
  public Sharingan() {
    numberOfSharingan = 3;
    valueAnimators = new ValueAnimator[2];
  }

  @Override
  public void initializeObjects() {
    float r = Math.min(width, height) / 2f;
    eyeBoundRadius = r / 1.5f;

    eye = new Circle();
    eye.setCenter(center.x, center.y);
    eye.setColor(color);
    eye.setRadius(r / 4);

    eyeBound = new Circle();
    eyeBound.setCenter(center.x, center.y);
    eyeBound.setColor(color);
    eyeBound.setRadius(eyeBoundRadius);
    eyeBound.setStyle(Paint.Style.STROKE);
    eyeBound.setWidth(r / 20f);

    sharingans = new Circle[numberOfSharingan];
    for (int i = 0; i < numberOfSharingan; i++) {
      sharingans[i] = new Circle();
      sharingans[i].setCenter(center.x, center.y - eyeBoundRadius);
      sharingans[i].setColor(color);
      sharingans[i].setRadius(r / 6);
    }
  }

  @Override
  public void setUpAnimation() {
    valueAnimators[0] = ValueAnimator.ofFloat(0, 360);
    valueAnimators[0].setDuration(1500);
    valueAnimators[0].setRepeatCount(ValueAnimator.INFINITE);
    valueAnimators[0].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        rotate = (float)animation.getAnimatedValue();
        if (invalidateListener != null) {
          invalidateListener.reDraw();
        }
      }
    });

    valueAnimators[1] = ValueAnimator.ofFloat(1f, 0.8f, 1f);
    valueAnimators[1].setDuration(1000);
    valueAnimators[1].setRepeatCount(ValueAnimator.INFINITE);
    valueAnimators[1].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        scale = (float)animation.getAnimatedValue();
        if (invalidateListener != null) {
          invalidateListener.reDraw();
        }
      }
    });

    animatorSet = new AnimatorSet();
    animatorSet.play(valueAnimators[0]).with(valueAnimators[1]);
    animatorSet.start();
  }

  @Override
  public void draw(Canvas canvas) {
    canvas.save();
    canvas.scale(scale, scale, center.x, center.y);
    canvas.rotate(rotate, center.x, center.y);
    eye.draw(canvas);
    eyeBound.draw(canvas);
    for (int i = 0; i < numberOfSharingan; i++) {
      canvas.save();
      canvas.rotate(i * 120, center.x, center.y);
      sharingans[i].draw(canvas);
      canvas.restore();
    }
    canvas.restore();
  }

  @Override
  public void stopAnimator() {
    animatorSet.end();
  }

  @Override
  public void resumeAnimator() {
    animatorSet.resume();
  }

  @Override
  public void pauseAnimator() {
    animatorSet.pause();
  }
}
