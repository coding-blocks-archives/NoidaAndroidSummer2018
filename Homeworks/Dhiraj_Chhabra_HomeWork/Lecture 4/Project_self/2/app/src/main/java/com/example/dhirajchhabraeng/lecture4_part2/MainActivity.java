package com.example.dhirajchhabraeng.lecture4_part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Display> numbersList = new ArrayList<>();

        numbersList.add(new Display("1", "1"));
        numbersList.add(new Display("2", "4"));
        numbersList.add(new Display("3", "9"));
        numbersList.add(new Display("4", "16"));
        numbersList.add(new Display("5", "25"));
        numbersList.add(new Display("6", "36"));
        numbersList.add(new Display("7", "49"));
        numbersList.add(new Display("8", "64"));
        numbersList.add(new Display("9", "81"));

        ListView listView = findViewById(R.id.list_view);

        class displayAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                return numbersList.size();
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
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View inflatedView = convertView;
                if (inflatedView == null) {
                    inflatedView = li.inflate(R.layout.list_item, parent, false);
                }

                TextView numberView = inflatedView.findViewById(R.id.list_number);

                Display currentDisplay = numbersList.get(position);

                numberView.setText(currentDisplay.getmNumber());

                TextView squareView = inflatedView.findViewById(R.id.list_square);

                squareView.setText(currentDisplay.getmSquare());

                return inflatedView;
            }
        }

        listView.setAdapter(new displayAdapter());
    }
}
