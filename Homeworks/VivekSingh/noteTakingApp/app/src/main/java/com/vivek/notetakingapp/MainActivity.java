package com.vivek.notetakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Details> dt = new ArrayList<Details>();
    Button btn;
    EditText text;
    Button lBtn;
    ListView lv;
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.topBtn);
        text = findViewById(R.id.enter);
        lBtn = findViewById(R.id.lvButton);
        adapter = new MyCustomAdapter();
lv=findViewById(R.id.lvView);
        lv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String details = text.getText().toString();
                dt.add(new Details(details));
            adapter.notifyDataSetChanged();
            }
        });

    }

    class MyCustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dt.size();
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
            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView;
//            if(view==null){
//                inflatedView = li.inflate(R.layout.list_item,viewGroup,false);
//            }
//            else {
//                inflatedView = view;
//            }
            inflatedView = li.inflate(R.layout.list_item, viewGroup, false);

            Details currentDetail = dt.get(i);
            TextView Name = inflatedView.findViewById(R.id.lvText);
            final Button btnDel = inflatedView.findViewById(R.id.lvButton);
            Name.setText(currentDetail.getDetail());
            btnDel.setTag(i);
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int) btnDel.getTag();
                    dt.remove(pos);
adapter.notifyDataSetChanged();
                }
            });
            return inflatedView;
        }
    }
}
