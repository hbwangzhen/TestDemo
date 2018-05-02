package com.hopefound.testdemo.MVP.Presenter;

import com.hopefound.testdemo.MVP.Listener.OnLoadDataListListener;
import com.hopefound.testdemo.MVP.Model.TeacherModle;
import com.hopefound.testdemo.MVP.View.TeacherListView;
import com.hopefound.testdemo.entity.TeacherListData;

import java.util.List;

/**
 * Created by 王震 on 2018/4/23 0023.
 */

public class TeacherPresent implements OnLoadDataListListener<List<TeacherListData>>{

    private TeacherListView mTeacherListview;
    private TeacherModle mTeacherModle;

    private boolean isJz;

    public TeacherPresent(TeacherListView mTeacherListview) {
        this.mTeacherListview = mTeacherListview;
        this.mTeacherModle = new TeacherModle();
        mTeacherListview.showProgress();
    }

    public void loadData(String collegeId , boolean isJz){
        mTeacherModle.getTeacherlist(collegeId,this);
        this.isJz = isJz;
    }

    @Override
    public void onSuccess(List<TeacherListData> data) {
        if (isJz){

        }
    }

    @Override
    public void onFailure(Throwable e) {

    }
}
