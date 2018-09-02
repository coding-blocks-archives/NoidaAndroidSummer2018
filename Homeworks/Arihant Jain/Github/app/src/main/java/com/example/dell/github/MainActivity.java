package com.example.dell.github;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


import java.io.IOException;

import java.util.ArrayList;


import okhttp3.Call;

import okhttp3.Callback;

import okhttp3.MediaType;

import okhttp3.OkHttpClient;

import okhttp3.Request;

import okhttp3.Response;


public class MainActivity extends AppCompatActivity {


//    https://pokeapi.co/


    public static final MediaType JSON

            = MediaType.parse("application/json");


    EditText text;
    Button btn;
    RecyclerView RecView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        text = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);
        RecView = findViewById(R.id.rec);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        RecView.setLayoutManager(llm);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

//                http://ptsv2.com/

//                String url = "http://ptsv2.com/t/6vsr1-1530610634/post";
                String S = text.getText().toString();
                String url = "https://api.github.com/search/users?q=" + S;

                makeNetworkCall(url);

            }

        });

    }


    private void makeNetworkCall(final String url) {

        //Make the network call here

        OkHttpClient okHttpClient = new OkHttpClient();


//        RequestBody body = RequestBody.create(JSON,"{ hello : world }");


        final Request request = new Request.Builder()

                .url(url)

//                .post(body)

                .build();


//        try {

//            APIResponse response = okHttpClient.newCall(request).execute();

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


                //APIResponse implements a closeable, so you can read from it only once!

//                Log.e("TAG", "onResponse: " + response.body().string());

                final String result = response.body().string();


                final Gson gson = new Gson();

                final APIresponse apiResponse = gson.fromJson(result, APIresponse.class);


                (MainActivity.this).runOnUiThread(new Runnable() {

                    @Override

                    public void run() {


                        ArrayList<User> users = apiResponse.getItems();


                        User firstUser = users.get(0);

                        String loginOfFirstUser = firstUser.getLogin();


//                        String firstUserToJson = gson.toJson(firstUser);
                        //textView.setText(loginOfFirstUser);

                        MAdapter adapter = new MAdapter( users);
                        RecView.setAdapter(adapter);
                    }

                });


            }

        });
    }

    class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {

        ArrayList<User> articleArrayList;

        public MAdapter(ArrayList<User> articleArrayList) {
            this.articleArrayList = articleArrayList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView = li.inflate(R.layout.iten, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            for (int i = 0; i < articleArrayList.size(); i++) {
                User firstUser = articleArrayList.get(position);

                holder.title.setText(firstUser.getLogin());
                Picasso.get().load(firstUser.getAvatarUrl()).into(holder.image);
                }
            }


        @Override
        public int getItemCount() {
            return articleArrayList.size();
        }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagedetail);
            title = itemView.findViewById(R.id.textdetail);
        }
       }
     }
}


