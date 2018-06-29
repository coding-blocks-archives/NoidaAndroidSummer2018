package com.example.robin.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bn;
    EditText edt1;
    WebView wv;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = findViewById(R.id.submit);
        edt1 = findViewById(R.id.edt1);
        wv = findViewById(R.id.webview);
        final Activity activity = this;
        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000);
            }
        });

        wv.setWebViewClient(new WebClient());
        WebSettings set = wv.getSettings();
        set.setBuiltInZoomControls(true);
        //wv.loadUrl("https://www.google.com");
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = edt1.getText().toString();
                wv.getSettings().setLoadsImagesAutomatically(true);
                wv.loadUrl(s);

            }
        });
        Intent i = getIntent();
        if(i!=null){
            if(Intent.ACTION_MAIN.equals(i.getAction())){

            }else{
                edt1.setText(i.getDataString());
                wv.loadUrl(i.getDataString());
            }
        }
    }
    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e("TAG", "url:" + url + "");
            view.loadUrl(url);
            return true;
        }
    }
}
