package com.developers.projectframe.module.home;

import com.developers.projectframe.module.home.contract.MainContract;
import com.developers.projectframe.network.base.BasePresenter;

/**
 * @Author yinzh
 * @Date 2020/3/21 18:22
 * @Description
 */
public class MainPresenter extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter{

    public MainPresenter(MainContract.IMainView view) {
        super(view);
    }

    @Override
    public void requestData(boolean isLoadMore) {

    }
}
