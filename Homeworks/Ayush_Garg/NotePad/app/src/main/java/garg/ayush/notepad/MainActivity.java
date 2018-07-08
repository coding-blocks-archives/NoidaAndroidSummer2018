package garg.ayush.notepad;

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
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList <String> notes = new ArrayList<>();
    int count=0;
    EditText editText;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addbtn = findViewById(R.id.add_btn);
        Button delete = findViewById(R.id.delete_btn);
        editText = findViewById(R.id.edit_text);
        listView=findViewById(R.id.lv);
        //notes.add(editText.getText().toString());

        final MyCustomAdapter myCustomAdapter = new MyCustomAdapter();
        listView.setAdapter(myCustomAdapter);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.add(editText.getText().toString());
                count++;
                myCustomAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

    }

    class ViewHolder{
        TextView notetitle,noteTime;
    }
    class MyCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return count;
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

            LayoutInflater li = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

            final View inflatedView;

            if(view==null) {
                inflatedView = li.inflate(R.layout.list_view, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.notetitle=inflatedView.findViewById(R.id.text);
                viewHolder.noteTime=inflatedView.findViewById(R.id.time_date);
                inflatedView.setTag(viewHolder);
            }
            else {
                inflatedView = view;
            }

            ViewHolder vh=(ViewHolder) inflatedView.getTag();
            TextView textView=vh.notetitle;

            String enteredtext = notes.get(i);
//            TextView textView = inflatedView.findViewById(R.id.text);
            textView.setText(enteredtext);
            Button del_btn = inflatedView.findViewById(R.id.delete_btn);
            final int index=i;


            //Date date =new Date();
            TextView timeandDate = inflatedView.findViewById(R.id.time_date);
            long currenttimeanddate= System.currentTimeMillis();
//            timeandDate.setText(System.currentTimeMillis()+"");
            Date date = new Date(currenttimeanddate);
//            timeandDate.setText(date+"");

            Calendar calendar =Calendar.getInstance();
            calendar.setTimeInMillis(currenttimeanddate);
            timeandDate.setText(calendar.getTime()+"");

//            DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
//            timeandDate.setText(df.format(date));

            del_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(getBaseContext(), "Hi", Toast.LENGTH_SHORT).show();
                    notes.remove(notes.get(index));
                    count--;
                    notifyDataSetChanged();
//                    listView.setAdapter(new MyCustomAdapter());
                    Log.e("Hi", "onClick: " );
                }
            });

            return inflatedView;
        }
    }


}
