package cn.pcbc.www.housechat;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Name: ScaleRecyclerView
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/11/03
 */

public class ScaleRecyclerView extends RecyclerView {

    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_MOVING = 1;
    public static final int STATUS_REBACK = 2;
    public static final String TAG = "ScaleRecyclerView";

    //最多可缩小比例
    public static final float MIN_SCALE_WEIGHT = 0.25f;
    public static final int REBACK_DURATION = 300;//ms
    public static final int DRAG_GAP_PX = 50;

    private int currentStatus = STATUS_NORMAL;

    float mDownX;
    float mDownY;

    public ScaleRecyclerView(Context context) {
        super(context);
    }

    public ScaleRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



}
