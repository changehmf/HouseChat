package cn.pcbc.www.housechat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Name: PhotoBrowseActivity1
 *
 * @author: HMF
 * Comment:图片浏览器RecyclerView+photoview实现
 * @date: 2017/11/03
 */

public class PhotoBrowseActivity1 extends BaseActivity {

    public static final String IMGS = "imgs";
    public static final String SELECT_POSITION = "sel_position";

    @BindView(R.id.photo_rv)
    RecyclerView mPhotoRv;
    @BindView(R.id.num_v)
    TextView mNumV;
    @BindView(R.id.more_iv)
    ImageView mMoreIv;

    /**
     * 照片集合
     */
    ArrayList<String> mImgs = new ArrayList<>();
    int mSize;
    int mSelectPosition;
    String mTxt;

    PhotoBrowseAdapter mBrowseAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_photobrowse;
    }

    /**
     * 跳转图片浏览器
     * @param context
     * @param mUrls 图片地址
     */
    public static void startPhotoBrowse(Context context, ArrayList<String> mUrls ,int position){
        Intent intent = new Intent(context,PhotoBrowseActivity1.class);
        intent.putStringArrayListExtra(IMGS,mUrls);
        intent.putExtra(SELECT_POSITION,position);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(getIntent() == null){
            finish();
            return;
        }

        mImgs = getIntent().getStringArrayListExtra(IMGS);
        mSelectPosition = getIntent().getIntExtra(SELECT_POSITION,1);

        if( mImgs.size() == 0 ){
            finish();
        }else{
            mTxt = getString(R.string.photo_num);
            mSize = mImgs.size();
            mNumV.setText(String.format(Locale.CHINA,mTxt,mSelectPosition+1,mSize));

            new LinearSnapHelper().attachToRecyclerView(mPhotoRv);
            mBrowseAdapter = new PhotoBrowseAdapter(R.layout.item_photo_browse,mImgs);
            mPhotoRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            mPhotoRv.setAdapter(mBrowseAdapter);
            //滑动到选中位置
            mPhotoRv.scrollToPosition(mSelectPosition);
            mPhotoRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);

                    //屏幕停止滚动
                    if(newState != RecyclerView.SCROLL_STATE_IDLE){
                        return;
                    }

                    View childAt = recyclerView.getChildAt(0);
                    if(childAt != null){
                        int childPosition = recyclerView.getChildAdapterPosition(childAt);
                        if(mNumV == null || childPosition < 0){
                            return;
                        }

                        mNumV.setText(String.format(Locale.CHINA,mTxt,childPosition+1,mSize));
                    }
                }
            });

        }

    }

    @OnClick(R.id.more_iv)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_iv:
                finish();
                break;

            default:
                break;
        }
    }
}
