package com.example.dell.pokedex;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

String TAG="MainActivity";
    EditText text;
    Button btn;
    TextView text1;
    ImageView image;
    Button leftbtn;
    Button rigbtn,infobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.edit);
        btn = findViewById(R.id.searchbtn);
        text1=findViewById(R.id.text);
        leftbtn=findViewById(R.id.left);
        rigbtn=findViewById(R.id.right);
        infobtn=findViewById(R.id.get);
        image=findViewById(R.id.image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=text.getText().toString();
                int b= Integer.parseInt(a);
                String url = "https://pokeapi.co/api/v2/pokemon/"+b ;

                makeNetworkCall(url);

            }

        });
        leftbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        String a=text.getText().toString();
                        int b= Integer.parseInt(a);
                        if(b>1)
                        b--;
                        String url = "https://pokeapi.co/api/v2/pokemon/"+b ;
                         text.setText(""+b);
                        makeNetworkCall(url);



            }
        });
        rigbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=text.getText().toString();
                int b= Integer.parseInt(a);
                    b++;
                text.setText(""+b);

                String url = "https://pokeapi.co/api/v2/pokemon/"+b ;
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
                final APIresponse apiResponse = gson.fromJson(result, APIresponse.class);


                (MainActivity.this).runOnUiThread(new Runnable() {

                    @Override

                    public void run() {

                            sprites ap=apiResponse.getSprites();
                            ArrayList<abilities> user=apiResponse.getAbilities();
            //            Log.e(TAG, "run: "+user.get(b) );
                        abilities a=user.get(0);

                            final String name = apiResponse.getName();
                            final int height = apiResponse.getHeight();
                            final int weight = apiResponse.getWeight();
                       //     n mn=a.getMn();

                        ability as =a.getAbility();
                            final String s=as.getName();
                            final String d=as.getUrl();
                        //  String firstUserToJson = gson.toJson(firstUser);
                           final String imag=ap.getFront_default();

                           text1.setText(name);
                           Picasso.get().load(ap.getFront_default()).into(image);

                           final ArrayList<moves> m=apiResponse.getMoves();
                           for(int i=0;i< m.size();i++) {
                               moves q=m.get(i);
                               move w = q.getMove();
                               final String[] movename=new String[i];
                               movename[i]= w.getName();
                           }
                           infobtn.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View v) {
                                   Intent intent=new Intent(getBaseContext(),detail.class);
                                   intent.putExtra("KEY0",imag);
                                   intent.putExtra("KEY",name);
                                   intent.putExtra("KEY1",height);
                                   intent.putExtra("KEY2",weight);
                                  intent.putExtra("KEY3",s);
                                   intent.putExtra("KEY4",d);
                                   for(int i=0;i<m.size();i++)
                               intent.putExtra("KEY5",apiResponse.getMoves().get(i).getMove().getName());
                                   startActivity(intent);

                               }
                           });
                    }

                });


            }

        });
    }

}
