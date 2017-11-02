package cn.pcbc.www.housechat;

import android.support.annotation.DrawableRes;

/**
 * Name: ServicesEntity
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/11/01
 */

public class ServicesEntity {

    public int img;
    public String name;

    public ServicesEntity(@DrawableRes int img, String name) {
        this.img = img;
        this.name = name;
    }
}
