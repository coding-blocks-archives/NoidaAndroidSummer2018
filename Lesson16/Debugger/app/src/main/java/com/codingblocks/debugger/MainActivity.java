package com.codingblocks.debugger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentArrayList.add(new Student("Harshit",
                "Android App Development",
                "Janakpuri East"));
        studentArrayList.add(new Student("Shivam",
                "Web Development",
                "Greater Noida"));
        studentArrayList.add(new Student("Daman",
                "Android App Development",
                "Noida Sector 15"));
        studentArrayList.add(new Student("Dheeraj",
                "Machine Learning",
                "Pitampura"));
        studentArrayList.add(new Student("Pranav",
                "Android App Development",
                "Dwarka"));
        studentArrayList.add(new Student("Harshit",
                "Machine Learning",
                "Dwarka"));
        studentArrayList.add(new Student("Rishabh",
                "Web Development",
                "Noida"));
        studentArrayList.add(new Student("Sarthik",
                "Android App Development",
                "Noida"));
        studentArrayList.add(new Student("Harshit",
                "Android App Development",
                "Janakpuri East"));
        studentArrayList.add(new Student("Shivam",
                "Web Development",
                "Greater Noida"));
        studentArrayList.add(new Student("Daman",
                "Android App Development",
                "Noida Sector 15"));
        studentArrayList.add(new Student("Dheeraj",
                "Machine Learning",
                "Pitampura"));
        studentArrayList.add(new Student("Pranav",
                "Android App Development",
                "Dwarka"));
        studentArrayList.add(new Student("Harshit",
                "Machine Learning",
                "Dwarka"));
        studentArrayList.add(null);
        studentArrayList.add(new Student("Rishabh",
                "Web Development",
                "Noida"));
        studentArrayList.add(new Student("Sarthik",
                "Android App Development",
                "Noida"));

        for (Student s : studentArrayList) {

            String name = s.getName();
            String batch = s.getBatch();
            String location = s.getLocation();

        }

    }
}
