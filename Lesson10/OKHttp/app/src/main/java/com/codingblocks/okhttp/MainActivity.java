package com.codingblocks.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    public static final MediaType JSON
            = MediaType.parse("application/json");

    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFetch = findViewById(R.id.btnFetch);
        textView = findViewById(R.id.tvResponse);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                http://ptsv2.com/
//                String url = "http://ptsv2.com/t/6vsr1-1530610634/post";
                String url = "https://api.github.com/search/users?q=harshit";
                makeNetworkCall(url);
            }
        });
    }

    private void makeNetworkCall(String url) {
        //Make the network call here
        OkHttpClient okHttpClient = new OkHttpClient();

//        RequestBody body = RequestBody.create(JSON, );

        final Request request = new Request.Builder()
                .url(url)
//                .post(body)
                .build();

//        try {
//            Response response = okHttpClient.newCall(request).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //If the request was unsuccessful

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //If the request was successful
//                call.execute();
//                call.request().url();

                //string() != toString()

                //Response implements a closeable, so you can read from it only once!
//                Log.e("TAG", "onResponse: " + response.body().string());
                final String result = response.body().string();

                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(result);
                    }
                });

            }
        });

    }

}
