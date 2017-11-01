package cn.pcbc.www.housechat;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import cn.pcbc.www.base.utils.StatusBarUtils;

/**
 * Name:MainActivity
 *
 * @author HMF
 * @date 2017/10/26
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private static final String TAB_TOPIC_FRAGMENT = "home";
    private static final String TAB_SERVICES_FRAGMENT = "setvices";
    private static final String TAB_NEIGHBOR_FRAGMENT = "neighbor";
    private static final String TAB_PROFILE_FRAGMENT = "profile";
    /**
     *  恢复标识
     */
    private static final String STATE_INDEX = "index";

    /**
     * 底部导航栏
     */
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    /**
     * Fragment容器
     */
    @BindView(R.id.main_container)
    FrameLayout mMainContainer;

    /**
     * 底部栏目
     */
    private String[] mBottomText = {"生活", "社区", "邻里", "我的"};
    /**
     * 底部栏目图标
     */
    private int[] mBottomImgs = {R.mipmap.main_life, R.mipmap.main_community, R.mipmap.main_neighbor, R.mipmap.main_me};

    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    /**
     * 话题Fragment
     */
    private HomeFragment mHomeFragment;
    /**
     * 服务Fragment
     */
    private CommunityServicesFragment mCommunityFragment;
    /**
     * 恢复标记
     */
    private String mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initStatusbar();
        initBottomNavigation();
        //如果是从崩溃中恢复，还需要加载之前的缓存
        if (savedInstanceState != null) {
            restoreFragment(savedInstanceState);
        } else {
            switchToFragment(TAB_TOPIC_FRAGMENT);
        }

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    /**
     * 初始化一些资源
     */
    private void initView() {
        mFragmentManager = getSupportFragmentManager();
    }

    /**
     * 初始化状态栏
     */
    private void initStatusbar() {
        StatusBarUtils.from(this)
                .setTransparentStatusbar(true)
                .setStatusBarColor(getResources().getColor(R.color.status_bg))
                .setLightStatusBar(true)
                .process(this);
    }


    /**
     * 初始化底部导航栏
     */
    private void initBottomNavigation() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.addItem(new BottomNavigationItem(mBottomImgs[0], mBottomText[0])).setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(mBottomImgs[1], mBottomText[1])).setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(mBottomImgs[2], mBottomText[2])).setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(mBottomImgs[3], mBottomText[3])).setActiveColor(R.color.colorPrimary)
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
    }

    //bottomnaviagtion 被选中
    @Override
    public void onTabSelected(int position) {
        switchToFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


    /**
     * Activity被销毁的时候，要记录当前处于哪个页面
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_INDEX, mCurrentIndex);
        super.onSaveInstanceState(outState);
    }


    /**
     * 如果fragment因为内存不够或者其他原因被销毁掉，在这个方法中执行恢复操作
     */
    private void restoreFragment(Bundle savedInstanceState) {
        mCurrentIndex = savedInstanceState.getString(STATE_INDEX);
        mHomeFragment = (HomeFragment) mFragmentManager.findFragmentByTag(TAB_TOPIC_FRAGMENT);
        mCommunityFragment = (CommunityServicesFragment) mFragmentManager.findFragmentByTag(TAB_SERVICES_FRAGMENT);
        switchToFragment(mCurrentIndex);
    }

    /**
     * 显示Fragment
     *
     * @param tabName
     */
//    private void setTabFragment(String tabName) {
//        switchToFragment(tabName);
//    }

    /**
     * 切换fragment
     *
     * @param index
     */
    private void switchToFragment(int index) {
        //可控制底部动态隐藏显示
        mTransaction = mFragmentManager.beginTransaction();
        hideAllFragments(mTransaction);
        switch (index) {
            case 0:
                showHomeFragment();
                mCurrentIndex = TAB_TOPIC_FRAGMENT;
                break;
            case 1:
                showCommunityFragment();
                mCurrentIndex = TAB_SERVICES_FRAGMENT;
                break;
            case 2:
                mCurrentIndex = TAB_NEIGHBOR_FRAGMENT;
                break;
            case 3:
                mCurrentIndex = TAB_PROFILE_FRAGMENT;
                break;
            default:
                break;
        }
        mTransaction.commit();
    }

    /**
     * 切换fragment
     *
     * @param index
     */
    private void switchToFragment(String index) {
        mTransaction = mFragmentManager.beginTransaction();
        hideAllFragments(mTransaction);
        switch (index) {
            case TAB_TOPIC_FRAGMENT:
                showHomeFragment();
                break;
            case TAB_SERVICES_FRAGMENT:
                showCommunityFragment();
                break;
            case TAB_NEIGHBOR_FRAGMENT:
                break;
            case TAB_PROFILE_FRAGMENT:
                break;
            default:
                break;
        }
        mCurrentIndex = index;
        mTransaction.commit();
    }

    /**
     * 切换到首页模块
     */
    private void showHomeFragment() {
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstance();
            mTransaction.add(R.id.main_container, mHomeFragment, TAB_TOPIC_FRAGMENT);
        } else {
            mTransaction.show(mHomeFragment);
        }
    }


    /**
     * 切换到服务模块
     */
    private void showCommunityFragment() {
        if (mCommunityFragment == null) {
            mCommunityFragment = CommunityServicesFragment.newInstance();
            mTransaction.add(R.id.main_container, mCommunityFragment, TAB_TOPIC_FRAGMENT);
        } else {
            mTransaction.show(mCommunityFragment);
        }
    }


    /**
     * 隐藏所有的fragment
     *
     * @param transaction
     */
    private void hideAllFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mCommunityFragment != null) {
            transaction.hide(mCommunityFragment);
        }
    }

}
