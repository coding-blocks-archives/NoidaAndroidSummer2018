package com.example.dell.webview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText texte;
Button bt;
WebView textw;
String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texte = findViewById(R.id.text);
        bt = findViewById(R.id.btn);
        textw = findViewById(R.id.text2);

        Intent intent = getIntent();
        if (intent.getData() != null) {
            url = intent.getData().toString();
            seturl(url);
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = texte.getText().toString();
                //    textw.loadUrl(url);
                seturl(url);

            }
        });
    }

public class MyBrowser extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view,String url) {

        view.loadUrl(url);
        return true;
    }

}

    public void seturl(String url){

        texte.setText(url);
        textw.setWebViewClient(new MyBrowser());
        textw.loadUrl(url);

    }

}
