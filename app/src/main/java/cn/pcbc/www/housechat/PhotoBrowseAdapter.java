package cn.pcbc.www.housechat;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.pcbc.www.base.component.photoview.PhotoView;

/**
 * Name: PhotoBrowseAdapter
 *
 * @author: HMF
 * Comment: 图片浏览Adapter
 * @date: 2017/11/03
 */

public class PhotoBrowseAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public PhotoBrowseAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        PhotoView mPhoto  = helper.getView(R.id.photoview);
        mPhoto.enable();
        Glide.with(mContext).load(item).into(mPhoto);

    }
}
