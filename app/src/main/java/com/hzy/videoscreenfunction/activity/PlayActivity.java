package com.hzy.videoscreenfunction.activity;

import com.hzy.videoscreenfunction.Base.BaseActivity;
import com.hzy.videoscreenfunction.R;
import com.hzy.videoscreenfunction.manager.VideoPlayManeger;

import butterknife.BindView;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by hzy on 2019/1/14
 **/
public class PlayActivity extends BaseActivity {

    @BindView(R.id.videoplayer)
    JzvdStd jzvdStd;

    @Override
    public int getLayout() {
        return R.layout.activity_play;
    }

    @Override
    public void initView() {

    }

    @Override
    public void intData() {
        String mVideoUrl="http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b" +
                ".mp4";
        jzvdStd.setUp(mVideoUrl, "饺子闭眼睛" , Jzvd.SCREEN_WINDOW_NORMAL);
//        String mPicUrl="http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";
//        jzvdStd.thumbImageView.setImageURI(Uri.parse(mPicUrl));
        jzvdStd.startVideo();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VideoPlayManeger.startMonitor();//重新发送和设置最后一次点击的时间
        VideoPlayManeger.eliminateEvent();
    }
}
