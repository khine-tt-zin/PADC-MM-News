package com.kttz.padc_sfc_news.network;

import com.google.gson.Gson;
import com.kttz.padc_sfc_news.data.models.NewsModel;
import com.kttz.padc_sfc_news.events.RestApiEvents;
import com.kttz.padc_sfc_news.network.response.GetsNewResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public class MMNewsDataAgentImpl implements MMNewsDataAgent {
    private MMNewsAPI theAPI;


private static MMNewsDataAgentImpl objInstance;

private MMNewsDataAgentImpl(){
    OkHttpClient okHttpClient= new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .build();
    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .client(okHttpClient)
            .build();
    theAPI = retrofit.create(MMNewsAPI.class);

}

    public static MMNewsDataAgentImpl getInstance(){
        if(objInstance == null){
            objInstance=new MMNewsDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void loadMMNews(String accessToken, int pageNo) {
        Call<GetsNewResponse> loadMMNewsCall= theAPI.loadMMNews(pageNo,accessToken);
        loadMMNewsCall.enqueue(new Callback<GetsNewResponse>() {
            @Override
            public void onResponse(Call<GetsNewResponse> call, Response<GetsNewResponse> response) {
                GetsNewResponse getsNewResponse=response.body();
                if(getsNewResponse != null & getsNewResponse.getNewsList().size()>0){
                    RestApiEvents.NewsDataLoadedevent event= new RestApiEvents.NewsDataLoadedevent(getsNewResponse.getPageNo(),getsNewResponse.getNewsList());
                    EventBus.getDefault().post(event);

                }
                else {
                    RestApiEvents.ErrorInvokingAPIEvent errorInvokingAPIEvent=new RestApiEvents.ErrorInvokingAPIEvent("No data could be loaded for now");
                    EventBus.getDefault().post(errorInvokingAPIEvent);
                }

            }

            @Override
            public void onFailure(Call<GetsNewResponse> call, Throwable t) {
                RestApiEvents.ErrorInvokingAPIEvent errorInvokingAPIEvent=new RestApiEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorInvokingAPIEvent);
            }
        });
    }
}
