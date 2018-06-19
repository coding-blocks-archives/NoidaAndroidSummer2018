package com.codingblocks.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.idBtn);
        final EditText editText = findViewById(R.id.etMainActivity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start second activity
                String enteredValue = editText.getText().toString();
                Intent intent = new Intent(getBaseContext(),SecondActivity.class);

                intent.putExtra("KEY",enteredValue);
                intent.putExtra("KEY2",15);
                startActivity(intent);
//                finish(); kill the activity
            }
        });

    }
}
