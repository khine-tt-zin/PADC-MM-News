package com.kttz.padc_sfc_news.data.models;

import com.kttz.padc_sfc_news.data.vo.NewsVO;
import com.kttz.padc_sfc_news.events.RestApiEvents;
import com.kttz.padc_sfc_news.network.MMNewsDataAgentImpl;
import com.kttz.padc_sfc_news.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public class NewsModel {

    private static NewsModel objInstance;
    private List<NewsVO> mNews;
    private int mmNewsPageIndex =1;

    private NewsModel(){
        EventBus.getDefault().register(this);
        mNews= new ArrayList<>();
    }

    public static NewsModel getInstance(){
        if(objInstance == null){
            objInstance=new NewsModel();
        }
        return objInstance;
    }

    public void loadMMNews(){
        MMNewsDataAgentImpl.getInstance().loadMMNews( AppConstants.ACCESS_TOKEN,mmNewsPageIndex);

    }
    @Subscribe
    public void onNewsDataLoaded(RestApiEvents.NewsDataLoadedevent event){
        mNews=event.getLoadedNews();
        mmNewsPageIndex=event.getLoadedPageIndex()+1;

    }
}
