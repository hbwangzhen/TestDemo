package com.hopefound.testdemo.Data.HttpData;

import com.hopefound.testdemo.Data.Api.APIService;
import com.hopefound.testdemo.Data.Api.CacheProviders;
import com.hopefound.testdemo.Data.Retrofit.ApiException;
import com.hopefound.testdemo.Data.Retrofit.RetrofitUtils;
import com.hopefound.testdemo.entity.BookListData;
import com.hopefound.testdemo.entity.HttpResult;
import com.hopefound.testdemo.entity.TeacherListData;
import com.hopefound.testdemo.utils.FileUtil;

import java.io.File;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import rx.functions.Func1;


/**
 * Created by 王震 on 2018/4/20 0020.
 */

public class HttpData extends RetrofitUtils {

    private static File cacheDirectory = FileUtil.getcacheDirectory();
    private static final CacheProviders provides = new RxCache.Builder()
            .persistence(cacheDirectory,new GsonSpeaker())
            .using(CacheProviders.class);

    protected static final APIService service = getRetrofit().create(APIService.class);

    private static class SingletonHolder{
        private static final HttpData INSTANCE = new HttpData();
    }

    public static HttpData getInstance(){
        return SingletonHolder.INSTANCE;
    }

   public void httpDatatoBookList(String type , int pageIndex , Observer<List<BookListData>> observer){
       Observable observable = service.getBookList(type,pageIndex).map(new HttpResultFunc<>());
       Observable observableCache = provides.getBookList(observable,new DynamicKey("booklist"+type + pageIndex),new EvictDynamicKey(false))
               .map(new HttpResultFuncCache<List<BookListData>>());
       setSubscribe(observableCache,observer);
   }

   public void httpDatatoTeacherList(String collegeId , Observer<List<TeacherListData>> observer){
       Observable observable = service.getTeacherList(collegeId).map(new HttpResultFunc());
       Observable observableCache = provides.getTeacherList(observable,new DynamicKey("teacherList"),new EvictDynamicKey(false))
               .map(new HttpResultFuncCache<TeacherListData>());
       setSubscribe(observableCache,observer);
   }

    /**
     * input observable
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * for dealing http resultCode ,and devide the data and return to subscriber
     * @param <T>
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>,T>, Function {
        @Override
        public T call(com.hopefound.testdemo.entity.HttpResult<T> tHttpResult) {
            if (tHttpResult.getCode() != 1){
                throw new ApiException(tHttpResult);
            }
            return tHttpResult.getData();
        }

        @Override
        public Object apply(Object o) throws Exception {
            return null;
        }
    }

    private class HttpResultFuncCache<T> implements Func1<Reply<T>,T>, Function {

        @Override
        public T call(Reply<T> tReply) {
            return tReply.getData();
        }

        @Override
        public Object apply(Object o) throws Exception {
            return null;
        }
    }
}
