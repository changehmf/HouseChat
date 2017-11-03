package cn.pcbc.www.housechat;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Name: TopicAdapter
 *
 * @author: HMF
 * Comment: 话题Adapter
 * @date: 2017/10/31
 */

public class TopicAdapter extends BaseQuickAdapter<TopicEntity, BaseViewHolder> {

    public TopicAdapter(int layoutResId, @Nullable List<TopicEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicEntity item) {
        //设置名称 地址 评论数 喜欢数
        helper.setText(R.id.profile_name_tv, item.userName)
                .setText(R.id.from_tv, item.address)
                .setText(R.id.favorites_tv, item.favoriteNum+"")
                .setText(R.id.comments_tv, item.commentsNum+"");
        FillContent.setWeiBoTime(mContext, (TextView) helper.getView(R.id.profile_time_tv), item.createdTime);
        Glide.with(mContext).load(item.useravatar).into((ImageView) helper.getView(R.id.profile_iv));
        FillContent.fillWeiBoContent(item.content, mContext, (TextView) helper.getView(R.id.topic_Content));
        FillContent.fillNineImages(item.imgs,(NineGridView) helper.getView(R.id.topic_image));


    }

}
