package com.kttz.padc_sfc_news.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.delegates.LoginRegisterDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bingbing on 11/26/2017 AD.
 */

public class LoginFragment extends BaseFragment {
    LoginRegisterDelegate mloginRegisterDelegate;

    public  static LoginFragment newInstance(){
        LoginFragment loginFragment= new LoginFragment();
        return loginFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,loginView);
        return loginView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mloginRegisterDelegate = (LoginRegisterDelegate) context;


        }
        @OnClick (R.id.btn_to_register)
    public void onTapToRegister(View view){
        mloginRegisterDelegate.onTapToRegister();
    }
}
