package cn.pcbc.www.housechat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Name: ComToolBar
 *
 * @author: HMF
 * Comment: 通用导航栏
 * @date: 2017/11/01
 */

public class ComToolBar extends RelativeLayout {

    private Button toolbarLeftBtn;
    private Button toolbarrRightBtn;
    private TextView toolbarTitle;

    public ComToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.com_tool_bar, this, true);
        toolbarLeftBtn = findViewById(R.id.toolbar_left_btn);
        toolbarrRightBtn = findViewById(R.id.toolbar_right_btn);
        toolbarTitle = findViewById(R.id.toolbar_title_tv);

        int defTextColor = context.getResources().getColor(R.color.font666);


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ComToolBar);
        if(attributes != null){
            //处理titleBar背景色
            int titleBarBackGround = attributes.getColor(R.styleable.ComToolBar_title_background_color, Color.WHITE);
            setBackgroundColor(titleBarBackGround);

            //获取是否要显示左边按钮
            boolean leftButtonVisible = attributes.getBoolean(R.styleable.ComToolBar_left_button_visible, true);
            if (leftButtonVisible) {
                toolbarLeftBtn.setVisibility(View.VISIBLE);
            } else {
                toolbarLeftBtn.setVisibility(View.INVISIBLE);
            }

            String mLeftTxt = attributes.getString(R.styleable.ComToolBar_left_button_text);
            if(!TextUtils.isEmpty(mLeftTxt)){
                toolbarLeftBtn.setText(mLeftTxt);
                int color = attributes.getColor(R.styleable.ComToolBar_left_button_text_color, defTextColor);
                toolbarLeftBtn.setTextColor(color);
            }else{
                //设置左边图片icon 这里是二选一 要么只能是文字 要么只能是图片
                int leftButtonDrawable = attributes.getResourceId(R.styleable.ComToolBar_left_button_drawable, R.mipmap.toolbar_back_icon);
                if (leftButtonDrawable != -1) {
                    toolbarLeftBtn.setBackgroundResource(leftButtonDrawable);
                }
            }


            //处理标题
            //先获取标题是否要显示图片icon
            int titleTextDrawable = attributes.getResourceId(R.styleable.ComToolBar_title_text_drawable, -1);
            if (titleTextDrawable != -1) {
                toolbarTitle.setBackgroundResource(titleTextDrawable);
            } else {
                //如果不是图片标题 则获取文字标题
                String titleText = attributes.getString(R.styleable.ComToolBar_title_text);
                if (!TextUtils.isEmpty(titleText)) {
                    toolbarTitle.setText(titleText);
                }
                //获取标题显示颜色
                int titleTextColor = attributes.getColor(R.styleable.ComToolBar_title_text_color, defTextColor);
                toolbarTitle.setTextColor(titleTextColor);
            }


            //获取是否要显示右边按钮
            boolean rightButtonVisible = attributes.getBoolean(R.styleable.ComToolBar_right_button_visible, true);
            if (rightButtonVisible) {
                toolbarrRightBtn.setVisibility(View.VISIBLE);
            } else {
                toolbarrRightBtn.setVisibility(View.INVISIBLE);
            }
            //设置右边按钮的文字
            String rightButtonText = attributes.getString(R.styleable.ComToolBar_right_button_text);
            if (!TextUtils.isEmpty(rightButtonText)) {
                toolbarrRightBtn.setText(rightButtonText);
                //设置右边按钮文字颜色
                int rightButtonTextColor = attributes.getColor(R.styleable.ComToolBar_right_button_text_color, defTextColor);
                toolbarrRightBtn.setTextColor(rightButtonTextColor);
            } else {
                //设置右边图片icon 这里是二选一 要么只能是文字 要么只能是图片
                int rightButtonDrawable = attributes.getResourceId(R.styleable.ComToolBar_right_button_drawable, -1);
                if (rightButtonDrawable != -1) {
                    toolbarrRightBtn.setBackgroundResource(rightButtonDrawable);
                }
            }
            attributes.recycle();
        }

    }


    public Button getToolbarLeftBtn() {
        return toolbarLeftBtn;
    }

    public Button getToolbarrRightBtn() {
        return toolbarrRightBtn;
    }

    public TextView getToolbarTitle() {
        return toolbarTitle;
    }
}
