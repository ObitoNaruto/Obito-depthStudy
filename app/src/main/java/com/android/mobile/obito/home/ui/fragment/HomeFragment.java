package com.android.mobile.obito.home.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.mobile.obito.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**首页Fragment
 * Created by xinming.xxm on 2016/4/22.
 */
public class HomeFragment extends BaseObitoFragment{
    @Bind(R.id.tv_widget)
    TextView tvWidget;

    @Override
    protected View initRootView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        tvWidget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.tv_widget:
//                NavigateControl.gotoSpecifiedActivity(getContext(), WigetActivity.class);
                break;
        }
    }
}
