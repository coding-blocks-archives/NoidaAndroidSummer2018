package com.codingblocks.apigithbuserokhttp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailAct extends AppCompatActivity{

    ImageView imageView;
    TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Intent i=getIntent();
        String url2=i.getStringExtra("url");

        Log.e("TAG","URL2"+url2);
        makeNetworkCall1(url2);

    }

    private void makeNetworkCall1(String url) {

        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result=response.body().string();
                Gson gson=new Gson();

                final Details details=gson.fromJson(result,Details.class);

                (DetailAct.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        imageView=findViewById(R.id.detailImg);
                        tv1=findViewById(R.id.tvView_login);
                        tv2=findViewById(R.id.detailHtmlurl);
                        tv3=findViewById(R.id.detailCompany);
                        tv4=findViewById(R.id.detailLocation);

                        Picasso.get().load(Uri.parse(details.getAvatarUrl())).into(imageView);
                        tv1.setText(details.getName());
                        tv2.setText(details.getHtmlUrl());
                        tv3.setText(details.getCompany());
                        tv4.setText(details.getLocation());

                    }
                });

            }
        });

    }
}
