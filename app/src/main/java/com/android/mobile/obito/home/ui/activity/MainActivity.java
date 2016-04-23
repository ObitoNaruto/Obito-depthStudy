package com.android.mobile.obito.home.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.android.mobile.obito.R;
import com.android.mobile.obito.androidheroes.systemwidget.ui.fragment.HeroesHomeFragment;
import com.android.mobile.obito.home.ui.fragment.HomeFragment;

import butterknife.Bind;


public class MainActivity extends BaseObitoActivity {

    @Bind(R.id.toolbar)
    Toolbar toolBar;
    @Bind(R.id.main_drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.fl_container)
    FrameLayout flContainer;
    @Bind(R.id.nv_left_layout)
    NavigationView leftNavigationView;
    @Bind(R.id.nv_right_layout)
    NavigationView rightNavigationView;

    private MenuItem leftCheckedItem;
    private MenuItem rightCheckedItem;

    public int lastFragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        //初始化Titlebar
        initToolBar(toolBar, true, R.string.app_name);
        //ActionBarDrawerToggle配合Toolbar，实现Toolbar上菜单按钮开关效果。
        //ActionBarDrawerToggle是一个开关，用于打开/关闭DrawerLayout抽屉
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, 0, 0);
        drawerToggle.syncState();

        controlShowFragment(lastFragmentIndex);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        //左侧菜单
        leftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //当左边的导航栏item项被点击时，右边导航栏item取消选中状态
                if (rightCheckedItem != null && rightCheckedItem.isChecked()) {
                    rightCheckedItem.setChecked(false);
                }
                leftCheckedItem = item;
                switch (item.getItemId()){
                    //群英传
                    case R.id.left_menu_heros:
                        controlShowFragment(1);
                        toolBar.setTitle("群英传");
                        break;
                    default:
                        controlShowFragment(0);
                        toolBar.setTitle("Obito");
                        break;
                }
                //设置当前item选中状态
                item.setChecked(true);
                //点击后主动关闭左侧导航栏
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
        //右侧菜单
        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                //当右侧的导航栏item项被点击时，右边导航栏item取消选中状态
                if (leftCheckedItem != null && leftCheckedItem.isChecked()) {
                    leftCheckedItem.setChecked(false);
                }
                rightCheckedItem = item;
                switch (item.getItemId()){
                    case R.id.right_menu_RxJava:
                        controlShowFragment(0);
                        toolBar.setTitle("RxJava");
                        break;
                    default:
                        controlShowFragment(0);
                        toolBar.setTitle("Obito");
                        break;
                }
                //设置当前item选中状态
                item.setChecked(true);
                //点击后主动关闭左侧导航栏
                drawerLayout.closeDrawer(Gravity.RIGHT);
                return false;
            }
        });
    }

    /**
     * 显示对应的Fragment
     * @param position
     */
    private void controlShowFragment(int position){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment lastFragment = fragmentManager.findFragmentByTag(makeTag(lastFragmentIndex));

        //隐藏上一个Fragment
        if (lastFragment != null) {
            fragmentTransaction.hide(lastFragment);
        }
        lastFragmentIndex = position;

        Fragment currentFragment = fragmentManager.findFragmentByTag(makeTag(position));
        if (currentFragment != null) {
            fragmentTransaction.show(currentFragment);
        } else {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                //左边的NavigationView打开
                fragmentTransaction.add(R.id.fl_container, getLeftFragment(position), makeTag(position));
            } else if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                //右边的NavigationView打开
                fragmentTransaction.add(R.id.fl_container, getRightFragment(position), makeTag(position));
            } else {
                //第一次进入程序时调用，加载索引为0的Fragment
                fragmentTransaction.add(R.id.fl_container, getRightFragment(0), makeTag(position));
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 获取Fragment的tag
     * @param position
     * @return
     */
    private String makeTag(int position) {
        return R.id.fl_container + "_" + position;
    }

    private Fragment getLeftFragment(int position){
        Fragment fragment;
        switch (position){
            case 1:
                fragment = new HeroesHomeFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        return fragment;
    }

    private Fragment getRightFragment(int position){
        Fragment fragment;
        switch (position){
            case 1:
                fragment = new HomeFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        return fragment;
    }

    private long lastBackKeyDownTick = 0;
    public static final long MAX_DOUBLE_BACK_DURATION = 1500;
    @Override
    public void onBackPressed() {
        //如果左侧导航菜单打开，则关闭它
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
        //如果右侧导航菜单打开，则关闭它
        if(drawerLayout.isDrawerOpen(Gravity.RIGHT)){
            drawerLayout.closeDrawer(Gravity.RIGHT);
        }

        //连续双击退出
        long currentTick = System.currentTimeMillis();
        if (currentTick - lastBackKeyDownTick > MAX_DOUBLE_BACK_DURATION) {
            Snackbar.make(drawerLayout, "再按一次退出", Snackbar.LENGTH_SHORT).show();
            lastBackKeyDownTick = currentTick;
        } else {
            finish();
        }
    }
}
