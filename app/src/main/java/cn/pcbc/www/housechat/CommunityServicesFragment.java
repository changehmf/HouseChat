package cn.pcbc.www.housechat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Name: CommunityServicesFragment
 *
 * @author: HMF
 * Comment: 社区服务板块
 * @date: 2017/11/01
 */

public class CommunityServicesFragment extends BaseFragment {

    @BindView(R.id.community_rv)
    RecyclerView mCommunityRv;


    /**
     * 服务集合类
     */
    List<ServicesSectionEntity> mServices = new ArrayList<>();

    CommunityServicesAdapter servicesAdapter;

    /**
     * 静态工厂方法初始化fragment
     * 然后返回新的fragment到调用者
     */
    public static CommunityServicesFragment newInstance() {
        CommunityServicesFragment servicesFragment = new CommunityServicesFragment();
        //参数携带...待使用
        Bundle args = new Bundle();
        servicesFragment.setArguments(args);
        return servicesFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_community_services;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
        mServices.add(new ServicesSectionEntity(true, "业主"));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_feedback, "反馈建议")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_repair, "保修")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_evaluate, "物业评价")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_developer, "开发商评价")));

        mServices.add(new ServicesSectionEntity(true, "物业"));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_pay, "缴费")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_fix, "维修")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_inform, "通知公告")));

        mServices.add(new ServicesSectionEntity(true, "居家"));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_home_appliances, "家电维修")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_clean, "家政保洁")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_express, "快递")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_decoration, "装修")));
        mServices.add(new ServicesSectionEntity(new ServicesEntity(R.mipmap.service_shop, "小商家")));


        servicesAdapter = new CommunityServicesAdapter(R.layout.item_services, R.layout.head_community_services, mServices);
        mCommunityRv.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mCommunityRv.setAdapter(servicesAdapter);

    }
}
