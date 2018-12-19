package com.example.satyaprakash.myapplication;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Satya Prakash on 30-01-2018.
 */

public class Tutorial extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    WebView webView;
    String sss;
    CharSequence str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        MobileAds.initialize(this , "ca-app-pub-2141609451926959~5930983148");


        toolbar = (Toolbar) findViewById(R.id.toolbar3);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar1);
        webView = (WebView) findViewById(R.id.web_tut);
        this.webView.getSettings().setBuiltInZoomControls(false);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setUseWideViewPort(true);



        toolbar.setNavigationIcon(R.drawable.ic_action_name);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            toolbar.setTitle(bundle.getString("tutoriallist"));

             str = bundle.getString("tutoriallist").toLowerCase();
             sss = "file:///android_asset/tut/" + str + ".html";

            this.webView.loadUrl(sss);


        }



    }
}
