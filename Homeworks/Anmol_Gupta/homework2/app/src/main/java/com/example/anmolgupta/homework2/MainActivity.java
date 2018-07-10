package com.example.anmolgupta.homework2;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends Activity {

    WebView web1;
    EditText ed1;
    Button bt1;
    String Address;
    String add;
    ProgressBar pbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web1 = (WebView)findViewById(R.id.webView1);
        ed1 = (EditText)findViewById(R.id.editText1);
        bt1 = (Button)findViewById(R.id.button1);
        pbar = (ProgressBar)findViewById(R.id.progressBar1);
        pbar.setVisibility(View.GONE);

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Address = "http://" + ed1.getText().toString();
                WebSettings webSetting = web1.getSettings();
                webSetting.setBuiltInZoomControls(true);
                webSetting.setJavaScriptEnabled(true);

                web1.setWebViewClient(new WebViewClient());

                web1.loadUrl(Address);

            }
        });
    }

    public class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            pbar.setVisibility(View.VISIBLE);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            pbar.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web1.canGoBack()) {
            web1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
