package com.yaxon.wuliudriver.http.interceptor;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:okhttp 请求头拦截器
 * Created by kimiffy on 2019/3/11.
 */

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request.Builder builder = originalRequest.newBuilder()
                .addHeader("Accept-Encoding", "gzip")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("UserId","")
                .addHeader("SessionId","")
                .method(originalRequest.method(), originalRequest.body());

        // TODO: 2019/3/11 加入token
       // builder.addHeader("token", "");

        return chain.proceed(builder.build());
    }
}
