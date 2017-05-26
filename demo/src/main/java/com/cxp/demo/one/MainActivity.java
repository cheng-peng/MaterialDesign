package com.cxp.demo.one;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cxp.demo.R;

/**
 * 是否限制在某View内
 * clipChildren="false"   不限制， 所以说可能会高出某View   必须设置在跟布局
 * android:layout_gravity控制超出的部分如何显示
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
