package cn.pcbc.www.housechat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

import cn.pcbc.www.base.component.NineGridView.NineGridLayout;
import cn.pcbc.www.base.component.NineGridView.RatioImageView;
import cn.pcbc.www.base.utils.LogUtil;

/**
 * Name: NineGridView
 *
 * @author: HMF
 * Comment: 9宫格视图
 * @date: 2017/11/02
 */

public class NineGridView extends NineGridLayout {


    public NineGridView(Context context) {
        super(context);
    }

    public NineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean displayOneImage(final RatioImageView imageView, String url, final int parentWidth) {
        //加载单张图片
        // TODO: 2017/11/2  未处理大图 长图 gif 逻辑
        Glide.with(mContext).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                double w = resource.getWidth();
                double h = resource.getHeight();

                int newW = 0;
                int newH = 0;

                //宽高比例
                double imgRatio = h / w;
                LogUtil.d("比率："+imgRatio);

                //图片宽 小于 屏幕宽度
                if (w < parentWidth) {
                    newW = (int) w;
                    newH = (int) h;
                }else{
                    newW = parentWidth;
                    newH = (int) (parentWidth*imgRatio);
                    //限制图片最大高度
                    newH = newH > parentWidth*2/3 ? parentWidth*2/3 :newH;
                }

                if(newW >0 && newH >0){
                    setOneImageLayoutParams(imageView,newW,newH);
                    Bitmap result = Bitmap.createScaledBitmap(resource, newW, newH, false);

                    if(resource != null){
                        resource.recycle();
                    }

                    imageView.setImageBitmap(result);
                }
            }
        });

        return false;

    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        Glide.with(mContext).load(url).into(imageView);
    }

    @Override
    protected void onClickImage(int position, String url, ArrayList<String> urlList,View view) {
           PhotoBrowseActivity.startWithElement((Activity) mContext,urlList,position,view);
//           PhotoBrowseActivity1.startPhotoBrowse(mContext,urlList,position);
    }
}
