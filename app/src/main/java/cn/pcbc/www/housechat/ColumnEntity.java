package cn.pcbc.www.housechat;

import android.support.annotation.DrawableRes;

/**
 * Name: ColumnEntity
 *
 * @author: HMF
 * Comment: 话题栏目
 * @date: 2017/10/30
 */

public class ColumnEntity {

    public  @DrawableRes int mImage;
    public String name;

    public ColumnEntity(int mImage, String name) {
        this.mImage = mImage;
        this.name = name;
    }


}
