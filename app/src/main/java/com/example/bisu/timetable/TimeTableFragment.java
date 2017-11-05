package com.example.bisu.timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;


public class TimeTableFragment extends Fragment {

    SharedPreferences sharedPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_time_table, container, false);

        sharedPref = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {

            String Time = entry.getValue().toString();
            int i = Time.length();
            ArrayList arDay = new ArrayList();
            ArrayList arTime = new ArrayList();

            for (int count = 0; count < i; count++) {
                char txt = Time.charAt(count);
                if (txt == 'T') {
                    if (Time.charAt(count + 1) == ' ') {

                        arDay.add("T");

                    } else {

                        arDay.add("H");

                    }
                } else if (txt == 'M' || txt == 'W' || txt == 'F' || txt == 'S') {

                    arDay.add(String.valueOf(txt));

                } else if (txt == '1' || txt == '2' || txt == '3' || txt == '4' || txt == '5' || txt == '6' || txt == '7' || txt == '8' || txt == '9') {

                    arTime.add(String.valueOf(txt));

                }
            }

            for(int d = 0; d < arDay.size();d++){
                for(int t = 0; t < arTime.size(); t++){
                    String daytime = (String)arDay.get(d) + (String)arTime.get(t);
                    switch (daytime){
                        case "M6":
                            TextView m1 = (TextView)rootView.findViewById(R.id.m1);
                            m1.setText(entry.getKey());
                            break;
                        case "M7":
                            TextView m2 = (TextView)rootView.findViewById(R.id.m2);
                            m2.setText(entry.getKey());
                            break;
                        case "M8":
                            TextView m3 = (TextView)rootView.findViewById(R.id.m3);
                            m3.setText(entry.getKey());
                            break;
                        case "M9":
                            TextView m4 = (TextView)rootView.findViewById(R.id.m4);
                            m4.setText(entry.getKey());
                            break;
                        case "M10":
                            TextView m5 = (TextView)rootView.findViewById(R.id.m5);
                            m5.setText(entry.getKey());
                            break;
                        case "M1":
                            TextView m8 = (TextView)rootView.findViewById(R.id.m8);
                            m8.setText(entry.getKey());
                            break;
                        case "M2":
                            TextView m9 = (TextView)rootView.findViewById(R.id.m9);
                            m9.setText(entry.getKey());
                            break;
                        case "M3":
                            TextView m10 = (TextView)rootView.findViewById(R.id.m10);
                            m10.setText(entry.getKey());
                            break;
                        case "M4":
                            TextView m11 = (TextView)rootView.findViewById(R.id.m11);
                            m11.setText(entry.getKey());
                            break;
                        case "M5":
                            TextView m12 = (TextView)rootView.findViewById(R.id.m12);
                            m12.setText(entry.getKey());
                            break;
                        case "T6":
                            TextView t1 = (TextView)rootView.findViewById(R.id.t1);
                            t1.setText(entry.getKey());
                            break;
                        case "T7":
                            TextView t2 = (TextView)rootView.findViewById(R.id.t2);
                            t2.setText(entry.getKey());
                            break;
                        case "T8":
                            TextView t3 = (TextView)rootView.findViewById(R.id.t3);
                            t3.setText(entry.getKey());
                            break;
                        case "T9":
                            TextView t4 = (TextView)rootView.findViewById(R.id.t4);
                            t4.setText(entry.getKey());
                            break;
                        case "T10":
                            TextView t5 = (TextView)rootView.findViewById(R.id.t5);
                            t5.setText(entry.getKey());
                            break;
                        case "T1":
                            TextView t8 = (TextView)rootView.findViewById(R.id.t8);
                            t8.setText(entry.getKey());
                            break;
                        case "T2":
                            TextView t9 = (TextView)rootView.findViewById(R.id.t9);
                            t9.setText(entry.getKey());
                            break;
                        case "T3":
                            TextView t10 = (TextView)rootView.findViewById(R.id.t10);
                            t10.setText(entry.getKey());
                            break;
                        case "T4":
                            TextView t11 = (TextView)rootView.findViewById(R.id.t11);
                            t11.setText(entry.getKey());
                            break;
                        case "T5":
                            TextView t12 = (TextView)rootView.findViewById(R.id.t12);
                            t12.setText(entry.getKey());
                            break;
                        case "W6":
                            TextView w1 = (TextView)rootView.findViewById(R.id.w1);
                            w1.setText(entry.getKey());
                            break;
                        case "W7":
                            TextView w2 = (TextView)rootView.findViewById(R.id.w2);
                            w2.setText(entry.getKey());
                            break;
                        case "W8":
                            TextView w3 = (TextView)rootView.findViewById(R.id.w3);
                            w3.setText(entry.getKey());
                            break;
                        case "W9":
                            TextView w4 = (TextView)rootView.findViewById(R.id.w4);
                            w4.setText(entry.getKey());
                            break;
                        case "W10":
                            TextView w5 = (TextView)rootView.findViewById(R.id.w5);
                            w5.setText(entry.getKey());
                            break;
                        case "W1":
                            TextView w8 = (TextView)rootView.findViewById(R.id.w8);
                            w8.setText(entry.getKey());
                            break;
                        case "W2":
                            TextView w9 = (TextView)rootView.findViewById(R.id.w9);
                            w9.setText(entry.getKey());
                            break;
                        case "W3":
                            TextView w10 = (TextView)rootView.findViewById(R.id.w10);
                            w10.setText(entry.getKey());
                            break;
                        case "W4":
                            TextView w11 = (TextView)rootView.findViewById(R.id.w11);
                            w11.setText(entry.getKey());
                            break;
                        case "W5":
                            TextView w12 = (TextView)rootView.findViewById(R.id.w12);
                            w12.setText(entry.getKey());
                            break;
                        case "H6":
                            TextView h1 = (TextView)rootView.findViewById(R.id.h1);
                            h1.setText(entry.getKey());
                            break;
                        case "H7":
                            TextView h2 = (TextView)rootView.findViewById(R.id.h2);
                            h2.setText(entry.getKey());
                            break;
                        case "H8":
                            TextView h3 = (TextView)rootView.findViewById(R.id.h3);
                            h3.setText(entry.getKey());
                            break;
                        case "H9":
                            TextView h4 = (TextView)rootView.findViewById(R.id.h4);
                            h4.setText(entry.getKey());
                            break;
                        case "H10":
                            TextView h5 = (TextView)rootView.findViewById(R.id.h5);
                            h5.setText(entry.getKey());
                            break;
                        case "H1":
                            TextView h8 = (TextView)rootView.findViewById(R.id.h8);
                            h8.setText(entry.getKey());
                            break;
                        case "H2":
                            TextView h9 = (TextView)rootView.findViewById(R.id.h9);
                            h9.setText(entry.getKey());
                            break;
                        case "H3":
                            TextView h10 = (TextView)rootView.findViewById(R.id.h10);
                            h10.setText(entry.getKey());
                            break;
                        case "H4":
                            TextView h11 = (TextView)rootView.findViewById(R.id.h11);
                            h11.setText(entry.getKey());
                            break;
                        case "H5":
                            TextView h12 = (TextView)rootView.findViewById(R.id.h12);
                            h12.setText(entry.getKey());
                            break;
                        case "F6":
                            TextView f1 = (TextView)rootView.findViewById(R.id.f1);
                            f1.setText(entry.getKey());
                            break;
                        case "F7":
                            TextView f2 = (TextView)rootView.findViewById(R.id.f2);
                            f2.setText(entry.getKey());
                            break;
                        case "F8":
                            TextView f3 = (TextView)rootView.findViewById(R.id.f3);
                            f3.setText(entry.getKey());
                            break;
                        case "F9":
                            TextView f4 = (TextView)rootView.findViewById(R.id.f4);
                            f4.setText(entry.getKey());
                            break;
                        case "F10":
                            TextView f5 = (TextView)rootView.findViewById(R.id.f5);
                            f5.setText(entry.getKey());
                            break;
                        case "F1":
                            TextView f8 = (TextView)rootView.findViewById(R.id.f8);
                            f8.setText(entry.getKey());
                            break;
                        case "F2":
                            TextView f9 = (TextView)rootView.findViewById(R.id.f9);
                            f9.setText(entry.getKey());
                            break;
                        case "F3":
                            TextView f10 = (TextView)rootView.findViewById(R.id.f10);
                            f10.setText(entry.getKey());
                            break;
                        case "F4":
                            TextView f11 = (TextView)rootView.findViewById(R.id.f11);
                            f11.setText(entry.getKey());
                            break;
                        case "F5":
                            TextView f12 = (TextView)rootView.findViewById(R.id.f12);
                            f12.setText(entry.getKey());
                            break;
                        case "S6":
                            TextView s1 = (TextView)rootView.findViewById(R.id.s1);
                            s1.setText(entry.getKey());
                            break;
                        case "S7":
                            TextView s2 = (TextView)rootView.findViewById(R.id.s2);
                            s2.setText(entry.getKey());
                            break;
                        case "S8":
                            TextView s3 = (TextView)rootView.findViewById(R.id.s3);
                            s3.setText(entry.getKey());
                            break;
                        case "S9":
                            TextView s4 = (TextView)rootView.findViewById(R.id.s4);
                            s4.setText(entry.getKey());
                            break;
                        case "S10":
                            TextView s5 = (TextView)rootView.findViewById(R.id.s5);
                            s5.setText(entry.getKey());
                            break;
                        case "S1":
                            TextView s8 = (TextView)rootView.findViewById(R.id.s8);
                            s8.setText(entry.getKey());
                            break;
                        case "S2":
                            TextView s9 = (TextView)rootView.findViewById(R.id.s9);
                            s9.setText(entry.getKey());
                            break;
                        case "S3":
                            TextView s10 = (TextView)rootView.findViewById(R.id.s10);
                            s10.setText(entry.getKey());
                            break;
                        case "S4":
                            TextView s11 = (TextView)rootView.findViewById(R.id.s11);
                            s11.setText(entry.getKey());
                            break;
                        case "S5":
                            TextView s12 = (TextView)rootView.findViewById(R.id.s12);
                            s12.setText(entry.getKey());
                            break;
                        default:
                            break;

                    }
                }
            }

        }
        return rootView;
    }
}