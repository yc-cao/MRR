package com.yunchao.mrcao.mvpretrofitrxjava.service.presenter;

import android.content.Context;
import android.content.Intent;

import com.yunchao.mrcao.mvpretrofitrxjava.service.bean.Book;
import com.yunchao.mrcao.mvpretrofitrxjava.service.manager.DataManager;
import com.yunchao.mrcao.mvpretrofitrxjava.service.view.BookView;
import com.yunchao.mrcao.mvpretrofitrxjava.service.view.View;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Mr.Cao on 2017/4/5.
 */

public class BookPresenter implements Presenter {
    private DataManager mManager;
    private Context mContext;
    private CompositeSubscription mCompositeSubscription;
    private BookView mBookView;
    private Book mBook;

    public BookPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        mManager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        mBookView = (BookView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getSearchBooks(String name, String tag, int start, int count) {
        mCompositeSubscription.add(mManager.getSearchBooks(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (mBook != null) {
                            mBookView.onSuccess(mBook);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mBookView.onError("请求失败!");
                    }

                    @Override
                    public void onNext(Book book) {
                        mBook = (Book) book;
                    }
                })
        );
    }
}
