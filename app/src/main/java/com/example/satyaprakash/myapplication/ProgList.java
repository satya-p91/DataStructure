package com.example.satyaprakash.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

/**
 * Created by Satya Prakash on 29-01-2018.
 */

public class ProgList extends Fragment {

    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.prog_list , container , false);


       final ListView listView = (ListView) rootView.findViewById(R.id.listview);


              adapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.program_list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=  new Intent(getActivity() , Program.class);
                intent.putExtra("program_list" , listView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);





        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_program, menu);

        MenuItem item = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String sn) {
                adapter.getFilter().filter(sn);

                return false;
            }
        });


        super.onCreateOptionsMenu(menu, inflater);
    }

}
