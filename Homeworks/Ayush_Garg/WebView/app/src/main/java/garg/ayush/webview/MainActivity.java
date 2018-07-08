package garg.ayush.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WebView webView = findViewById(R.id.webview);
        final EditText editText=findViewById(R.id.text);
        Button btn = findViewById(R.id.idbtn);

        Intent i =getIntent();
        if(i.getData()!=null){
            String URL =i.getData().toString();
            editText.setText(URL);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(URL);
        }
        //use .contains to check if(https is already written or not;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.setWebViewClient(new WebViewClient());
                String URL=editText.getText().toString();
                if(URL.startsWith("http")||URL.startsWith("https"))
                    webView.loadUrl(URL);
                else {
                    URL = "https://www." + URL;
                    webView.loadUrl(URL);
                }
            }
        });

    }

//    @Override
//    public void onBackPressed() {
//        if(webView.canGoBack()){
//            webView.goBack();
//        }else {
//            super.onBackPressed();
//        }
//    }
}
