package com.codingblocks.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    int count = 0;
    TextView counterText;

    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"onCreate was called");
        counterText = findViewById(R.id.countTv);
//        Button incrementBtn = findViewById(R.id.btnPlus);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    public void decrement(View view) {
        if (count >0){
            count--;
        }
        counterText.setText(String.valueOf(count));
        Log.e(TAG, "decrement: " +count);
    }

    public void increment(View view) {
        count++;
        Log.e(TAG, "increment: " + count );
        counterText.setText(String.valueOf(count));
    }

    public void reset(View view) {
        count = 0;
        counterText.setText(String.valueOf(count));
    }

    public void compute(View view) {
        switch (view.getId()){
            case  R.id.btnMinus :
                //Do something
                break;
            case R.id.btnPlus :
                //Do something
                break;
            case R.id.btnReset :
                //Do something
                break;
        }

    }
}
