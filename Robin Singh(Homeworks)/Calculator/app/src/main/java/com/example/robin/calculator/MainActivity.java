package com.example.robin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button bn1,bn2,bn3,bn4;
    String edt1,edt2;
    TextView res;
    int a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.edit1);
        ed2 = findViewById(R.id.edit2);
        bn1 = findViewById(R.id.plus);
        bn2 = findViewById(R.id.minus);
        bn3 = findViewById(R.id.multiply);
        bn4 = findViewById(R.id.divide);
        res = findViewById(R.id.result);
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1 = ed1.getText().toString();
                edt2 = ed2.getText().toString();
                a = Integer.valueOf(edt1);
                b = Integer.valueOf(edt2);
                res.setText("Result: " + (a+b));
                ed1.setText("");
                ed2.setText("");
            }
        });
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1 = ed1.getText().toString();
                edt2 = ed2.getText().toString();
                a = Integer.valueOf(edt1);
                b = Integer.valueOf(edt2);
                res.setText("Result: " + (a-b));
                ed1.setText("");
                ed2.setText("");
            }
        });
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1 = ed1.getText().toString();
                edt2 = ed2.getText().toString();
                a = Integer.valueOf(edt1);
                b = Integer.valueOf(edt2);
                res.setText("Result: " + (a*b));
                ed1.setText("");
                ed2.setText("");
            }
        });
        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1 = ed1.getText().toString();
                edt2 = ed2.getText().toString();
                a = Integer.valueOf(edt1);
                b = Integer.valueOf(edt2);
                res.setText("Result: " + (a/b));
                ed1.setText("");
                ed2.setText("");
            }
        });

    }
}
