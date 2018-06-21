package com.codingblocks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentList.add("Harshit");
        studentList.add("Shivam");
        studentList.add("Daman");
        studentList.add("Dheeraj");
        studentList.add("Pranav");
        studentList.add("Harshit");
        studentList.add("Rishabh");
        studentList.add("Sarthik");
        studentList.add("Satendra");
        studentList.add("Rakshit");
        studentList.add("Sunidhi");
        studentList.add("Tanya");
        studentList.add("Laavanya");
        studentList.add("Shreya");
        studentList.add("Veerain");
        studentList.add("Shubham");
        studentList.add("Sameer");
        studentList.add("Vinayak");
        studentList.add("Ayush");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_list,
                R.id.studentNameTView,
                studentList);

        ListView lv = findViewById(R.id.listStudents);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String studentName = studentList.get(i);
                Toast.makeText(getBaseContext(),studentName,Toast.LENGTH_SHORT).show();
            }
        });

        lv.setAdapter(arrayAdapter);
    }
}
