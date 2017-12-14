package com.kttz.padc_sfc_news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public class CommentActionVO {

    @SerializedName("comment-id")
    private String commentId;
    @SerializedName("comment")
    private String comment;
    @SerializedName("comment-date")
    private String commentData;
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentData() {
        return commentData;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
