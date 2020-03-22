package com.developers.projectframe.api;

import com.developers.projectframe.module.home.bean.AdvisoryBean;
import com.developers.projectframe.network.bean.BaseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @Author yinzh
 * @Date 2020/3/22 09:48
 * @Description 接口 API
 */
public interface RetrofitApi {

    /**
     * 咨询入口
     */
    @GET("api/decorations/mobile/consultations")
    Observable<BaseEntity<AdvisoryBean>> getAdvisoryInfo();
}
