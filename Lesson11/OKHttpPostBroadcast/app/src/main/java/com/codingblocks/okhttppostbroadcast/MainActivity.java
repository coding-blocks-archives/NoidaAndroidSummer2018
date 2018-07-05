package com.codingblocks.okhttppostbroadcast;

import android.content.Intent;
import android.net.Uri;
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
        Button btnPost =findViewById(R.id.btnPost);

        final EditText userEmail  = findViewById(R.id.etEmail), userPassword = findViewById(R.id.etPassword);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(userEmail.getText().toString(), userPassword.getText().toString());
                //Start the broadcast with some data
                Intent i = new Intent(getBaseContext(),MyPostReceiver.class);

                i.putExtra("KEY",user);

                sendBroadcast(i);
            }
        });

    }
}
