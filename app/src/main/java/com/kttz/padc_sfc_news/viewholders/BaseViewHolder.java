package com.kttz.padc_sfc_news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bingbing on 12/2/2017 AD.
 */

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }
    public abstract void setData(W data);
}
