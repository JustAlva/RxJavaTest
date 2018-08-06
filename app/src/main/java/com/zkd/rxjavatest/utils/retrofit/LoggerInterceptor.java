package com.zkd.rxjavatest.utils.retrofit;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LoggerInterceptor implements Interceptor {
    private static final String TAG = "OkHttpUtils";
    private String tag;

    private LoggerInterceptor(String tag, boolean showResponse) {
        if (TextUtils.isEmpty(tag)) {
            tag = TAG;
        }
        this.tag = tag;
    }

    public LoggerInterceptor(String tag) {
        this(tag, false);
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        logForRequest(request);
        Response response = chain.proceed(request);
        return logForResponse(response);
    }

    private Response logForResponse(Response response) {
        try {
            //===>response log
            StringBuilder sb = new StringBuilder();
            sb.append("返回：\n");
            sb.append("========response'log=======")
                    .append("\n");
            Response.Builder builder = response.newBuilder();
            Response clone = builder.build();
            sb.append("url : ")
                    .append(clone.request().url())
                    .append("\n")
                    .append("code : ")
                    .append(clone.code())
                    .append("\n")
                    .append("protocol : ")
                    .append(clone.protocol())
                    .append("\n");
            if (!TextUtils.isEmpty(clone.message()))
                sb.append("message : ").append(clone.message()).append("\n");
            sb.append("========response'end=======");
            Log.e(tag, sb.toString());
        } catch (Exception ignored) {
        }
        return response;
    }

    private void logForRequest(Request request) {
        try {
            String url = request.url().toString();
            Headers headers = request.headers();
            StringBuilder sb = new StringBuilder();
            sb.append("请求：\n");
            sb.append("========request'log=======\n")
                    .append("method : ")
                    .append(request.method());
            if (headers != null && headers.size() > 0) {
                sb.append("headers : ").append(headers.toString()).append("\n");
            }
            sb.append("\n").append("url : ")
                    .append(url)
                    .append("\n========request'log=======end");

            Log.e(tag, sb.toString());
        } catch (Exception ignored) {
        }
    }
}
