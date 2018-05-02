package com.hopefound.testdemo.MVP.View;

import com.hopefound.testdemo.entity.BookListData;

import java.util.List;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public interface BookListView {

    //显示加载页面
    void showProgress();
    //关闭加载页面
    void hideProgress();
    //刷新数据
    void newDatas(List<BookListData> newslist);
    //加载数据
    void addDatas(List<BookListData> addList);
    //显示加载失败
    void showLoadFailMsg();
    //显示已经加载了所有数据
    void showLoadCompleteAllData();
    //显示没有数据
    void showNoData();
}
