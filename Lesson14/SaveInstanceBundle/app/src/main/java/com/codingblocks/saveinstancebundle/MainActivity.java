package com.codingblocks.saveinstancebundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCount;
    TextView tvName;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvName);
        btnCount = findViewById(R.id.btnCount);

        if (savedInstanceState != null && savedInstanceState.containsKey("COUNT")) {
            count = savedInstanceState.getInt("COUNT");
            tvName.setText(String.valueOf(count));
        }

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tvName.setText(String.valueOf(count));
            }
        });
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("COUNT", count);
        super.onSaveInstanceState(outState);
    }
}
