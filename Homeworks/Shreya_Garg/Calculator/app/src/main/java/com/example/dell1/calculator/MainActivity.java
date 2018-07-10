package com.example.dell1.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    int n1 = 0;
    int n2 = 0;
    TextView tvans;

    EditText et1, et2;

    public static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvans = findViewById(R.id.answer);
        et1 = findViewById(R.id.inputbox1);
        et2 = findViewById(R.id.inputbox2);
        Log.e(TAG, "onCreate:");
    }

//    public void enter1(View view) {
//        EditText et1=findViewById(R.id.inputbox1);
//        String input=et1.getText().toString();
//                Log.e(TAG,"enter1:" + input);
//        //n1=String.valueOf(input);
//    }
//    public void enter2(View view){
//        EditText et2=findViewById(R.id.inputbox2);
//        String input=et2.getText().toString();
//        //n2=Integer.valueOf(input);
//        Log.e(TAG,"enter2:" + input);
//    }

    public void compute(View view) {

        n1=Integer.valueOf(et1.getText().toString());
        n2=Integer.valueOf(et2.getText().toString());

        Log.e(TAG, "compute: " + et1.getText().toString() + " " + n1);
        Log.e(TAG, "compute: " + et2.getText().toString() + " " + n2);


        switch (view.getId()) {
            case R.id.add: {
                int ans = n1 + n2;
                tvans.setText(String.valueOf(ans));
                Log.e(TAG, "add:");

                break;
            }
            case R.id.minus: {
                int ans = n1 - n2;
                tvans.setText(String.valueOf(ans));
                break;
            }
            case R.id.multiply: {
                int ans = n1 * n2;
                tvans.setText(String.valueOf(ans));
                break;
            }
            case R.id.divide: {
                if (n2 != 0) {
                    int ans = n1 / n2;
                    tvans.setText(String.valueOf(ans));
                } else
                    Log.e(TAG, "error");
                break;
            }

            case R.id.reset: {
                n1 = 0;
                n2 = 0;
                tvans.setText(String.valueOf(n1));
            }

        }

    }
}
