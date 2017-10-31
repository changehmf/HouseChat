package cn.pcbc.www.housechat;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.swipebackfragment.SwipeBackActivity;

/**
 * Name: BaseActivity
 *
 * @author: HMF
 * Comment:
 * @date: 2017/10/30
 */

public abstract class BaseActivity extends SwipeBackActivity {

    private Unbinder mBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        mBinder = ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinder.unbind();
    }

    /**
     * 设置Activity布局
     */
    protected  abstract @LayoutRes int setLayout();
}
