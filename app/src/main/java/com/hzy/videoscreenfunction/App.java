package com.hzy.videoscreenfunction;

import android.app.Application;

import com.hzy.videoscreenfunction.manager.VideoPlayManeger;

/**
 * Created by hzy on 2019/1/14
 **/
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //待机视频
        VideoPlayManeger.init(this);
        VideoPlayManeger.startMonitor();
        VideoPlayManeger.eliminateEvent();
    }
}
