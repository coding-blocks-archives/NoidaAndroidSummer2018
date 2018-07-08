package com.example.ashu.webbrowser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WebView webView = new WebView(MainActivity.this);
        setContentView(webView);
        final EditText editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.idBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this,webView.getClass());

                intent.setData(Uri.parse(s));
                startActivity(intent);

            }
        });


    }
}
