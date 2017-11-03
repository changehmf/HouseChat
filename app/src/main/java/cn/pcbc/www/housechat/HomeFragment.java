package cn.pcbc.www.housechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import butterknife.BindView;

/**
 * Name: HomeFragment
 *
 * @author: HMF
 * Comment: 首页Fragment
 * @date: 2017/11/01
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tool_chat)
    ImageView mToolChat;

    @BindView(R.id.tool_search)
    ImageView mToolSearch;

    @BindView(R.id.sliding_tab)
    SlidingTabLayout mSlidingTab;

    @BindView(R.id.home_vp)
    ViewPager mHomeVp;

    /**
     * 导航标题
     */
    String[] mTitles = {"话题","圈子"};

    ArrayList<Fragment> mFragments = new ArrayList<>();


    /**
     * 静态工厂方初始化fragment
     * 然后返回新的fragment到调用者
     */
    public static HomeFragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

        mFragments.add(TopicFragment.newInstance());
        mFragments.add(CommunityServicesFragment.newInstance());

        mSlidingTab.setViewPager(mHomeVp,mTitles,getActivity(),mFragments);

    }


}
