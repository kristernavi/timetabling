package com.example.bisu.timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class CourseSelect extends AppCompatActivity {

    private CourseDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;
    private CfragDbAdapter cFragdbHelp;
    SharedPreferences sharedPref;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_select);
        sharedPref = getSharedPreferences("mypref", Context.MODE_PRIVATE);


        dbHelper = new CourseDbAdapter(this);
        dbHelper.open();
        cFragdbHelp = new CfragDbAdapter();
        cFragdbHelp.open(this);

        //Clean all data


        //Add some data
        dbHelper.insertSomeCourses();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {


        Cursor cursor = dbHelper.fetchAllCourses();

        // The desired columns to be bound
        String[] columns = new String[] {
                CourseDbAdapter.KEY_CODE,
                CourseDbAdapter.KEY_NAME,
                CourseDbAdapter.KEY_ROOM,
                CourseDbAdapter.KEY_TIME
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.code,
                R.id.name,
                R.id.room,
                R.id.class_time
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.course_info,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the code from this row in the database.
                String Code = cursor.getString(cursor.getColumnIndexOrThrow("code"));
                String Name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String Room = cursor.getString(cursor.getColumnIndexOrThrow("room"));
                String Time = cursor.getString(cursor.getColumnIndexOrThrow("time"));

                cFragdbHelp.createCourse(Code, Name, Room, Time);


                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(Code, Time);
                editor.commit();




                Toast.makeText(getApplicationContext(),
                        Code + " added", Toast.LENGTH_SHORT).show();


            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return dbHelper.fetchCoursesByCode(constraint.toString());
            }
        });

    }
}
