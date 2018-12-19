package com.example.satyaprakash.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Satya Prakash on 29-01-2018.
 */

public class TutList extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    Context context;


    @Override
     public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tut_list, container, false);

        expandableListView = (ExpandableListView) rootView.findViewById(R.id.lvExp_tut);
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
           public boolean onChildClick(ExpandableListView expandableListView, View view,  int groupPosition, int childPosition, long id) {
               Intent intent=  new Intent(getActivity() , Tutorial.class);
               intent.putExtra("tutoriallist" , listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
               startActivity(intent);



               return false;
           }
       });




        return rootView;
    }

    private void prepareListData(Context context) {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("1. Introduction");
        listDataHeader.add("2. Arrays");
        listDataHeader.add("3. Algorithms & Algorithm Complexity");
        listDataHeader.add("4. Searching & Sorting");
        listDataHeader.add("5. Linked List");
        listDataHeader.add("6. Stack");
        listDataHeader.add("7. Queue");
        listDataHeader.add("8. Tree");
        listDataHeader.add("9. Graphs");
        listDataHeader.add("10. Hashing & Hash Function");
        listDataHeader.add("11. File Handling");

        // Adding child data
        List<String> a = new ArrayList<String>();
        a.add("Data Structure Overview");
        a.add("Introduction");

        //arrays
        List<String> b = new ArrayList<String>();
        b.add("Single & Multi-Dimensional Array");
        b.add("Address Calculation");
        b.add("Applications of Array");
        b.add("Operations on Array");

        //algo
        List<String> c = new ArrayList<String>();
        c.add("Algorithms");
        c.add("Algorithms Analysis");
        c.add("Complexity of Algorithms");
        c.add("Time space Trade-off");
        c.add("Asymptotic Notations");

        //searching
        List<String> d = new ArrayList<String>();
        d.add("Linear Search");
        d.add("Binary Search");
        d.add("Insertion Sort");
        d.add("Selection Sort");
        d.add("Bubble Sort");
        d.add("Merge Sort");
        d.add("Quick Sort");
        d.add("Heap Sort");

        //linked list
        List<String> e = new ArrayList<String>();
        e.add("Concept of Linked List");
        e.add("Singly Linked List");
        e.add("Doubly Linked List");
        e.add("Circular Linked List");
        e.add("Operations on Linked List");

        //stack
        List<String> f = new ArrayList<String>();
        f.add("Array Representation of Stack");
        f.add("Applications of Stack");
        f.add("Infix to Prefix Conversion");
        f.add("Infix to Postfix Conversion");
        f.add("Evaluation of Postfix exp. using stack");
        f.add("Evaluation of prefix exp. using stack");

        //queue
        List<String> g = new ArrayList<String>();
        g.add("Array Representation of Queue");
        g.add("Linked Representation of Queue");
        g.add("Circular Queue");
        g.add("DeQueue");
        g.add("Priority Queue");
        g.add("Applications of Queue");

        //tree
        List<String> h = new ArrayList<String>();
        h.add("Basic Terminology of Tree");
        h.add("Binary Tree");
        h.add("Binary Search Tree");
        h.add("AVL Tree");
        h.add("B-tree");

        //graph
        List<String> i = new ArrayList<String>();
        i.add("Basic Terminology & Representation");
        i.add("Graphs & Multi-graphs");
        i.add("Directed Graphs");
        i.add("Spanning Tree");
        i.add("Minimum Cost Spanning Tree");

        //hash
        List<String> j = new ArrayList<String>();
        j.add("Hash Function & Table");
        j.add("Collision Resolution Strategies");
        j.add("Hash Table Implementation");

        List<String> k = new ArrayList<String>();
        k.add("Introduction to File Handling");
        k.add("Data & Information");
        k.add("Concept & Organization");
        k.add("File & Stream");


        listDataChild.put(listDataHeader.get(0),a); // Header, Child data
        listDataChild.put(listDataHeader.get(1), b);
        listDataChild.put(listDataHeader.get(2), c);
        listDataChild.put(listDataHeader.get(3), d);
        listDataChild.put(listDataHeader.get(4), e);
        listDataChild.put(listDataHeader.get(5), f);
        listDataChild.put(listDataHeader.get(6), g);
        listDataChild.put(listDataHeader.get(7), h);
        listDataChild.put(listDataHeader.get(8), i);
        listDataChild.put(listDataHeader.get(9), j);
        listDataChild.put(listDataHeader.get(10), k);
    }

}
