package com.yunchao.mrcao.mvpretrofitrxjava.service;

import com.yunchao.mrcao.mvpretrofitrxjava.service.bean.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Mr.Cao on 2017/4/5.
 */

public interface RetrofitService {

    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name
                                    , @Query("tag") String tag
                                    , @Query("start") int start
                                    , @Query("count") int count);
}
