package com.kttz.padc_sfc_news.components;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

/**
 * Created by bingbing on 11/26/2017 AD.
 */

public class SmartScrollListener extends RecyclerView.OnScrollListener {
    private int visibleItemCount, pastVisibleItems, totalItemCount;
    private boolean isListEndReached= false;
    private int previousDy, currentDy;

    private onSmartScrollListener mSmartScrollListener;
    public SmartScrollListener(onSmartScrollListener smartScrollListener) {
        this.mSmartScrollListener=smartScrollListener;
    }

    public interface onSmartScrollListener{
        void onListEndReach();

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
        super.onScrollStateChanged(recyclerView, scrollState);
        if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
            if ((visibleItemCount + pastVisibleItems) >= totalItemCount
                    && !isListEndReached) {
                isListEndReached = true;
                mSmartScrollListener.onListEndReach();
            }
        }
    }

    @Override
    public void onScrolled(RecyclerView rv, int dx, int dy) {
        super.onScrolled(rv, dx, dy);

        currentDy= dy;
        if(currentDy > previousDy){
            // from top to bottom
        }else if(currentDy <previousDy){
            //from bottom to top
            isListEndReached=false;

            visibleItemCount=rv.getLayoutManager().getChildCount();
            totalItemCount=rv.getLayoutManager().getItemCount();
            pastVisibleItems=((LinearLayoutManager) rv.getLayoutManager()).findFirstVisibleItemPosition();
            previousDy=currentDy;

        }

    }
}
