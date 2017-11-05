package com.example.bisu.timetable;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {

    private CfragDbAdapter cFragdbHelp;
    SharedPreferences sharedPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cFragdbHelp = new CfragDbAdapter();
        cFragdbHelp.open(getActivity());



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);
        sharedPref = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);

        Button del = (Button) rootView.findViewById(R.id.del_all_button);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cFragdbHelp.deleteAllCourses();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(getActivity(),
                        "All Courses Deleted", Toast.LENGTH_SHORT).show();


            }
        });

        return rootView;
    }



}
