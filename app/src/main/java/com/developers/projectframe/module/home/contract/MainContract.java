package com.developers.projectframe.module.home.contract;

import com.developers.projectframe.module.home.bean.AdvisoryBean;
import com.developers.projectframe.network.base.IView;

/**
 * @Author yinzh
 * @Date 2020/3/21 18:23
 * @Description
 */
public class MainContract {

    public interface IMainView extends IView {
        void requestData();

        void setAdvisoryInfo(AdvisoryBean bean);
    }

    public interface IMainPresenter {
        void requestData(boolean isLoadMore);

        void getAdvisoryInfo();
    }
}
