package com.runtai.beziermaker.rxjavaoretrofit.presenter.impl;

import com.runtai.beziermaker.rxjavaoretrofit.bean.WeatherBean;
import com.runtai.beziermaker.rxjavaoretrofit.model.callback.OnWeatherCallback;
import com.runtai.beziermaker.rxjavaoretrofit.model.impl.WeatherRxJavaModelImpl;
import com.runtai.beziermaker.rxjavaoretrofit.presenter.interfaces.IWeatherPresenter;
import com.runtai.beziermaker.rxjavaoretrofit.view.interfaces.IWeatherView;
import com.runtai.beziermaker.rxjavaoretrofit.model.interfaces.IWeatherModel;

/**
 * @DateTime: 2016-07-08 10:31
 * @Author: gjson
 * @Deacription: presenter实现类
 */
public class WeatherPresenterImpl implements IWeatherPresenter, OnWeatherCallback {
    private IWeatherView iMainActivity;
    private IWeatherModel iWeatherModel;

    public WeatherPresenterImpl(IWeatherView iMainActivity) {
        this.iMainActivity = iMainActivity;
        //iWeatherModel = new WeatherNetModelImpl(this);
        iWeatherModel = new WeatherRxJavaModelImpl(this);
    }

    @Override
    public void getWeather() {
        iWeatherModel.getWeather();
    }

    @Override
    public void onResponse(WeatherBean weatherBean) {
        iMainActivity.setTextShow(weatherBean.weatherinfo.toString());
    }

    @Override
    public void onFailure(String error) {
        iMainActivity.setTextShow(error);
    }
}
