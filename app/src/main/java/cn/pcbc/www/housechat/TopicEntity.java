package cn.pcbc.www.housechat;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Name: TopicEntity
 *
 * @author: HMF
 * Comment: 话题动态实体类
 * @date: 2017/10/31
 */

public class TopicEntity implements Parcelable {
    /**
     * 话题创建时间
     */
    public String createdTime;

    /**
     * 话题id
     */
    public int id;

    /**
     * 话题发布地址
     */
    public String address;

    /**
     * 是否被收藏 0未被收藏，1被收藏
     */
    public boolean favorited;

    /**
     * 话题内容
     */
    public String content;

    /**
     * 收藏数量
     */
    public int  favoriteNum;

    /**
     * 回复数量
     */
    public int commentsNum;

    /**
     * 用户名称
     */
    public String userName;

    /**
     * 用户头像
     */
    public String useravatar;

    /**
     * 用户发布图片集合 最多9张
     */
    public ArrayList<String> imgs;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.createdTime);
        dest.writeInt(this.id);
        dest.writeString(this.address);
        dest.writeByte(this.favorited ? (byte) 1 : (byte) 0);
        dest.writeString(this.content);
        dest.writeInt(this.favoriteNum);
        dest.writeInt(this.commentsNum);
        dest.writeString(this.userName);
        dest.writeString(this.useravatar);
        dest.writeStringList(this.imgs);
    }

    public TopicEntity() {
    }

    protected TopicEntity(Parcel in) {
        this.createdTime = in.readString();
        this.id = in.readInt();
        this.address = in.readString();
        this.favorited = in.readByte() != 0;
        this.content = in.readString();
        this.favoriteNum = in.readInt();
        this.commentsNum = in.readInt();
        this.userName = in.readString();
        this.useravatar = in.readString();
        this.imgs = in.createStringArrayList();
    }

    public static final Creator<TopicEntity> CREATOR = new Creator<TopicEntity>() {
        @Override
        public TopicEntity createFromParcel(Parcel source) {
            return new TopicEntity(source);
        }

        @Override
        public TopicEntity[] newArray(int size) {
            return new TopicEntity[size];
        }
    };
}
