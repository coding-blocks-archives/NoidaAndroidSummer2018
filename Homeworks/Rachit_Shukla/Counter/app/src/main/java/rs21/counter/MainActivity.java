package rs21.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int count = 0;
    public static final String TAG = "MainActivity";
    TextView countText;
    Button incrementButton;
    Button decrementButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countText = findViewById(R.id.textView1);
        incrementButton = findViewById(R.id.inc);
        decrementButton = findViewById(R.id.dec);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart was called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart was called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume was called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy was called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause was called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop was called");

    }

    public void decrement(View view) {
        count--;
        Log.e(TAG, ""+count);
        countText.setText("" + count);
    }

    public void increment(View view) {
        count++;
        Log.e(TAG, ""+count);
        countText.setText( "" + count);
    }

    public void reset(View view) {
        count = 0;
        Log.e(TAG, ""+count);
        countText.setText("" + count);
    }
}
