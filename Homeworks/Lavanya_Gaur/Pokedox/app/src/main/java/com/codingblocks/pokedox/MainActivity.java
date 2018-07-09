package com.codingblocks.pokedox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView nametv ;
    ImageView imageView;
    Button info;
    Button back;
    Button next;

    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG","_______onCreate");
        editText=findViewById(R.id.CurrentNumber);  //number of poke
        Button  btnOK=findViewById(R.id.btnOk);
        info=findViewById(R.id.btnInfo);
        back=findViewById(R.id.btnBack);
        next=findViewById(R.id.btnNext);
        nametv=findViewById(R.id.mainName);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://pokeapi.co/api/v2/pokemon/"+editText.getText().toString()+"/";
                makeNetworkCall(url);

//                Log.e("TAG","url : "+url);
            }
        });

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.UK);
                }

            }
        });

    }

    @Override
    protected void onPause() {
        if(t1!=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }





    private void makeNetworkCall(final String url) {
//        Log.e("----------", "makeNetworkCall: "+url );
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .build();
//        Log.e("----------", "88888" );

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //
                Log.e("--------", "onFailure: " + e.getMessage() );
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result= response.body().string();

                Log.e("TAG","result : "+ result);

                Gson gson=new Gson();
                final APIresponse apIresponse=gson.fromJson(result,APIresponse.class);

                Log.e("----------", "gson  " );
                Log.e("         ","here :"+apIresponse.getSprites().getBackDefault());

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        imageView=findViewById(R.id.mainImage);
                        nametv.setText(apIresponse.getName());

                        nametv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String toSpeak=nametv.getText().toString();
//                Toast.makeText(getApplicationContext(),toSpeak,Toast.LENGTH_SHORT).show();
                                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
                            }
                        });

                        Picasso.get().load(Uri.parse(apIresponse.getSprites().getBackDefault())).into(imageView);
                        Animation zoomanimation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom);
                        imageView.startAnimation(zoomanimation);

                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(Integer.valueOf(editText.getText().toString())==1){

                                    Toast.makeText(MainActivity.this,"Oops!! No Pokemon is there",Toast.LENGTH_SHORT).show();
                                    makeNetworkCall("https://pokeapi.co/api/v2/pokemon/1"+"/");

                                }

                               else {
                                    Integer f = Integer.valueOf(editText.getText().toString()) - 1;
                                    editText.setText(f.toString());
                                    makeNetworkCall("https://pokeapi.co/api/v2/pokemon/" + f.toString() + "/");

                                    Log.e("TAG", "previous url : " + "https://pokeapi.co/api/v2/pokemon/" + f.toString() + "/");
                                } }
                        });

                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Integer f=Integer.valueOf(editText.getText().toString())+1;
                                editText.setText(f.toString());
                                makeNetworkCall("https://pokeapi.co/api/v2/pokemon/"+f.toString()+"/");

                            }
                        });


                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getBaseContext(),DetailAct.class);

                                i.putExtra("id",editText.getText().toString());
//                                i.putExtra("weight",apIresponse.getWeight());
//                                i.putExtra("height",apIresponse.getHeight());
//                                i.putExtra("baseExp",apIresponse.getBaseExp());
//                                i.putExtra("KEY",apIresponse);

//                                for(int j=0;j<apIresponse.getAbilities().size();j++){
//                                   if(j==1)
//                                    i.putExtra("slot",apIresponse.getAbilities().get(j).getSlot());
//                                    i.putExtra("abilityname",apIresponse.getAbilities().get(j).getAbility().getName());
//
//                                }

                                i.setData(Uri.parse(url));

                                MainActivity.this.startActivity(i);
                                Log.e("TAG"," ---****--");

                            }
                        });

                    }
                });


            }
        });



    }
}
