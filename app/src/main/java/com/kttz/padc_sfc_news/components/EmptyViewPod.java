package com.kttz.padc_sfc_news.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kttz.padc_sfc_news.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bingbing on 11/25/2017 AD.
 */

public class EmptyViewPod extends RelativeLayout {

    @BindView(R.id.iv_empty)
    ImageView ivempty;

    @BindView(R.id.tv_empty)
    TextView tvempty;

    public EmptyViewPod(Context context) {
        super(context);
    }

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void setEmptyData(int emptyImageId,String emptyMsg){
        ivempty.setImageResource(emptyImageId);
        tvempty.setText(emptyMsg);
    }
    public void setEmptyData(String emptyMsg){
        tvempty.setText(emptyMsg);
    }

}
