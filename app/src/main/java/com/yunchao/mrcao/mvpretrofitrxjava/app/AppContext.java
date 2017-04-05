package com.yunchao.mrcao.mvpretrofitrxjava.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Mr.Cao on 2017/3/10.
 */

public class AppContext extends Application {
    private static AppContext sContext = null;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sContext = this;
    }

    public static AppContext context() {
        return sContext;
    }
}
