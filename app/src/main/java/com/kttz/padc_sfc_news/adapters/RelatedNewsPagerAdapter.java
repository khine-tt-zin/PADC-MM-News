package com.kttz.padc_sfc_news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.viewholders.RelatedNewsViewHolder;

/**
 * Created by bingbing on 11/23/2017 AD.
 */

public class RelatedNewsPagerAdapter extends RecyclerView.Adapter <RelatedNewsViewHolder>{
    private LayoutInflater mlayoutInflater;


    public RelatedNewsPagerAdapter(Context context) {
        mlayoutInflater=LayoutInflater.from(context);
    }


    @Override
    public RelatedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mlayoutInflater.inflate(R.layout.view_item_related_news, parent, false);
        return new RelatedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RelatedNewsViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 5;
    }
}
