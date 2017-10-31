package cn.pcbc.www.housechat;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.pcbc.www.base.component.banner.RecyclerViewBanner;

/**
 * Name: BannerAdapter
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/10/30
 */

public class BannerAdapter extends BaseMultiItemQuickAdapter<BannerEntity, BaseViewHolder> {

    RecyclerViewBanner.OnSwitchRvBannerListener onSwitchRvBannerListener;

    public BannerAdapter(List<BannerEntity> data) {
        super(data);
        addItemType(0, R.layout.item_weather);
        addItemType(1, R.layout.item_banner_image);
    }



    @Override
    protected void convert(BaseViewHolder helper, BannerEntity item) {

        int mPosition  = helper.getAdapterPosition() % mData.size();
        BannerEntity bannerEntity = mData.get(mPosition);

        switch (mData.get(mPosition).getItemType()) {
            case 0:
            //自定义视图

                break;

            case 1:
                Glide.with(mContext).load(bannerEntity.url).into((ImageView) helper.getView(R.id.banner_iv));
                break;

            default:
                break;
        }
    }

//    @Override
//    public int getItemCount() {
//        int i = mData == null ? 0 : mData.size() <= 2 ? mData.size() : Integer.MAX_VALUE;
//        Log.d("TAG","getItemCount:"+i);
//        return i;
//    }
}
