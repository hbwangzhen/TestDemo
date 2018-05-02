package com.hopefound.testdemo.MVP.Model;

import com.hopefound.testdemo.Data.HttpData.HttpData;
import com.hopefound.testdemo.MVP.Listener.OnLoadDataListListener;
import com.hopefound.testdemo.entity.BookListData;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public class BookListModel {
    public void loadData(String type , int PageIndex, final OnLoadDataListListener listener){
        HttpData.getInstance().httpDatatoBookList(type, PageIndex, new Observer<List<BookListData>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<BookListData> bookListData) {
                    listener.onSuccess(bookListData);
            }

            @Override
            public void onError(Throwable e) {
                    listener.onFailure(e);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
