package com.kttz.padc_sfc_news.network;


import com.kttz.padc_sfc_news.network.response.GetsNewResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public interface MMNewsAPI {

    @FormUrlEncoded
    @POST("v1/getMMNews.php/")
    Call<GetsNewResponse> loadMMNews(@Field("page") int pageIndex, @Field("access_token") String accessToken);

}
