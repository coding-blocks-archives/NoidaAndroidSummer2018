package com.codingblocks.pokedox;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_act);

        final Intent intent=getIntent();


//        APIresponse apIresponse=intent.getParcelableExtra("KEY");


        final String id=intent.getStringExtra("id");
//        String weight=intent.getStringExtra("weight");
//        String height=intent.getStringExtra("height");
//        String baseexp=intent.getStringExtra("baseExp");






//        for(int j=0;j<apIresponse.getAbilities().size();j++){
//          if(j==0) {
//              String slot = intent.getStringExtra("slot");
//              String abnm = intent.getStringExtra("abilityname");
//              tvT1.setText("\tslot :  " + slot + "\nability :  " + abnm);
//          }
//           if(j==1){
//              String slot = intent.getStringExtra("slot");
//              String abnm = intent.getStringExtra("abilityname");
//              tvT2.setText("\tslot :  " + slot + "\nability :  " + abnm);
//          }
//        }

        final String url=intent.getData().toString();
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
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
                DetailAct.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        TextView tvN=findViewById(R.id.nameid);
                        TextView tvW=findViewById(R.id.tvWeight);
                        TextView tvH=findViewById(R.id.tvHeight);
                        TextView tvB=findViewById(R.id.tvBaseExper);
                        TextView tvT1=findViewById(R.id.tvAbility1);

                        TextView tvT2=findViewById(R.id.tvAbility2);

                        tvT1.setText("\tSlot : Ability\n\n\t");
                        tvT2.setText("\tTypes : \n\n\t");

                    String weight=apIresponse.getWeight();
                   String height=apIresponse.getHeight();
                    String baseexp=apIresponse.getBaseExp();
                    TextView textView=findViewById(R.id.here);
                    textView.setVisibility(View.GONE);
                        for(int j=0;j<apIresponse.getAbilities().size();j++) {
                          Integer slot=  apIresponse.getAbilities().get(j).getSlot();
                          String abname=apIresponse.getAbilities().get(j).getAbility().getName();
                          tvT1.append("* "+slot.toString()+" : "+abname+"\n\t");

                        }

                        for(int j=0;j<apIresponse.getTypes().size();j++){
                            String name=apIresponse.getTypes().get(j).getType().getName();
                            tvT2.append("* "+name+"\n\t");
                        }


                        tvN.setText("\tID :  "+id);
                        tvW.setText("\tWeight :  "+weight);
                        tvH.setText("\tHeight :  "+height);
                        tvB.setText("\tBase-exp :  "+baseexp);
//        tvT.setText("\tTypes :  "+typ);


//                                for(int j=0;j<apIresponse.getAbilities().size();j++){
//                                   if(j==1)
//                                    i.putExtra("slot",apIresponse.getAbilities().get(j).getSlot());
//                                    i.putExtra("abilityname",apIresponse.getAbilities().get(j).getAbility().getName());
//
//                                }

                                Log.e("TAG"," ---****--");

                            }
                        });

                    }
                });


            }









//        TextView tvN=findViewById(R.id.nameid);
//        TextView tvW=findViewById(R.id.tvWeight);
//        TextView tvH=findViewById(R.id.tvHeight);
//        TextView tvB=findViewById(R.id.tvBaseExper);
//
//        tvN.setText("\tID :  "+id);
//        tvW.setText("\tWeight :  "+weight);
//        tvH.setText("\tHeight :  "+height);
//        tvB.setText("\tBase experience :  "+baseexp);
////        tvT.setText("\tTypes :  "+typ);


    }



