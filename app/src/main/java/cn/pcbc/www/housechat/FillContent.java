package cn.pcbc.www.housechat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.pcbc.www.base.utils.DateUtils;
import cn.pcbc.www.base.utils.TimeUtils;
import cn.pcbc.www.housechat.topicontent.WeiBoContentTextUtil;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Name: FillContent
 *
 * @author: HMF
 * Comment: //TODO
 * @date: 2017/10/31
 */

public class FillContent {

    public static void setWeiBoTime(Context context, TextView textView, String created_at) {
        Date data = DateUtils.parseDate(created_at, DateUtils.yyyyMMddHHmmss);
        TimeUtils timeUtils = TimeUtils.instance(context);
        textView.setText(timeUtils.buildTimeString(data.getTime()) + "   ");
    }


    /**
     * 填充原创微博文字内容
     */
    public static void fillWeiBoContent(String text, Context context, TextView weibo_content) {
        weibo_content.setText(WeiBoContentTextUtil.getWeiBoContent(text, context, weibo_content));
    }


    public static void fillImageList(final Context context, final ArrayList<String> urllist, final int position ,final SubsamplingScaleImageView longImg, final ImageView norImg, final GifImageView gifImg, final ImageView imageLabel) {


            Glide.with(context).load(urllist.get(position)).into(norImg);


//        longImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ImageDetailsActivity.class);
//                intent.putExtra("imagelist_url", status.origin_pic_urls);
//                intent.putExtra("image_position", position);
//                context.startActivity(intent);
//            }
//        });
//        gifImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ImageDetailsActivity.class);
//                intent.putExtra("imagelist_url", status.bmiddle_pic_urls);
//                intent.putExtra("image_position", position);
//                context.startActivity(intent);
//            }
//        });
//
//        norImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ImageDetailsActivity.class);
//                intent.putExtra("imagelist_url", status.origin_pic_urls);
//                intent.putExtra("image_position", position);
//                context.startActivity(intent);
//            }
//        });
        //setOnLongClickListener(longImg, gifImg, norImg, context, status, position);
    }

    private static void displayLongPic(File file, Bitmap bitmap, SubsamplingScaleImageView longImg, ImageView imageLable) {
        imageLable.setVisibility(View.VISIBLE);
        imageLable.setImageResource(R.drawable.timeline_image_longimage);
        longImg.setZoomEnabled(false);
        longImg.setPanEnabled(false);
        longImg.setQuickScaleEnabled(false);

        longImg.setImage(ImageSource.uri(file.getAbsolutePath()));

    }

    public static void displayNorImg(File file, Bitmap bitmap, ImageView norImg, ImageView imageLable) {
        imageLable.setVisibility(View.GONE);
        norImg.setImageBitmap(bitmap);
        norImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public static void displayGif(File file, GifImageView gifImageView, ImageView imageLable) {
        imageLable.setVisibility(View.VISIBLE);
        imageLable.setImageResource(R.drawable.timeline_image_gif);
        try {
            GifDrawable gifDrawable = new GifDrawable(file);
            gifImageView.setImageDrawable(gifDrawable);
        } catch (IOException e) {
            Log.e("wenming", e.getMessage());
            e.printStackTrace();
        }
    }

//    public static void fillWeiBoImgList(ArrayList<String> imageDatas, Context context, RecyclerView recyclerview) {
//        if (imageDatas == null || imageDatas.size() == 0) {
//            recyclerview.setVisibility(View.GONE);
//            return;
//        }
//        if (recyclerview.getVisibility() == View.GONE) {
//            recyclerview.setVisibility(View.VISIBLE);
//        }
//        GridLayoutManager gridLayoutManager = initGridLayoutManager(imageDatas, context);
//        ImageAdapter imageAdapter = new ImageAdapter(imageDatas, context);
//        recyclerview.setHasFixedSize(true);
//        recyclerview.setAdapter(imageAdapter);
//        recyclerview.setLayoutManager(gridLayoutManager);
//        imageAdapter.setData(imageDatas);
//        imageAdapter.notifyDataSetChanged();
//    }

    /**
     * 填充9宫格图片 未考虑gif 长图 图片下标
     * @param imageDatas
     * @param nineGridView
     */
    public static void fillNineImages(List<String> imageDatas, NineGridView nineGridView){

        if(imageDatas == null || imageDatas.size() == 0){
            nineGridView.setVisibility(View.GONE);
            return;
        }

        if(nineGridView.getVisibility() == View.GONE){
            nineGridView.setVisibility(View.VISIBLE);
        }

        nineGridView.setIsShowAll(false);
        nineGridView.setUrlList(imageDatas);

    }


    /**
     * 根据图片数量，初始化GridLayoutManager，并且设置列数，
     * 当图片 = 1 的时候，显示1列
     * 当图片<=4张的时候，显示2列
     * 当图片>4 张的时候，显示3列
     *
     * @return
     */
    private static GridLayoutManager initGridLayoutManager(ArrayList<String> imageDatas, Context context) {
        GridLayoutManager gridLayoutManager;
        if (imageDatas != null) {
            switch (imageDatas.size()) {
                case 1:
                    gridLayoutManager = new GridLayoutManager(context, 1);
                    break;
                case 2:
                    gridLayoutManager = new GridLayoutManager(context, 2);
                    break;
                case 3:
                    gridLayoutManager = new GridLayoutManager(context, 3);
                    break;
                case 4:
                    gridLayoutManager = new GridLayoutManager(context, 2);
                    break;
                default:
                    gridLayoutManager = new GridLayoutManager(context, 3);
                    break;
            }
        } else {
            gridLayoutManager = new GridLayoutManager(context, 3);
        }
        return gridLayoutManager;
    }
}
