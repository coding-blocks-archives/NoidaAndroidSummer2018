package com.example.shabnamkhatun.webbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.browse);

        // web.getSettings().setLoadsImagesAutomatically(true);
        web.loadUrl("http://www.google.com");
        web.getSettings().getJavaScriptEnabled();
        web.setWebViewClient(new WebViewClient());

        Intent intent=getIntent();
        if(intent.getData()!=null)
        { String url=intent.getData().toString();
            web.getSettings().getJavaScriptEnabled();
            web.setWebViewClient(new WebViewClient());
            web.loadUrl(url);

        }
    }

}
