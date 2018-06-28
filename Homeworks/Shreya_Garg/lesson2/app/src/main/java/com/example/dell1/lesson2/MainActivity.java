package com.example.dell1.lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity";
    int num=0;
    TextView Ctv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ctv=findViewById(R.id.textview1);
        Log.e(TAG,"onCreate:");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"onPause:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy:");
    }

    public void increment(View view) {
        num++;
        Ctv.setText(""+num);
        Log.e(TAG,"increment" + num);
    }

    public void decrement(View view) {
        if(num>0)
        num--;
        Ctv.setText(String.valueOf(num));
        Log.e(TAG,"decrement" + num);

    }
    public void reset(View view){
        num=0;
        Ctv.setText(String.valueOf(num));
        Log.e(TAG,"reset" + num);

    }
}
