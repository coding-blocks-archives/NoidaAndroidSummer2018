package com.codingblocks.notes_make_hwl4;

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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    ArrayList<note> arraynote = new ArrayList<>();  //we have to set multiple values in list view so use class and put this in arylist.(thru which we get and set)
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(editText.getText())) {
                    String text = editText.getText().toString();
//                String time= Calendar.getInstance().getTime().toString();
                    String time = DateFormat.getDateTimeInstance().format(new Date());
                    arraynote.add(new note(text, time));
                    editText.setText(" ");
                    ListView listView = findViewById(R.id.list_item);
                    listView.setAdapter(new MycustomAdapter());
                }
            }
        });


    }


    class MycustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arraynote.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView;

            if (view == null) {
                inflatedView = li.inflate(R.layout.item_list, viewGroup, false);
            } else {
                inflatedView = view;       //inflation takes some time so if that view is already inflated then why to inflate it again and again
            }

            note currentnote = arraynote.get(i);
            TextView notes = inflatedView.findViewById(R.id.tv1);
            notes.setText(currentnote.getText());

            TextView time = inflatedView.findViewById(R.id.tv2);
            time.setText(currentnote.getTime());

            Button button = inflatedView.findViewById(R.id.remove);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    arraynote.remove(i);
                   notifyDataSetChanged();

                }
            });

            return inflatedView;
        }
    }
}