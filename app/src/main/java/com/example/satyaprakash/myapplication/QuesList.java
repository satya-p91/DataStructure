package com.example.satyaprakash.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Satya Prakash on 29-01-2018.
 */

public class QuesList extends Fragment{

    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List listDataHeader;
    HashMap listDataChild;

    Context context;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ques_list, container, false);

        expandableListView = (ExpandableListView) rootView.findViewById(R.id.lvExp);
        prepareListData(context);

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader , listDataChild);

        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

              //  Toast.makeText(getActivity(),
                //        listDataHeader.get(groupPosition) + " Expanded",
                  //      Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //Toast.makeText(getActivity(),
                  //      listDataHeader.get(groupPosition) + " Collapsed",
                    //    Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {


                return false;
            }
        });


        return rootView;
    }

    private void prepareListData(Context context) {

        this.context = context;
        BufferedReader bufferedReader;
        int i;
        String readLine;
        BufferedReader bufferedReader1;
        IOException e;
        int i2 = 0;
        List arrayList;
        String str = "ques/questions.html";
        String str2 = "ques/answers.html";
        this.listDataHeader = new ArrayList();
        this.listDataChild = new HashMap();
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(getContext().getAssets().open(str)));
            try{
                Object readLine2 = bufferedReader.readLine();
                i = 0;
                while (readLine2!=null){

                    try{
                        this.listDataHeader.add(readLine2);
                        readLine2 = bufferedReader.readLine();
                        i++;
                    }catch (IOException e2){
                        e = e2;
                    }
                }
                bufferedReader.close();
            }catch (IOException e3){
                e = e3;
                i = 0;
                e.printStackTrace();
                bufferedReader1 = new BufferedReader(new InputStreamReader(getContext().getAssets().open(str2)));
                while(i2< i ){
                    try {
                        readLine = bufferedReader1.readLine();
                        arrayList = new ArrayList();
                        arrayList.add(readLine);
                        this.listDataChild.put(this.listDataHeader.get(i2), arrayList);
                    }catch (IOException e4){
                        e4.printStackTrace();
                    }
                    i2++;

                }

            }

        }catch (IOException e5 ){

            e = e5;
            bufferedReader = null;
            i = 0;
            e.printStackTrace();
            try {
                bufferedReader1 = new BufferedReader(new InputStreamReader(getContext().getAssets().open(str2)));
                while (i2 < i) {
                    readLine = bufferedReader1.readLine();
                    arrayList = new ArrayList();
                    arrayList.add(readLine);
                    this.listDataChild.put(this.listDataHeader.get(i2) , arrayList);
                    i2++;

                }
            }catch (IOException e8){
                e8.printStackTrace();
            }


        }
        try {
            bufferedReader1 = new BufferedReader(new InputStreamReader(getContext().getAssets().open(str2)));


        }catch (IOException  e7){
            e7.printStackTrace();
            bufferedReader1 = bufferedReader;
        }
        try {
            while (i2 < i) {
                readLine = bufferedReader1.readLine();
                arrayList = new ArrayList();
                arrayList.add(readLine);
                this.listDataChild.put(this.listDataHeader.get(i2), arrayList);
                i2++;
            }
        }catch (IOException e9){
            e9.printStackTrace();
        }


    }
}
