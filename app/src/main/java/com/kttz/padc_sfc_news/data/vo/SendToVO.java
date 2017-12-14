package com.kttz.padc_sfc_news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bingbing on 12/3/2017 AD.
 */

public class SendToVO {
    @SerializedName("send-to-id")
    private String sendToId;
    @SerializedName("sent-date")
    private String sendDate;
    @SerializedName("acted-user")
    private ActedUserVO sender;

    @SerializedName("received-user")
    private ActedUserVO receiver;

    public String getSendToId() {
        return sendToId;
    }

    public String getSendData() {
        return sendDate;
    }

    public ActedUserVO getSender() {
        return sender;
    }

    public ActedUserVO getReceiver() {
        return receiver;
    }
}
