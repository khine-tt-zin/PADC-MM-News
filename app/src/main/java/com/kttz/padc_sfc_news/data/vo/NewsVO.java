package com.kttz.padc_sfc_news.data.vo;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Comment;

import java.util.List;

/**
 * Created by bingbing on 12/2/2017 AD.
 */

public class NewsVO {

    @SerializedName("news-id")
    private String newsId;
    @SerializedName("brief")
    private String brief;
    @SerializedName("details")
    private String detail;
    @SerializedName("images")
    private List<String> images;
    @SerializedName("posted-date")
    private String postedDate;
    @SerializedName("publication")
    private PublicationVO publication;
    @SerializedName("favorites")
    private List<FavouriteActionVO> favourite;
    @SerializedName("comments")
    private List<CommentActionVO> comment;
    @SerializedName("sent-tos")
    private List<SendToVO> sendTo;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetail() {
        return detail;
    }

    public List<String> getImages() {
        return images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavouriteActionVO> getFavourite() {
        return favourite;
    }

    public List<CommentActionVO> getComment() {
        return comment;
    }

    public List<SendToVO> getSendTo() {
        return sendTo;
    }
}
