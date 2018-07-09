package com.codingblocks.pokedox;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity1 extends AppCompatActivity {
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ImageView imageView=findViewById(R.id.splashImg);

        TextView textView=findViewById(R.id.pokego);
        Animation zoomanimation= AnimationUtils.loadAnimation(this,R.anim.zoompoke);
        textView.startAnimation(zoomanimation);
        LinearLayout ll=findViewById(R.id.ll);
//        ImageView bl=findViewById(R.id.pokebl);
//        Animation zoomanimation1= AnimationUtils.loadAnimation(this,R.anim.zoompoke);
//        bl.startAnimation(zoomanimation1);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animation);
        Thread timer=new Thread(){


            @Override
            public void run() {

                try {
                    sleep(8000);
                    Intent intent=new Intent(getApplicationContext(),Splashscreen.class);
                    startActivity(intent);
                    finish();
                    super.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        timer.start();


        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.UK);
                }

            }
        });

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak="Welcome to Pokedox";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
            }
        });





    }


}
