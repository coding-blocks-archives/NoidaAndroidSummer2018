package com.codingblocks.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

        SharedPreferences sharedPreferences = getSharedPreferences("my_shared_prefs",
                MODE_PRIVATE);

        count = sharedPreferences.getInt("COUNT", 0);
        tvName.setText(String.valueOf(count));

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tvName.setText(String.valueOf(count));
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        //Store the current count to shared preferences

        SharedPreferences sharedPreferences = getSharedPreferences("my_shared_prefs",
                MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("COUNT", count);

        editor.apply();
    }
}
