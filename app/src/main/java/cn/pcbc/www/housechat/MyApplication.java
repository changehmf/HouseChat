package cn.pcbc.www.housechat;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Name: MyApplication
 *
 * @author: HMF
 * Comment:
 * @date: 2017/10/26
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        initLib();
        this.initializeInjector();
    }

    /**
     *
     */
    private void initializeInjector() {

    }

    /**
     * 初始化Lib
     */
    private void initLib() {
        JodaTimeAndroid.init(this);
    }
}
