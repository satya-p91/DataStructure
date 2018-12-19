package com.example.satyaprakash.myapplication;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;

public class Program extends AppCompatActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    WebView webView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program);

        MobileAds.initialize(this , "ca-app-pub-2141609451926959~5930983148");


        toolbar = (Toolbar) findViewById(R.id.toolbar_prog);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_prog);
        webView = (WebView) findViewById(R.id.web_prog);
        imageView = (ImageView) findViewById(R.id.img_op);
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
            toolbar.setTitle(bundle.getString("program_list"));



            CharSequence str = bundle.getString("program_list").toLowerCase();
            String s= "prog/" + str + ".png";
            String ss = "file:///android_asset/prog/" + str + ".html";

            //if (toolbar.getTitle().toString().equalsIgnoreCase("Linear Search")){


              this.webView.loadUrl(ss);

                try {
                    imageView.setImageBitmap(BitmapFactory.decodeStream(getAssets().open(s)));
                }catch (Exception e){
                    return;
                }

           // }

        }




    }
}
