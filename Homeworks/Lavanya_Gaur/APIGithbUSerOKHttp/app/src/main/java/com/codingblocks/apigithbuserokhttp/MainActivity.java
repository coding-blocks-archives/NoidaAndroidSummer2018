package com.codingblocks.apigithbuserokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.et);
        Button btnFetch = findViewById(R.id.btnFetch);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.github.com/search/users?q="+editText.getText().toString();
                makeNetworkCall(url);
            }
        });
    }

    private void makeNetworkCall(final String url) {
        //Make the network call here
        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //If the request was unsuccessful
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                final Gson gson = new Gson();
                final APIResponse apiResponse = gson.fromJson(result, APIResponse.class);
                //result is the json... , .class is  object of which class we want to get
                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        ArrayList<User> users = apiResponse.getItems();
                        RecyclerView recyclerView=findViewById(R.id.rvUsers);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        recyclerView.setAdapter(new APIAdapter(users,MainActivity.this));





                    }
                });

            }
        });}}


