package com.kttz.padc_sfc_news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.delegates.LoginRegisterDelegate;
import com.kttz.padc_sfc_news.fragment.LoginFragment;
import com.kttz.padc_sfc_news.fragment.RegisterFragment;

import butterknife.ButterKnife;

/**
 * Created by bingbing on 11/26/2017 AD.
 */

public class LoginRegisterActivity extends BaseActivity implements LoginRegisterDelegate {

    public  static Intent newIntent(Context context){
        Intent intent=new Intent(context,LoginRegisterActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        ButterKnife.bind(this,this);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, LoginFragment.newInstance())
                    .commit();
        }
    }


    @Override
    public void onTapLogin() {

    }

    @Override
    public void onTapForgotPassword() {

    }

    @Override
    public void onTapToRegister() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.enter,R.anim.exit)
                .replace(R.id.fl_container, RegisterFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
