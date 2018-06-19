package com.codingblocks.onclicklistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    EditText btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.idBtn);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText(getBaseContext(),btn.getText().toString(),Toast.LENGTH_LONG);
                t.setGravity(Gravity.START,0,0);
                t.show();
                Log.e(TAG, "onClick: " );
            }
        };

//        MyOnClickListener my = new MyOnClickListener();

        btn.setOnClickListener(onClickListener);
    }
}
