package com.chirag_bhardwaj.mywebbrowser;

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

    EditText editText;
    Button button;
    WebView webView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editText=findViewById(R.id.et);
        button=findViewById(R.id.bt);
        webView=findViewById(R.id.web);

        Intent intent=getIntent();
        if(intent.getData()!=null){
            url=intent.getData().toString();
            seturl(url);
        }

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                url=editText.getText().toString();
                seturl(url);
        }});
    }
    public class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
    public void seturl(String url){
        editText.setText(url);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl(url);
    }
}
