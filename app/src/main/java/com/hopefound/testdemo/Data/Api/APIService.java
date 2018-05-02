package com.hopefound.testdemo.Data.Api;

import com.hopefound.testdemo.entity.BookListData;
import com.hopefound.testdemo.entity.HttpResult;
import com.hopefound.testdemo.entity.TeacherListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by 王震 on 2018/4/20 0020.
 * API
 * Don't need write cache data because used RxCache
 */

public interface APIService {

    //获取图书列表
    @GET("api/getTypeBooks")
    Observable<HttpResult<List<BookListData>>> getBookList(@Query("type") String type
            , @Query("pageIndex") int pageIndex);

    //获取老师列表
    @GET("api/getTeachers")
    Observable<HttpResult<List<TeacherListData>>> getTeacherList(@Query("collegeId") String collegeId);


}
