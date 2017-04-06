package com.yunchao.mrcao.mvpretrofitrxjava.service.view;

import com.yunchao.mrcao.mvpretrofitrxjava.service.bean.Book;

/**
 * Created by Mr.Cao on 2017/4/5.
 */

public interface BookView extends View {
    void onSuccess(Book mBook);
    void onError(String result);
}
