package com.kttz.padc_sfc_news.events;

import com.kttz.padc_sfc_news.data.vo.NewsVO;

import java.util.List;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public class RestApiEvents {
    public static class EmptyResposeEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }
    public static class NewsDataLoadedevent{
        private int loadedPageIndex;
        private List<NewsVO> loadedNews;

        public NewsDataLoadedevent(int loadedPageIndex,List<NewsVO> loadedNews){
            this.loadedPageIndex= loadedPageIndex;
            this.loadedNews=loadedNews;
        }
        public int getLoadedPageIndex(){
            return loadedPageIndex;
        }
        public List<NewsVO> getLoadedNews(){
            return loadedNews;
        }
    }
}

