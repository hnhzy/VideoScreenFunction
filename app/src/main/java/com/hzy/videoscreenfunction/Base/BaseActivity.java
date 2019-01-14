package com.hzy.videoscreenfunction.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.hzy.videoscreenfunction.manager.VideoPlayManeger;

import butterknife.ButterKnife;

/**
 * Created by hzy on 2019/1/14
 **/
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        intData();
    }

    public abstract int getLayout();
    public abstract void initView();
    public abstract void intData();

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            VideoPlayManeger.eliminateEvent();//设置手指离开屏幕的时间
        }
        return super.dispatchTouchEvent(ev);
    }
}
