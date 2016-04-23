package com.android.mobile.obito.home.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**Fragment基类
 * Created by xinming.xxm on 2016/4/21.
 */
public abstract class BaseObitoFragment extends Fragment implements View.OnClickListener{
    protected View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(null == mRootView){
            mRootView = initRootView(inflater);
            initView();
            initListener();
        }
        return mRootView;
    }

    protected abstract View initRootView(LayoutInflater inflater);

    protected abstract void initView();

    protected abstract void initListener();

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
