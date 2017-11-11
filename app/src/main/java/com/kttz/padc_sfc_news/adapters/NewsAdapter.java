package com.kttz.padc_sfc_news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.viewholders.NewsViewHolder;

/**
 * Created by bingbing on 11/4/2017 AD.
 */

public class NewsAdapter extends RecyclerView.Adapter <NewsViewHolder>{
    private Context mContext;
    private LayoutInflater mlayoutInflater;

    public NewsAdapter(Context context){
        mlayoutInflater=LayoutInflater.from(context);
        mContext=context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newsItemView = mlayoutInflater.inflate(R.layout.view_item_news,parent,false);
        return new  NewsViewHolder(newsItemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
