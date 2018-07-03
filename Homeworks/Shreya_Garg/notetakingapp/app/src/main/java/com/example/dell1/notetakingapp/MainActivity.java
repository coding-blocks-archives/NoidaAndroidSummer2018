package com.example.dell1.notetakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    ArrayList<note> arraynotes=new ArrayList<>();
    Button addbutton;
    EditText editText;
    ListView li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addbutton=findViewById(R.id.addbtn);
        editText=findViewById(R.id.et1);
//        li.setAdapter(notesadpater=new MyCustomAdapter());
        if(editText.getText()!=null){
            addbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!TextUtils.isEmpty(editText.getText())) {
                        String currentText = editText.getText().toString();
                        String currentTime = Calendar.getInstance().getTime().toString();
                        arraynotes.add(new note(currentText, currentTime));
                        editText.setText("");
                        li = findViewById(R.id.listviewmain);
                        li.setAdapter(new MyCustomAdapter());///we are again and again calling setadapter when is memory intensive process
//                        notesadapter.notifydatasetChanged();
                    }
                }
            });
        }
    }
    class MyCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arraynotes.size();
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

            View inflated_view;
            LayoutInflater layoutInflater=(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            if(view==null)
            {
                inflated_view=layoutInflater.inflate(R.layout.list_items,viewGroup,false);
            }
            else{
                inflated_view=view;
            }

            note currentnote=arraynotes.get(i);
            TextView textView1=inflated_view.findViewById(R.id.notetv);
            //if(currentnote.getText()!=null)
           textView1.setText(currentnote.getText());

            TextView textView2=inflated_view.findViewById(R.id.timetv);
            textView2.setText(currentnote.getTime());

            Button removebtn=inflated_view.findViewById(R.id.remove);
            //removebtn.setTag(i);
            final int index=i;
            removebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 //   Integer index=(Integer)view.getTag();
                    arraynotes.remove(index);
                    notifyDataSetChanged();
                }
            });

            return inflated_view;
        }
    }
}
