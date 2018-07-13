package com.chirag_bhardwaj.mynotes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


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
        li = findViewById(R.id.listviewmain);

        if(editText.getText()!=null){
            addbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        String currentText = editText.getText().toString();
                        String currentTime = Calendar.getInstance().getTime().toString();
                        arraynotes.add(new note(currentText, currentTime));
                        editText.setText("");
                        li.setAdapter(new MyCustomAdapter());

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
                inflated_view=layoutInflater.inflate(R.layout.item_list,viewGroup,false);
            }
            else{
                inflated_view=view;
            }

            note currentnote=arraynotes.get(i);
            final TextView textView1=inflated_view.findViewById(R.id.notetv);

            textView1.setText(currentnote.getText());

            TextView textView2=inflated_view.findViewById(R.id.timetv);
            textView2.setText(currentnote.getTime());

            Button removebtn=inflated_view.findViewById(R.id.remove);

            final int index=i;
            removebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arraynotes.remove(index);
                    notifyDataSetChanged();
                }
            });


            textView1.setOnClickListener(new View.OnClickListener() {
                int itemClickCount=0;
                @Override
                public void onClick(View view) {
                    itemClickCount++;
                    itemClickCount=(itemClickCount)%3;
                    if(itemClickCount==1)
                    {
                        textView1.setTextColor(Color.parseColor("#00ff00"));
                    }
                    else if(itemClickCount==2)
                    {
                        textView1.setTextColor(Color.parseColor("#7040ff"));
                    }
                    else if(itemClickCount==0)
                    {
                        textView1.setTextColor(Color.parseColor("#ff0000"));
                    }
                }
            });

            return inflated_view;
        }
    }
}