package com.codingblocks.webbrowser;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;
    Button button;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        webView = findViewById(R.id.webView);
//        back =findViewById(R.id.item_back);
//        forward =findViewById(R.id.item_forward);
//        home =findViewById(R.id.item_home);



        Intent i = getIntent();
        if (i.getData() != null) {
            URL  = i.getData().toString();
            loadWebPage(URL);

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                URL = editText.getText().toString();

                    URL = "https://www." + URL;

                    if (!("https://wwww.".equals(URL))) {


                        loadWebPage(URL);

                    }

            }
        });

    }

    public void loadWebPage(String URL) {
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        if(URL.contains("https://")||(URL.contains("https://www."))||URL.contains("http://")||URL.contains("http://www."))
            webView.loadUrl(URL);

        else
            URL = "https://"+URL;

       editText.setText(URL);


        webView.loadUrl(URL);
    }


}





