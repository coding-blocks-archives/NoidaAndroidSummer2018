package com.example.shabnamkhatun.githubapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit=findViewById(R.id.edit);
        Button btnFetch=findViewById(R.id.btnFetch);




        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String url="https://api.github.com/search/users?q=";
               String name=edit.getText().toString();


                makeNetworkCall(url+name);



            }

        });

    }


    private void makeNetworkCall(final String url){
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();



               final Gson gson=new Gson();
                final APIResponse apiResponse=gson.fromJson(result,APIResponse.class);

                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView=findViewById(R.id.rec);

                        ArrayList<User>users=apiResponse.getItems();
                        LinearLayoutManager llm=new LinearLayoutManager(getBaseContext());
                        recyclerView.setLayoutManager(llm);
                        recyclerView.setAdapter(new MyAdapter(getBaseContext(),users));


                    }
                });



            }
        });


    }
}
