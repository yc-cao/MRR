package com.yunchao.mrcao.mvpretrofitrxjava.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yunchao.mrcao.mvpretrofitrxjava.R;
import com.yunchao.mrcao.mvpretrofitrxjava.service.bean.Book;
import com.yunchao.mrcao.mvpretrofitrxjava.service.presenter.BookPresenter;
import com.yunchao.mrcao.mvpretrofitrxjava.service.view.BookView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mText;
    private Button mBt;
    private BookPresenter mBookPresenter = new BookPresenter(this);
    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book mBook) {
            mText.setText(mBook.toString());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
        mBt = (Button) findViewById(R.id.button);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBookPresenter.onStop();
    }
}
