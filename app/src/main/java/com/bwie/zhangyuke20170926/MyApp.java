package com.bwie.zhangyuke20170926;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import imageloader.bwie.com.imageloaderlibrary.UtilImage;

/**
 * 作者：张玉轲
 * 时间：2017/9/26
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config= UtilImage.getConfiguration(this);

        ImageLoader.getInstance().init(config);
    }
}
