package cn.pcbc.www.housechat;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.pcbc.www.base.component.banner.RecyclerBanner;


/**
 * Name: TopicFragment
 *
 * @author: HMF
 * Comment: 生活首页-话题
 * @date: 2017/10/30
 */

public class TopicFragment extends BaseFragment {

    @BindView(R.id.topic_banner)
    RecyclerBanner mTopicBanner;

    @BindView(R.id.topic_column)
    RecyclerView mTopicColumnRv;

    @BindView(R.id.topic_content)
    RecyclerView mTopicContentRv;

    @Override
    protected int setLayout() {
        return R.layout.fragment_main_life;
    }

    /**
     * 栏目图片
     */
    int[] columnImgs = {R.mipmap.weather_icon, R.mipmap.society_icon, R.mipmap.office_icon, R.mipmap.chat_icon};
    /**
     * 栏目名称
     */
    String[] columnTxts = {"天气出行", "设置杂谈", "官方活动", "休闲灌水"};

    List<BannerEntity> mBannerViews = new ArrayList<>();
    List<ColumnEntity> mColumnEntities = new ArrayList<>();
    List<TopicEntity> mTopics = new ArrayList<>();

    ColumnAdapter columnAdapter;

    @Override
    protected void initView(View view) {

        initBanner();

        initColumn();

        initTopic();

    }


    /**
     * initBnner
     */
    private void initBanner() {
        //天气视图
        mBannerViews.add(new BannerEntity(BannerEntity.BannerType.VIEW, "https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=banner&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=1705520648,1030222030&os=599486749,2441162306&simid=0,0&pn=6&rn=1&di=7860105000&ln=1997&fr=&fmq=1509412026505_R&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F019c5558590d6ba8012060c8b24397.jpg&rpstart=0&rpnum=0&adpicid=0", ""));
        mBannerViews.add(new BannerEntity(BannerEntity.BannerType.IMAGE, "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1068094927,2287376718&fm=27&gp=0.jpg", ""));
        mBannerViews.add(new BannerEntity(BannerEntity.BannerType.IMAGE, "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1068094927,2287376718&fm=27&gp=0.jpg", ""));

        BannerAdapter bannerAdapter = new BannerAdapter(mBannerViews);
        mTopicBanner.setPlaying(false);
        mTopicBanner.setAdapet(bannerAdapter);


    }

    /**
     * 初始化栏目
     */
    private void initColumn() {
        mColumnEntities.add(new ColumnEntity(columnImgs[0], columnTxts[0]));
        mColumnEntities.add(new ColumnEntity(columnImgs[1], columnTxts[1]));
        mColumnEntities.add(new ColumnEntity(columnImgs[2], columnTxts[2]));
        mColumnEntities.add(new ColumnEntity(columnImgs[3], columnTxts[3]));
        columnAdapter = new ColumnAdapter(getContext(), R.layout.item_column, mColumnEntities);
        GridLayoutManager horziontalManager = new GridLayoutManager(getContext(), 4);
        mTopicColumnRv.setLayoutManager(horziontalManager);
        mTopicColumnRv.setAdapter(columnAdapter);

    }

    /**
     * 初始化话题栏目
     */
    private void initTopic() {
        TopicEntity topic1 = new TopicEntity();
        topic1.address = "朝阳";
        topic1.content = "#知政#【财政部谈跨境电商新政：不会给消费者带来太大负担】财政部关税司有关负责人坦承，新政客观上会提高消费者总体税负水平。但其指出，在税率设置上暂给予一定优惠，具体而言有升有降。新政有利于电商化解部分成本，对大众消费品价格总体影响有限，不会给消费者带来太大负担。http://t.cn/RqXsr16";
        topic1.commentsNum = 996;
        topic1.createdTime = "2017-10-30 15:35:00";
        topic1.favorited = false;
        topic1.favoriteNum = 125;
        topic1.id = 1;
        topic1.userName = "哈利波特";
        topic1.useravatar = "http://dwz.cn/6LkzOS";

        ArrayList<String> temp = new ArrayList<>();
        temp.add("http://dwz.cn/6LkFoR");
        temp.add("http://dwz.cn/6LkFVj");
        temp.add("http://dwz.cn/6LkGDn");
        temp.add("http://dwz.cn/6LkGNS");
        temp.add("http://dwz.cn/6LkHoA");

        topic1.imgs = new ArrayList<>();
        topic1.imgs.addAll(temp);


        TopicEntity topic2 = new TopicEntity();
        topic2.address = "朝阳";
        topic2.content = "#知政#【财政部谈跨境电商新政：不会给消费者带来太大负担】财政部关税司有关负责人坦承，新政客观上会提高消费者总体税负水平。但其指出，在税率设置上暂给予一定优惠，具体而言有升有降。新政有利于电商化解部分成本，对大众消费品价格总体影响有限，不会给消费者带来太大负担。http://t.cn/RqXsr16";
        topic2.commentsNum = 996;
        topic2.createdTime = "2017-10-30 15:35:00";
        topic2.favorited = false;
        topic2.favoriteNum = 125;
        topic2.id = 1;
        topic2.userName = "哈利波特1";
        topic2.useravatar = "http://dwz.cn/6LkzOS";

        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add("http://dwz.cn/6LkFoR");
        temp2.add("http://dwz.cn/6LkFVj");
        temp2.add("http://dwz.cn/6LkGDn");
        temp2.add("http://dwz.cn/6LkGNS");
        temp2.add("http://dwz.cn/6LkHoA");
        temp2.add("http://dwz.cn/6LkFVj");
        temp2.add("http://dwz.cn/6LkGDn");
        temp2.add("http://dwz.cn/6LkGNS");
        temp2.add("http://dwz.cn/6LkHoA");

        topic2.imgs = new ArrayList<>();
        topic2.imgs.addAll(temp2);


        TopicEntity topic3 = new TopicEntity();
        topic3.address = "朝阳";
        topic3.content = "#知政#【财政部谈跨境电商新政：不会给消费者带来太大负担】财政部关税司有关负责人坦承，新政客观上会提高消费者总体税负水平。但其指出，在税率设置上暂给予一定优惠，具体而言有升有降。新政有利于电商化解部分成本，对大众消费品价格总体影响有限，不会给消费者带来太大负担。http://t.cn/RqXsr16";
        topic3.commentsNum = 996;
        topic3.createdTime = "2017-10-30 15:35:00";
        topic3.favorited = false;
        topic3.favoriteNum = 125;
        topic3.id = 1;
        topic3.userName = "哈利波特2";
        topic3.useravatar = "http://dwz.cn/6LkzOS";

        ArrayList<String> temp3 = new ArrayList<>();
        temp3.add("http://dwz.cn/6LkFoR");


        topic3.imgs = new ArrayList<>();
        topic3.imgs.addAll(temp3);


        mTopics.add(topic1);
        mTopics.add(topic2);
        mTopics.add(topic3);

        TopicAdapter topicAdapter = new TopicAdapter(R.layout.home_topic_original_pictext,mTopics);
        mTopicContentRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mTopicContentRv.setAdapter(topicAdapter);

    }
}
