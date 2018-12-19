package com.example.satyaprakash.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

/**
 * Created by Satya Prakash on 29-01-2018.
 */

public class Setting extends AppCompatActivity {
    AppBarLayout appBarLayout;
    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

       toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_setting);
       setSupportActionBar(toolbar);
       appBarLayout = (AppBarLayout) findViewById(R.id.appbar_setting);


        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
