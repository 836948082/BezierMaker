package com.runtai.beziermaker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.runtai.beziermaker.R;
import com.runtai.beziermaker.commonview.VerticalAutoScrollView;
import com.runtai.beziermaker.entity.AdInfo;
import com.runtai.beziermaker.rxjavaoretrofit.view.activities.WeatherActivity;
import com.runtai.beziermaker.utils.ToastManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private VerticalAutoScrollView mAutoScrollView;
    private Button mRxRetrofitBtn;
    private Button mBezierBtn;

    // 退出时间
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupView() {
        mAutoScrollView = getView(R.id.top_autoscrllo);
        mRxRetrofitBtn = getView(R.id.rxretro_btn);
        mBezierBtn = getView(R.id.bezier_btn);
    }

    @Override
    protected void initializedData() {
        mAutoScrollView.setData(getData());
        mAutoScrollView.setClickListener(new VerticalAutoScrollView.OnItemClickListener<AdInfo>() {
            @Override
            public void onItemClick(View v, AdInfo adInfo) {
                Log.e("adInfo", "adInfo" + adInfo.url);
                // 这里可根据不同的Url地址加载不同的页面跳转
                startActivity(new Intent(mContext, CouponActivity.class));
            }
        });

        mRxRetrofitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, WeatherActivity.class));
            }
        });

        mBezierBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, BezierActivity.class));
            }
        });
    }

    /*获取数据*/
    private List<AdInfo> getData() {
        List<AdInfo> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AdInfo item;
            if (i % 2 == 0) {
                item = new AdInfo("this is WELCOME I= ", "url-1");
            } else {
                item = new AdInfo("电视专场 客户一张优惠券点击查看详情 ", "url-2");
            }
            datas.add(item);
        }
        return datas;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastManager.showToast(mContext, "再按一次退出程序", 1);
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
