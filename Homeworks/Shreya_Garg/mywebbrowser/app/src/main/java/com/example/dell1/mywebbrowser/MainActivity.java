package com.example.dell1.mywebbrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

     EditText e1;
    Button bt1;
     WebView wv;
     String url;
     int linkpresent=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         e1=findViewById(R.id.et1);
         bt1=findViewById(R.id.bt1);
         wv=findViewById(R.id.web1);
         Intent intent=getIntent();
         if(intent.getData()!=null){
             url=intent.getData().toString();
             seturl(url);
         }

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                url=e1.getText().toString();
                if(linkpresent==0){
                    url="https://www." + url;
                    if(!("https://www.".equals(url))) {
                        seturl(url);
                        linkpresent++;
                    }
                }
                else{
                    if(url.contains("https://www.")){
                    seturl(url);
                }
                else{
                    url="https://www."+url;
                    seturl(url);
                }}
            }
        });
    }
    public class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public void seturl(String url){
        e1.setText(url);
        wv.setWebViewClient(new MyBrowser());
        Log.e("MainActivity","here:-");
        wv.loadUrl(url);
    }
}

