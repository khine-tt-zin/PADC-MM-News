package com.kttz.padc_sfc_news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.data.vo.NewsVO;
import com.kttz.padc_sfc_news.delegates.NewsItemDelegate;
import com.kttz.padc_sfc_news.viewholders.NewsViewHolder;

/**
 * Created by bingbing on 11/4/2017 AD.
 */

public class NewsAdapter extends BaseRecyclerAdapter<NewsViewHolder,NewsVO>{


    private NewsItemDelegate mnewsItemDelegate;
private LayoutInflater mlayoutInflater;
    public NewsAdapter(Context context,NewsItemDelegate newsItemDelegate){
        super(context);
        mnewsItemDelegate=newsItemDelegate;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newsItemView = mlayoutInflater.inflate(R.layout.view_item_news,parent,false);
        return new  NewsViewHolder(newsItemView,mnewsItemDelegate);
    }

}
