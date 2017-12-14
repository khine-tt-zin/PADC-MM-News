package com.kttz.padc_sfc_news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kttz.padc_sfc_news.R;
import com.kttz.padc_sfc_news.adapters.NewsAdapter;
import com.kttz.padc_sfc_news.components.EmptyViewPod;
import com.kttz.padc_sfc_news.components.SmartRecyclerView;
import com.kttz.padc_sfc_news.components.SmartScrollListener;
import com.kttz.padc_sfc_news.data.models.NewsModel;
import com.kttz.padc_sfc_news.delegates.NewsItemDelegate;
import com.kttz.padc_sfc_news.events.RestApiEvents;
import com.kttz.padc_sfc_news.events.TapNewEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class NewsListActivity extends BaseActivity implements NewsItemDelegate {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.rv_news)
    SmartRecyclerView rvNews;

    @BindView(R.id.vp_empty_news)
    EmptyViewPod vpemptynews;

    private SmartScrollListener msmartScrollListener;
    private NewsAdapter mNewsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ButterKnife.bind(this, this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                //drawerLayout.openDrawer(GravityCompat.START);
                Intent intent = LoginRegisterActivity.newIntent(getApplicationContext());
                startActivity(intent);

            }
        });

        //Call Network Request
        NewsModel.getInstance().loadMMNews();

//        rvNews.setmEmptyView(vpemptynews);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mNewsAdapter = new NewsAdapter(getApplicationContext(), this);
        rvNews.setAdapter(mNewsAdapter);

        msmartScrollListener = new SmartScrollListener(new SmartScrollListener.onSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvNews, "ddddd", LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTapComment() {

    }

    @Override
    public void onTapSendTo() {

    }

    @Override
    public void onTapFavourite() {

    }

    @Override
    public void onTapStatistics() {

    }

    @Override
    public void onTapNews() {
        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTapNewsEvent(TapNewEvent event) {
        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext());
        startActivity(intent);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsDataLoader(RestApiEvents.NewsDataLoadedevent event){
        mNewsAdapter.appendNewData(event.getLoadedNews());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event){
        Snackbar.make(rvNews,event.getErrorMsg(),Snackbar.LENGTH_INDEFINITE).show();
    }
}
