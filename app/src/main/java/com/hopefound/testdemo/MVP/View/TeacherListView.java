package com.hopefound.testdemo.MVP.View;

import com.hopefound.testdemo.entity.TeacherListData;

import java.util.List;

/**
 * Created by 王震 on 2018/4/23 0023.
 */

public interface TeacherListView {

    //显示加载页面
    void showProgress();
    //关闭加载页面
    void hideProgress();
    //刷新数据
    void newDatas(List<TeacherListData> newslist);
    //加载数据
    void addDatas(List<TeacherListData> addList);
    //显示加载失败
    void showLoadFailMsg();
    //显示已经加载了所有数据
    void showLoadCompleteAllData();
    //显示没有数据
    void showNoData();

}
