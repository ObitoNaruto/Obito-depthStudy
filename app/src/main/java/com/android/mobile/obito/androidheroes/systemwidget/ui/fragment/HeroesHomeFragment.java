package com.android.mobile.obito.androidheroes.systemwidget.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.mobile.obito.R;
import com.android.mobile.obito.androidheroes.systemwidget.ui.activity.SystemWidgetActivity;
import com.android.mobile.obito.home.control.NavigateControl;
import com.android.mobile.obito.home.ui.fragment.BaseObitoFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xinming.xxm on 2016/4/23.
 */
public class HeroesHomeFragment extends BaseObitoFragment{

    @Bind(R.id.tv_systemwidget)
    TextView tvSystemWidget;

    @Override
    protected View initRootView(LayoutInflater inflater) {
        View rootView = inflater.inflate(R.layout.fragment_home_heroes, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        tvSystemWidget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_systemwidget:
                NavigateControl.gotoSpecifiedActivity(getActivity(), SystemWidgetActivity.class);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
