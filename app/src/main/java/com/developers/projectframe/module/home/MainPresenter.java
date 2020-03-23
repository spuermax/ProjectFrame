package com.developers.projectframe.module.home;

import com.developers.projectframe.api.RetrofitApi;
import com.developers.projectframe.module.home.bean.AdvisoryBean;
import com.developers.projectframe.module.home.bean.LiveCourseBean;
import com.developers.projectframe.module.home.contract.MainContract;
import com.developers.projectframe.network.ApiUtil;
import com.developers.projectframe.network.base.BasePresenter;
import com.developers.projectframe.network.bean.BaseEntity;
import com.developers.projectframe.network.exception.ApiException;
import com.developers.projectframe.network.subscriber.CommonSubscriber;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author yinzh
 * @Date 2020/3/21 18:22
 * @Description
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {

    public MainPresenter(MainContract.IMainView view) {
        super(view);
    }

    @Override
    public void requestData(boolean isLoadMore) {

    }

    @Override
    public void getAdvisoryInfo() {
        ApiUtil.getInstance().create(RetrofitApi.class)
                .getAdvisoryInfo()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CommonSubscriber<BaseEntity<AdvisoryBean>>() {
                    @Override
                    public void onSuccess(BaseEntity<AdvisoryBean> advisoryBeanBaseEntity) {
                        view.setAdvisoryInfo(advisoryBeanBaseEntity.getData());
                    }

                    @Override
                    public void onFail(ApiException e) {

                    }
                });
    }

    @Override
    public void reserveLiveCourse(Map<String, String> map) {

        ApiUtil.getInstance().create(RetrofitApi.class)
                .reserveLiveCourse(map)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CommonSubscriber<BaseEntity<LiveCourseBean>>() {

                    @Override
                    public void onSuccess(BaseEntity<LiveCourseBean> liveCourseBeanBaseEntity) {
                        view.setReserveLiveCourse(liveCourseBeanBaseEntity.getData());
                    }

                    @Override
                    public void onFail(ApiException e) {
                        view.setReserveError(e.getDisplayMessage());
                    }
                });
    }
}
