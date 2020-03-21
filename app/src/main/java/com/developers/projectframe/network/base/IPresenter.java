package com.developers.projectframe.network.base;

import io.reactivex.disposables.Disposable;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:17
 * @Description
 */
public interface IPresenter {
    //默认初始化
    void start();

    //Activity关闭把view对象置为空
    void detach();

    //将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
    void addDisposable(Disposable subscription);

    //注销所有请求
    void unDisposable();

}
