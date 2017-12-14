package com.kttz.padc_sfc_news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kttz.padc_sfc_news.data.vo.NewsVO;
import com.kttz.padc_sfc_news.delegates.NewsItemDelegate;
import com.kttz.padc_sfc_news.events.TapNewEvent;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by bingbing on 11/4/2017 AD.
 */

public class NewsViewHolder extends BaseViewHolder<NewsVO> {
    private NewsItemDelegate mDelegate;

    public NewsViewHolder(View itemView, NewsItemDelegate newsItemDelegate) {
        super(itemView);
        mDelegate = newsItemDelegate;
;
    }

    @Override
    public void setData(NewsVO data) {

    }

    @Override
    public void onClick(View view) {
        //mDelegate.onTapNews();
        EventBus.getDefault().post(new TapNewEvent()    );
    }
}
