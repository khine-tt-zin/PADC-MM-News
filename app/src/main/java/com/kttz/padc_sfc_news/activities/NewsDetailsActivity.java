package com.kttz.padc_sfc_news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.adapters.NewsImagesPagerAdapter;
import com.kttz.padc_sfc_news.adapters.RelatedNewsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bingbing on 11/11/2017 AD.
 */

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    @BindView(R.id.rv_related_news)
    RecyclerView rvRelatedNews;
    public  static Intent newIntent(Context context){
        Intent intent=new Intent(context,NewsDetailsActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//1.create loat
        setContentView(R.layout.activity_news_details);//2.conect loat lite tl xml nae
        ButterKnife.bind(this,this);

        NewsImagesPagerAdapter newsImagesPagerAdapter=new NewsImagesPagerAdapter(getApplicationContext());
        vpNewsDetailsImages.setAdapter(newsImagesPagerAdapter);

        rvRelatedNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.HORIZONTAL, false));
        RelatedNewsPagerAdapter relatedNewsPagerAdapter = new RelatedNewsPagerAdapter(getApplicationContext());
        rvRelatedNews.setAdapter(relatedNewsPagerAdapter);
    }
}
