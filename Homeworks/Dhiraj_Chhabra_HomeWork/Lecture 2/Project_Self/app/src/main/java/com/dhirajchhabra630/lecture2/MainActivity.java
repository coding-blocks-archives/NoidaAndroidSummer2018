package com.dhirajchhabra630.lecture2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private int quantity = 0;
    Button plusButton;
    Button minusButton;
    Button restButton;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");
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
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    public void increment(View view) {
        quantity++;
        Log.e(TAG, "" + quantity);
        display = findViewById(R.id.display_view);
        display.setText("" + quantity);
    }

    public void decrement(View view) {
        if(quantity > 0) {
            quantity--;
        }
        Log.e(TAG, "" + quantity);
        display = findViewById(R.id.display_view);
        display.setText("" + quantity);
    }

    public void reset(View view) {
        quantity = 0;
        Log.e(TAG, "" + quantity);
        display = findViewById(R.id.display_view);
        display.setText("" + quantity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
