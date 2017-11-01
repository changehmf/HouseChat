package cn.pcbc.www.housechat;


import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Name: CommunityServicesAdapter
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/11/01
 */

public class CommunityServicesAdapter extends BaseSectionQuickAdapter<ServicesSectionEntity,BaseViewHolder> {

    public CommunityServicesAdapter(int layoutResId, int sectionHeadResId, List<ServicesSectionEntity> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ServicesSectionEntity item) {
        ServicesEntity t = item.t;
        helper.setText(R.id.column_tv,t.name);


    }

    @Override
    protected void convertHead(BaseViewHolder helper, ServicesSectionEntity item) {
        helper.setText(R.id.services_tv,item.header);
    }
}
