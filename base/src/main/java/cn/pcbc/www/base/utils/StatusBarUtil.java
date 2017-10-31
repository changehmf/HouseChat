package cn.pcbc.www.base.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowManager;

/**
 * Name:StatusBarUtil
 *
 * @author
 * @date 2017/10/26
 */

public class StatusBarUtil {

    private final static int SHADOW_COLOR = 0x80000000;

    /**
     * 设置状态栏半透明
     *
     * @param activity
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void setTranslucent(Activity activity) {
        setColor(activity, SHADOW_COLOR);
    }

    /**
     * 设置状态栏为透明
     *
     * @param activity
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void setTransparent(Activity activity) {
        setColor(activity, Color.TRANSPARENT);
    }

    /**
     * 设置状态栏颜色
     *
     * @param activity
     * @param color
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void setColor(Activity activity, int color) {
        View decorView = activity.getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(option);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //添加flag来设置状态栏颜色
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            activity.getWindow().setStatusBarColor(color);
            //若有虚拟按键
            if (NavigationBarUtil.hasNavigationBar(activity)) {
                //设置虚拟按键颜色
                activity.getWindow().setNavigationBarColor(color);
            }
        } else {
            //处理4.4
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 设置沉浸式状态栏
     * 在 onWindowFocusChanged() 中调用
     *
     * @param activity
     * @param hasFocus
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void setImmersive(Activity activity, boolean hasFocus) {
        if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION//
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //添加flag来设置状态栏颜色
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //设置状态栏颜色
                activity.getWindow().setStatusBarColor(SHADOW_COLOR);
                //若有虚拟按键
                if (NavigationBarUtil.hasNavigationBar(activity)) {
                    //设置虚拟按键颜色
                    activity.getWindow().setNavigationBarColor(SHADOW_COLOR);
                }
            } else {
                //处理4.4
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }
    }

    /**
     * 获得状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
