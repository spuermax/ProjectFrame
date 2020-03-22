package com.developers.projectframe.network;

import com.developers.projectframe.R;
import com.developers.projectframe.base.BaseApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:07
 * @Description
 */
public class ApiUtil {

    private static final int DEFAULT_TIME_OUT = 20;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 20;

    private static ApiUtil mInstance;
    private boolean isOldApi = false;
    private boolean isOldToken = false;

    public static ApiUtil getInstance() {
        mInstance = new ApiUtil();
        mInstance.isOldApi = false;
        mInstance.isOldToken = false;
        return mInstance;
    }


    private OkHttpClient InterceptClient(final boolean haveToken) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 创建 OKHttpClient
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作 超时时间


        //设置头信息
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        .method(originalRequest.method(), originalRequest.body());

                requestBuilder.addHeader("platform", "android");//登录平台
                requestBuilder.addHeader("Content-Type", "application/json");
                requestBuilder.addHeader("Accept", "application/vnd.edusoho.v2+json");


                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        //处理重定向到https
        Interceptor RedirectInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl beforeUrl = request.url();
                Response response = chain.proceed(request);
                HttpUrl afterUrl = response.request().url();
                //1.根据url判断是否是重定向
                if (!beforeUrl.equals(afterUrl)) {
                    //处理两种情况 1、跨协议 2、原先不是GET请求。
                    if (!beforeUrl.scheme().equals(afterUrl.scheme()) || !request.method().equals("GET")) {
                        //重新请求
                        Request newRequest = request.newBuilder().url(response.request().url()).build();
                        response = chain.proceed(newRequest);
                    }
                }
                return response;
            }
        };



        builder.addInterceptor(headerInterceptor);
        builder.addInterceptor(RedirectInterceptor);



        //调试信息
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //设置 Debug Log 模式
        builder.addInterceptor(loggingInterceptor);

        return builder.build();
    }

    /**
     *  创建 API 实例
     */
    public <T> T create(Class<T> service) {
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(this.InterceptClient(true))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseApplication.baseApp.getString(R.string.app_base_url) + "/") // 替换自己的host
                .build();
        return mRetrofit.create(service);
    }



}
