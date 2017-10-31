package cn.pcbc.www.housechat;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;

/**
 * Name:MainActivity
 *
 * @author HMF
 * @date 2017/10/26
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

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


    private String[] mBottomText = {"生活", "社区", "邻里", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBottomNavigation();

    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }


    /**
     * 初始化底部导航栏
     */
    private void initBottomNavigation() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.main_life, mBottomText[0])).setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.main_community, mBottomText[1])).setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.main_neighbor, mBottomText[2])).setActiveColor(R.color.colorPrimary)
                .addItem(new BottomNavigationItem(R.mipmap.main_me, mBottomText[3])).setActiveColor(R.color.colorPrimary)
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 1:

                break;

            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }


}
