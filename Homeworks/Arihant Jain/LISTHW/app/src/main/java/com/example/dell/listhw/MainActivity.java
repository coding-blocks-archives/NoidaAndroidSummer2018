package com.example.dell.listhw;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
ArrayList<id> arrayob=new ArrayList<>();
EditText texte;
Button bt;
Button delbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texte=findViewById(R.id.text);
        bt=findViewById(R.id.btn1);
        final ListView lv=findViewById(R.id.list);
        final MycustomAdapter adapter=new MycustomAdapter();
        lv.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S = texte.getText().toString();

                Calendar c = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                String time = "" + format.format(c.getTime());

                arrayob.add(new id(S, time));

                adapter.notifyDataSetChanged();
            }
        });

    }
    class MycustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayob.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        class ViewHolder{
            TextView idText,idTime;
        }
        @Override
        public View getView(int position, final View View, ViewGroup parent) {
            LayoutInflater li= (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            final View inflateview;

            if(View==null){
                inflateview=li.inflate(R.layout.livw, parent,false );
                ViewHolder viewHolder=new ViewHolder();
                viewHolder.idText=inflateview.findViewById(R.id.text2);
                viewHolder.idTime=inflateview.findViewById(R.id.text3);
                inflateview.setTag(viewHolder);

            }
            else{
                inflateview=View;
            }

            final id current=arrayob.get(position);

            final TextView text=inflateview.findViewById(R.id.text2);
            text.setText(current.getText());

            final TextView time=inflateview.findViewById(R.id.text3);
            time.setText(current.getTime());

            Button delbtn=inflateview.findViewById(R.id.btn);
            delbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 arrayob.remove(current);
            //        final ListView lv=findViewById(R.id.list);
          //          lv.setAdapter(new MycustomAdapter());

                     notifyDataSetChanged();
                }
            });
            ViewHolder vh= (ViewHolder) inflateview.getTag();
            vh.idText.setText(current.getText()+current.getText());
            vh.idTime.setText(current.getTime());

            return inflateview;
        }

    }

}
