package com.example.dell1.lesson3selfexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.b1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start second activity here
                //ab yaha we cannot do this secondactivity s=new secondactivity()....this is wrong
                //instead we need to create an intent here to switch from one activity to another
                Intent intent=new Intent(MainActivity.this,secondactivity.class); //
                //we may also write getBaseContext()
                startActivity(intent);
                //finish(); this is done if we want ki button click ke baad second activity mein jaye and then
                //jab waha se back press ho then wapis mainactivity na khule

            }
        });
    }
}
