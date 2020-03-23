package com.developers.projectframe.module.home.contract;

import com.developers.projectframe.module.home.bean.AdvisoryBean;
import com.developers.projectframe.module.home.bean.LiveCourseBean;
import com.developers.projectframe.network.base.IView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yinzh
 * @Date 2020/3/21 18:23
 * @Description
 */
public class MainContract {

    public interface IMainView extends IView {
        void requestData();

        void setAdvisoryInfo(AdvisoryBean bean);

        void setReserveLiveCourse(LiveCourseBean liveCourse);

        void setReserveError(String  msg);
    }

    public interface IMainPresenter {
        void requestData(boolean isLoadMore);

        void getAdvisoryInfo();

        void reserveLiveCourse(Map<String ,String > map);
    }
}
