package cn.pcbc.www.housechat;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Name: ColumnAdapter
 *
 * @author: HMF
 * Comment: 话题栏目Adapter
 * @date: 2017/10/30
 */

public class ColumnAdapter extends BaseQuickAdapter<ColumnEntity,BaseViewHolder> {

    private Context context;

    public ColumnAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<ColumnEntity> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ColumnEntity item) {
        helper.setText(R.id.column_tv,item.name);

        Glide.with(context).load(item.mImage).into((ImageView) helper.getView(R.id.column_iv));
    }
}
