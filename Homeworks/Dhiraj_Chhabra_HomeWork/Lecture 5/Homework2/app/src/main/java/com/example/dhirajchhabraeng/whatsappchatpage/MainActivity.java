package com.example.dhirajchhabraeng.whatsappchatpage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    private TextView chatText;
    private RecyclerView recyclerView;
    private FloatingActionButton newChatButton;
    private ArrayList<Chat> chatsList = new ArrayList<Chat>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String urlString = "https://picsum.photos/100/?random";

        chatsList.add(new Chat(urlString, "Shitu di", "21:14", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Vaishali", "21:15", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Dushyant Jiju", "21:16", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Sanket", "21:17", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Harshit Dwivedi Sir", "21:18", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "CB-N Android AppDev Jun18", "21:19", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Prateek Bhatia", "21:10", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Nand Lal Dtc", "21:11", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Damanpreet Singh", "21:13", this.getResources().getDrawable(R.drawable.ic_check)));
        chatsList.add(new Chat(urlString, "Development", "21:15", this.getResources().getDrawable(R.drawable.ic_check)));

        ChatsAdapter chatsAdapter = new ChatsAdapter(MainActivity.this, chatsList);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(chatsAdapter);
    }
}
