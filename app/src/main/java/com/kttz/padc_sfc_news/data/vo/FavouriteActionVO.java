package com.kttz.padc_sfc_news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public class FavouriteActionVO {
    @SerializedName("favourite-id")
    private String favouriteId;

    @SerializedName("favourite-date")
    private String favouriteDate;

    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String getFavouriteId() {
        return favouriteId;
    }

    public String getFavouriteDate() {
        return favouriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
