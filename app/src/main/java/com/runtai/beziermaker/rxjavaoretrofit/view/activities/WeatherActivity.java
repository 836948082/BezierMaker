package com.runtai.beziermaker.rxjavaoretrofit.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.runtai.beziermaker.R;
import com.runtai.beziermaker.rxjavaoretrofit.presenter.impl.WeatherPresenterImpl;
import com.runtai.beziermaker.rxjavaoretrofit.presenter.interfaces.IWeatherPresenter;
import com.runtai.beziermaker.rxjavaoretrofit.view.interfaces.IWeatherView;

/**
 * View层实现类
 */
public class WeatherActivity extends AppCompatActivity implements View.OnClickListener,IWeatherView {
    private Button search;
    private TextView show;

    //持有presenter层引用
    private IWeatherPresenter presenter = new WeatherPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        show = (TextView) findViewById(R.id.show);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        presenter.getWeather();
    }

    @Override
    public void setTextShow(String weatherString) {
        show.setText(weatherString);
    }
}
