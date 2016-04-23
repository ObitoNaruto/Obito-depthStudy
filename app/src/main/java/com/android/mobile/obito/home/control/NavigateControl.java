package com.android.mobile.obito.home.control;

import android.content.Context;
import android.content.Intent;

/**
 * Created by xinming.xxm on 2016/4/22.
 */
public class NavigateControl {

    public static void gotoSpecifiedActivity(Context context, Class clazz){
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
