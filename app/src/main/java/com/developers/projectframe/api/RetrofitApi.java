package com.developers.projectframe.api;

import com.developers.projectframe.module.home.bean.AdvisoryBean;
import com.developers.projectframe.module.home.bean.LiveCourseBean;
import com.developers.projectframe.module.home.bean.MessageBean;
import com.developers.projectframe.network.bean.BaseEntity;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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

    @GET("api/decorations/mobile/consultations")
    Observable<BaseEntity<MessageBean>> getMessageInfo();


    /**
     * POST 请求
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("api/reservations")
    Observable<BaseEntity<LiveCourseBean>> reserveLiveCourse(@FieldMap Map<String, String> params);

}
