package com.runtai.beziermaker.activity;

import android.os.Bundle;

import com.runtai.beziermaker.R;
import com.runtai.beziermaker.commonview.BezierView;
import com.runtai.beziermaker.utils.ScreenUtil;

/**
 * Created by gjson on 16/9/6.
 * Name BezierActivity
 * Version 1.0
 */
public class BezierActivity extends BaseActivity {

    private BezierView mBezierView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bezier;
    }

    @Override
    protected void setupView() {
        mBezierView = getView(R.id.bezier_view);
    }

    @Override
    protected void initializedData() {
        mBezierView.setDefaultResourceImgList();
        // startAnimation 默认裸奔200秒
        mBezierView.startAnimation(ScreenUtil.getScreenWidth(mContext), ScreenUtil.getScreenHeight(mContext), 1000);
    }
}
