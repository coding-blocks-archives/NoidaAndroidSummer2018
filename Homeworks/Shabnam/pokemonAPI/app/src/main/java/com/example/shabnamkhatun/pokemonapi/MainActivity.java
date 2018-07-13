package com.example.shabnamkhatun.pokemonapi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {

    int count = 0;
    String url = "https://pokeapi.co/api/v2/pokemon/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pre = findViewById(R.id.prev);
        TextView nxt = findViewById(R.id.nxt);
        Button btn = findViewById(R.id.tvbtn);
        final EditText editText = findViewById(R.id.num);
        pre.setTypeface(null, Typeface.BOLD);
        nxt.setTypeface(null, Typeface.BOLD);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editText.getText().toString();
                makeNetworkCall(url + number + "/");
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                count++;
                int num = Integer.parseInt(editText.getText().toString());
                int finalNum = num + count;
                editText.setText(finalNum + "");
                makeNetworkCall(url + finalNum + "/");
            }
        });

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                count--;
                int num = Integer.parseInt(editText.getText().toString());
                int finalNum = num + count;
                editText.setText(finalNum + "");
                makeNetworkCall(url + finalNum + "/");
            }
        });

    }

    private void makeNetworkCall(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("--------", "makeNetworkCall: " + "failure");
                Log.e("---------", "onFailure: "+e );
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("------------", "onResponse: "+"Ok here" );
                final String result = response.body().string();
                Log.e("=-----------", "onResponse: "+result );
                final Gson gson = new Gson();
                final Pokemon pokemon = gson.fromJson(result, Pokemon.class);

                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imageView = findViewById(R.id.image);
                        TextView textView = findViewById(R.id.name);
                        Button info=findViewById(R.id.info);
                        textView.setText(pokemon.getName());
                        Picasso.get().load(pokemon.getSprites().getFront_default()).into(imageView);

                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent=new Intent(MainActivity.this,Mainactivity2.class);
                                intent.putExtra("Ability",pokemon.getAbilities());
                                intent.putExtra("types",pokemon.getTypes());
                                intent.putExtra("weight",pokemon.getWeight());
                                intent.putExtra("height",pokemon.getHeight());
                                intent.putExtra("id",pokemon.getId());
                                intent.putExtra("order",pokemon.getOrder());
                                intent.putExtra("baseexperience",pokemon.getBaseexperience());

                                startActivity(intent);

                            }
                        });


                    }
                });


            }
        });

    }
}


