package com.kttz.padc_sfc_news.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bingbing on 11/25/2017 AD.
 */

public class SmartRecyclerView extends RecyclerView {

    private View mEmptyView;

    public SmartRecyclerView(Context context) {
        super(context);
    }



    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(dataObserver);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(dataObserver);
        }
        checkIfEmpty();
    }
    public void setmEmptyView(View emptyView){
        mEmptyView=emptyView;
    }

    /**
     * check if adapter connected to SRV is empty.If so,empty view
     */
    private void checkIfEmpty(){
        boolean isEmpty= getAdapter().getItemCount()==0;
        if(mEmptyView!=null) {
            mEmptyView.setVisibility(isEmpty ? View.VISIBLE : View.INVISIBLE);
            setVisibility(isEmpty ? View.INVISIBLE : View.VISIBLE);
        }
    }

    public SmartRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    //data observeer object need to add for observing when we use empty view
    private AdapterDataObserver dataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            super.onItemRangeRemoved(positionStart, itemCount);
            //shi htar p thar data ta khu khu phyat lite yin (Hope method)
        }

    };

}