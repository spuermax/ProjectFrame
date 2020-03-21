package com.developers.projectframe.network.subscriber;

import android.os.Looper;
import android.util.Log;

import com.developers.projectframe.R;
import com.developers.projectframe.base.BaseApplication;
import com.developers.projectframe.network.bean.BaseEntity;
import com.developers.projectframe.network.bean.BaseErrorEntity;
import com.developers.projectframe.network.exception.ApiException;
import com.developers.projectframe.utils.CommonUtil;
import com.developers.projectframe.utils.ToastUtil;

import java.io.EOFException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:20
 * @Description
 */
public abstract class CommonSubscriber <T> implements Observer<T> {


    public CommonSubscriber() {
    }

    private static final String TAG = "CommonSubscriber";

    @Override
    public void onSubscribe(Disposable d) {
        if (!CommonUtil.isNetConnect(BaseApplication.baseApp)) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                ToastUtil.shortToast(BaseApplication.baseApp, BaseApplication.baseApp.getString(R.string.network_error));
            }
        }
    }

    @Override
    public void onNext(T t) {
        if (t instanceof BaseEntity) {
            //新接口
            BaseEntity tResponse = ((BaseEntity) t);
            if (tResponse.getCode() != 0 || tResponse.getData() == null) {
                onFail(new ApiException(tResponse.getCode() + "", tResponse.getMessage()));
            } else {
                onSuccess(t);
            }
        } else if (t instanceof BaseErrorEntity) {
            BaseErrorEntity errorEntity = (BaseErrorEntity) t;
            if (errorEntity.error != null && errorEntity.error.getCode() != null) {
                onFail(new ApiException(errorEntity.error.getCode() + "", errorEntity.error.getMessage()));
            } else {
                onSuccess(t);
            }
        } else {
            onSuccess(t);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e.getMessage() != null) {
            Log.e(TAG, e.getMessage());
        }
        if (e instanceof HttpException) {
            ResponseBody body = ((HttpException) e).response().errorBody();
            onFail(new ApiException(((HttpException) e).code() + "", e.getMessage(), body));
        } else if (e instanceof EOFException) {
            onFail(new ApiException("0", ""));
        }
    }

    @Override
    public void onComplete() {
        Log.i(TAG, "请求成功");
    }

    /**
     * 请求正确
     */
    public abstract void onSuccess(T t);

    /**
     * 请求错误
     */
    public abstract void onFail(ApiException e);

}
