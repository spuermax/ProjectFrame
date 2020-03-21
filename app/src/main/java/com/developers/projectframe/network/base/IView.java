package com.developers.projectframe.network.base;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:17
 * @Description
 */
public interface IView {
    void showLoadingDialog(String msg);

    void dismissLoadingDialog(String msg);
}