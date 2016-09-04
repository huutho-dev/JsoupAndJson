package com.edu.gvn.jsoupdemo.fragment.online;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.edu.gvn.jsoupdemo.R;

public class NavigationDrawerOnlineFragment extends Fragment implements View.OnClickListener {


    public interface GetNavItemClickListener {
        void onItemClick(View v);
    }

    private GetNavItemClickListener listener;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Activity mActivity;
    private View mFragment;

    private LinearLayout mVoiceSearch, mSearch, mHotMusic, mRank, mArtists, mAlbums, mTopTen;
    private LinearLayout mLyricOnScreen, mSuggestApps, mSettings, mExits;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflateView = inflater.inflate(R.layout.fragment_navigation_drawer_online, container, false);
        inflateView.findViewById(R.id.ll_voice_serch).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_search).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_hot_music).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_rank).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_artists).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_albums).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_top_ten).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_option_lyric_screen).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_option_suggested_apps).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_option_settings).setOnClickListener(this);
        inflateView.findViewById(R.id.ll_option_exit).setOnClickListener(this);

        mDrawerLayout = (DrawerLayout) inflateView.findViewById(R.id.drawer_layout);
        return inflateView;
    }

    public void setUpNavDrawer(final int idFragment, DrawerLayout drawerLayout, Toolbar toolbar,GetNavItemClickListener listener ) {
        this.mDrawerLayout = drawerLayout;
        this.listener = listener ;
        mFragment = mActivity.findViewById(idFragment);
        mToggle = new ActionBarDrawerToggle(mActivity, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mActivity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mActivity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mDrawerLayout.setScrimColor(Color.TRANSPARENT);
                float moveFactor = mFragment.getWidth() * slideOffset;
                //   TranslateAnimation translate  = new TranslateAnimation(0.0f,moveFactor,0.0f,0.0f);
                //  translate.setFillAfter(false);
                mActivity.findViewById(R.id.rl_parent).setTranslationX(moveFactor);
            }
        };

        drawerLayout.addDrawerListener(mToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mToggle.syncState();
            }
        });

    }

    public void closeNavDrawer() {
        mDrawerLayout.closeDrawer(mFragment);
    }


    @Override
    public void onClick(View v) {
        listener.onItemClick(v);
    }


}