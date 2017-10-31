package cn.pcbc.www.housechat;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Name: BaseFragment
 *
 * @author: HMF
 * Comment: Fragment基类
 * @date: 2017/10/30
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder mBinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), null, false);
        mBinder = ButterKnife.bind(this,view);
        initView(view);
        return view;
    }

    /**
     * 设置布局
     * @return 布局ID
     */
    protected abstract @LayoutRes
    int setLayout();

    /**
     * 初始化布局
     * @param view
     */
    protected abstract void initView(View view);


    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinder.unbind();
    }
}
