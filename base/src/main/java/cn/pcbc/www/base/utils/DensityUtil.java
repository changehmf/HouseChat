package cn.pcbc.www.base.utils;

import android.content.Context;

/**
 * Name:DensityUtil
 *
 * @author
 * @date 2017/10/26
 */

public class DensityUtil {

    public DensityUtil() {
        throw new AssertionError();
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (dpValue * scale + 0.5f);
    }
}
