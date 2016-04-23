package com.android.mobile.obito.androidheroes.systemwidget.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.android.mobile.obito.R;
import com.android.mobile.obito.androidheroes.systemwidget.widget.CircleProgressView;

public class MyViewTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getIntExtra("flag", -1);
        switch (flag) {
            //View的测量
            case 0:
                setContentView(R.layout.teaching_systemwidget);
                break;
            //自定义View之对现有组件进行扩展--为TextView添加一个背景框
            case 1:
                setContentView(R.layout.my_textview_systemwidget);
                break;
            //自定义View之对现有组件进行扩展--使用LinearGradient Shader和Matrix实现一个动态的文字闪动效果
            case 2:
                setContentView(R.layout.shine_textview_systemwidget);
                break;
            case 3:
                setContentView(R.layout.circle_progress_systemwidget);
                CircleProgressView circle = (CircleProgressView) findViewById(R.id.circle);
                circle.setSweepValue(0);
                break;
            case 4:
                setContentView(R.layout.volume_systemwidget);
                break;
            case 5:
                //自定义VIewGroup--实现类似Android原生控件ScrollView的自定义ViewGroup
                setContentView(R.layout.my_scrollview_systemwidget);
                break;
        }
    }
}
