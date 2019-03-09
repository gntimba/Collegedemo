package com.demo.college_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getActionBar().hide();
    }
}
