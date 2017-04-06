package com.yunchao.mrcao.mvpretrofitrxjava.service.manager;

import android.content.Context;

import com.yunchao.mrcao.mvpretrofitrxjava.service.RetrofitHelper;
import com.yunchao.mrcao.mvpretrofitrxjava.service.RetrofitService;
import com.yunchao.mrcao.mvpretrofitrxjava.service.bean.Book;

import rx.Observable;

/**
 * Created by Mr.Cao on 2017/4/5.
 */

public class DataManager {

    private RetrofitService mRetrofitService;

    public DataManager(Context context) {
        this.mRetrofitService = RetrofitHelper.getRetrofitHelper(context).getServer();
    }

    public Observable<Book> getSearchBooks(String name,String tag,int start,int count) {
        return mRetrofitService.getSearchBooks(name, tag, start, count);
    }
}
