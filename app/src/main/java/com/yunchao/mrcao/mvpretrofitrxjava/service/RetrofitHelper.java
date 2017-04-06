package com.yunchao.mrcao.mvpretrofitrxjava.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mr.Cao on 2017/4/5.
 */

public class RetrofitHelper {

    private Context mContext;
    OkHttpClient mClient = new OkHttpClient();
    GsonConverterFactory mFactory = GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper sRetrofitHelper = null;
    private Retrofit mRetrofit = null;

    private RetrofitHelper(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(mClient)
                .addConverterFactory(mFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }
    public static RetrofitHelper getRetrofitHelper(Context context) {
        if (sRetrofitHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (sRetrofitHelper == null) {
                    sRetrofitHelper = new RetrofitHelper(context);
                }
            }
        }
        return sRetrofitHelper;
    }
}
