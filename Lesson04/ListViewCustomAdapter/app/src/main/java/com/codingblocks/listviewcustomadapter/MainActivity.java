package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.lLayout);

//        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

//        li.inflate(R.layout.ad_layout,linearLayout,true);

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
        studentArrayList.add(new Student("Rishabh",
                "Web Development",
                "Noida"));
        studentArrayList.add(new Student("Sarthik",
                "Android App Development",
                "Noida"));
        ListView listView = findViewById(R.id.lvStudents);
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter();
        listView.setAdapter(myCustomAdapter);
    }


    class MyCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return studentArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Log.e("TAG",""+view);
            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView;

            if (view == null){
                inflatedView = li.inflate(R.layout.item_row,viewGroup,false);
            } else {
                inflatedView = view;
            }

            Student currentStudent = studentArrayList.get(i);

            TextView studentName = inflatedView.findViewById(R.id.tvName);
            studentName.setText(currentStudent.getName());
            TextView studentBatch = inflatedView.findViewById(R.id.tvBatch);
            TextView studentLocation = inflatedView.findViewById(R.id.tvLocation);

            studentBatch.setText(currentStudent.getBatch());
            studentLocation.setText(currentStudent.getLocation());
            return inflatedView;
        }
    }
}
