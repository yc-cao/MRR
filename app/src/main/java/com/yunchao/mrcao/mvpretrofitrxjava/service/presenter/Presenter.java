package com.yunchao.mrcao.mvpretrofitrxjava.service.presenter;

import android.content.Intent;

import com.yunchao.mrcao.mvpretrofitrxjava.service.view.View;

/**
 * Created by Mr.Cao on 2017/4/5.
 */

public interface Presenter {
    void onCreate();

    void onStart();//暂时没用到

    void onStop();

    void pause();//暂时没用到

    void attachView(View view);

    void attachIncomingIntent(Intent intent);//暂时没用到
}
