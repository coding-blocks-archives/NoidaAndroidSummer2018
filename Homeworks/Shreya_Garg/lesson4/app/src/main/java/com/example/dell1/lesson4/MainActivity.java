package com.example.dell1.lesson4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> studentlist=new ArrayList<>(); ///depending on data set we can change its value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentlist.add("shreya");
        studentlist.add("sunidhi");
        studentlist.add("priya");
        studentlist.add("lavanya");
        studentlist.add("harshit");
        studentlist.add("shrey");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.itemlist,R.id.textview1,studentlist);
        final ListView lv=findViewById(R.id.listview1);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=studentlist.get(i);
                //String item=lv.getItemAtPosition(i).toString();   this can also be done
                Toast.makeText(getBaseContext(),item,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
