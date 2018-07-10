package com.example.dhirajchhabraeng.lecture4;

import android.support.constraint.solver.LinearSystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dhirajchhabraeng.lecture4.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> studentList = new ArrayList<>();

        studentList.add("1");
        studentList.add("2");
        studentList.add("3");
        studentList.add("4");
        studentList.add("5");
        studentList.add("6");
        studentList.add("7");
        studentList.add("8");
        studentList.add("9");
        studentList.add("10");
        studentList.add("11");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_item, studentList);

        ListView listView = findViewById(R.id.list_view);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"" + studentList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
