package com.kttz.padc_sfc_news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kttz.padc_sfc_news.R;

import butterknife.ButterKnife;

/**
 * Created by bingbing on 11/26/2017 AD.
 */

public  class RegisterFragment extends BaseFragment {
    public  static RegisterFragment newInstance(){
        RegisterFragment registerFragment= new RegisterFragment();
        return registerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginview=inflater.inflate(R.layout.fragment_register,container,false);
        ButterKnife.bind(this,loginview);
        return loginview;
    }
}
