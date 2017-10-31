package cn.pcbc.www.housechat;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Name: BannerEntity
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/10/30
 */

class BannerEntity implements MultiItemEntity{

    BannerType bannerType;
    String url;
    String title;

    public BannerEntity(BannerType bannerType, String url, String title) {
        this.bannerType = bannerType;
        this.url = url;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return bannerType==BannerType.VIEW? 0:1;
    }

    enum BannerType{
        VIEW,
        IMAGE
    }
}
