package com.runtai.beziermaker.rxjavaoretrofit.model.callback;


import com.runtai.beziermaker.rxjavaoretrofit.bean.WeatherBean;

/**
 * @DateTime: 2016-07-08 11:03
 * @Author: gjson
 * @Deacription: 天气请求回调
 */
public interface OnWeatherCallback {
    void onResponse(WeatherBean weatherBean);
    void onFailure(String error);
}
