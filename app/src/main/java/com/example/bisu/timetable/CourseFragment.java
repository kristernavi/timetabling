package com.example.bisu.timetable;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class CourseFragment extends Fragment {

    private CfragDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new CfragDbAdapter();
        dbHelper.open(getActivity());



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_course, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listViewCFrag);
        displayListView(listView);
        TextView emptyText = (TextView)rootView.findViewById(R.id.empty_1);
        listView.setEmptyView(emptyText);
        return rootView;

    }


    private void displayListView(ListView lstvw) {


        Cursor cursor = dbHelper.fetchAllCourses();

        // The desired columns to be bound
        String[] columns = new String[] {
                CfragDbAdapter.KEY_CODE,
                CfragDbAdapter.KEY_NAME,
                CfragDbAdapter.KEY_ROOM,
                CfragDbAdapter.KEY_TIME
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.code2,
                R.id.name2,
                R.id.room2,
                R.id.class_time2
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                getActivity(), R.layout.cfrag_info,
                cursor,
                columns,
                to,
                0);


        // Assign adapter to ListView
        lstvw.setAdapter(dataAdapter);

    }



}