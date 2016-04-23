package com.android.mobile.obito.androidheroes.systemwidget.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.mobile.obito.R;
import com.android.mobile.obito.home.ui.activity.BaseObitoActivity;

import butterknife.Bind;

/**
 * Created by xinming.xxm on 2016/4/23.
 */
public class SystemWidgetActivity extends BaseObitoActivity{

    @Bind(R.id.toolbar)
    Toolbar toolBar;

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_systemwidget);
    }

    @Override
    protected void initView() {
        //初始化Titlebar
        initToolBar(toolBar, true, "SystemWidget");
        mIntent = new Intent(this, MyViewTest.class);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    /**
     * View的测量
     * @param view
     */
    public void btnTeaching(View view) {
        mIntent.putExtra("flag", 0);
        startActivity(mIntent);
    }

    /**
     * 自定义View之对现有组件进行扩展--为TextView添加一个背景框
     * @param view
     */
    public void btnMyTextView(View view) {
        mIntent.putExtra("flag", 1);
        startActivity(mIntent);
    }

    /**
     * 自定义View之对现有组件进行扩展--使用LinearGradient Shader和Matrix实现一个动态的文字闪动效果
     * @param view
     */
    public void btnShineTextView(View view) {
        mIntent.putExtra("flag", 2);
        startActivity(mIntent);
    }

    /**
     * 重写View来实现全新的控件---弧线展示图
     * @param view
     */
    public void btnCircleProgress(View view) {
        mIntent.putExtra("flag", 3);
        startActivity(mIntent);
    }

    /**
     * 重写View来实现全新的控件---音频条形图
     * @param view
     */
    public void btnVolumeView(View view) {
        mIntent.putExtra("flag", 4);
        startActivity(mIntent);
    }

    /**
     * 自定义VIewGroup--实现类似Android原生控件ScrollView的自定义ViewGroup
     * @param view
     */
    public void btnMyScrollView(View view) {
        mIntent.putExtra("flag", 5);
        startActivity(mIntent);
    }

    /**
     * 创建复合组件--标题栏TitleBar
     * @param view
     */
    public void btnTopBar(View view) {
        startActivity(new Intent(this, TopBarTest.class));
    }
}
