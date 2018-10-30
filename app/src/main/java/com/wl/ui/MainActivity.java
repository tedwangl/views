package com.wl.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wl.ui.loadingview.MKLoader;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_loader1);
    final MKLoader loader = (MKLoader) findViewById(R.id.id_mk1);
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(3000);
          runOnUiThread(new Runnable() {
            @Override
            public void run() {
              loader.getLoaderView().stopAnimator();
            }
          });
          Thread.sleep(3000);
          runOnUiThread(new Runnable() {
            @Override
            public void run() {
              loader.getLoaderView().resumeAnimator();
            }
          });
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

  }
}
