package com.kttz.padc_sfc_news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kttz.padc_sfc_news.R;

/**
 * Created by bingbing on 11/11/2017 AD.
 */

public class NewsImagesPagerAdapter extends PagerAdapter {
    private LayoutInflater mlayoutInflater;

    public NewsImagesPagerAdapter(Context context){
        super();
        mlayoutInflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView=mlayoutInflater.inflate(R.layout.view_item_news_details_image,container,false);
        container.addView(itemView);
        return  itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
