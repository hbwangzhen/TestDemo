package com.hopefound.testdemo.MVP.Presenter;

import com.hopefound.testdemo.MVP.Listener.OnLoadDataListListener;
import com.hopefound.testdemo.MVP.Model.BookListModel;
import com.hopefound.testdemo.MVP.View.BookListView;
import com.hopefound.testdemo.entity.BookListData;

import java.util.List;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public class BookListPresent implements OnLoadDataListListener <List<BookListData>>{

    private BookListView mView;
    private BookListModel mModel;

    private boolean isjz;

    public BookListPresent(BookListView mView) {
        this.mView = mView;
        this.mModel = new BookListModel();
        mView.showProgress();
    }

    public void loadData(String type,int PageIndex,boolean isjz){
        this.isjz = isjz;
        mModel.loadData(type,PageIndex,this);
    }

    @Override
    public void onSuccess(List<BookListData> data) {
        if (isjz){
            if (data.size()==0){
                mView.showLoadCompleteAllData();
            }else {
                mView.addDatas(data);
            }
        }else {
            if (data.size() == 0){
                mView.showNoData();
            }else {
                mView.newDatas(data);
            }
        }
        mView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
