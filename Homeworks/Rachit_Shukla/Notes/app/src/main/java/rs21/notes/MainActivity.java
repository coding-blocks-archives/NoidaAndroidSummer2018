package rs21.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Calendar;


import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = findViewById(R.id.button);
        final EditText note = findViewById(R.id.editText);
        listView = findViewById(R.id.notes);
        final MyClassAdaptor myClassAdaptor = new MyClassAdaptor();
        listView.setAdapter(myClassAdaptor);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(note.getText().toString());
                //listView.setAdapter(new MyClassAdaptor()); //Whole list is rendered again even if only single item is added
                 myClassAdaptor.notifyDataSetChanged(); //Only the new data added is rendered (optimised)
            }
        });
    }

    class MyClassAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            Log.e("~~~~", "" + convertView);
            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View v;
            ViewHolder vh;
            if (convertView == null) {
                v = li.inflate(R.layout.item_list, parent, false);
                vh = new ViewHolder();
                vh.text = v.findViewById(R.id.finalText);
                vh.del = v.findViewById(R.id.delete);
                vh.time = v.findViewById(R.id.time);
                v.setTag(vh);
            }
            else {
                v = convertView;
                vh = (ViewHolder)v.getTag();
            }

            String text = data.get(position);
            vh.text.setText(text);
            Date currentTime = Calendar.getInstance().getTime();
//            TextView timeDisplay = v.findViewById(R.id.time);
            vh.time.setText(currentTime.toString());

//            Button dlt = v.findViewById(R.id.delete);
//            ViewHolder V = (ViewHolder)v.getTag();

            vh.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.remove(position);
                    notifyDataSetChanged();
                }
            });
            return v;
        }

        class ViewHolder{ //for improving time complexity
            TextView text,time;
            Button del;
        }
    }
    }
