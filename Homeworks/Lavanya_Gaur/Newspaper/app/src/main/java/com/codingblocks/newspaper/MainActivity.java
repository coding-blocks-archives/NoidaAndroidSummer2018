package com.codingblocks.newspaper;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyNetwork myNetwork=new MyNetwork();
        myNetwork.execute("https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6ea5b3ad9ba04139b8601638cc7a61f2");

    }

    class MyNetwork extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
           String string =strings[0];
            try {
                URL url=new URL(string);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");

                String result = "";
                if (scanner.hasNext()) {
                    result = scanner.next();
                }
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<News> news=parseJson(s);
            NewsAdapter newsAdapter=new NewsAdapter(news,MainActivity.this);
            RecyclerView recyclerView=findViewById(R.id.rvNews);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(newsAdapter);

        }
    }

    public ArrayList<News> parseJson(String json){
        ArrayList<News> newsArrayList=new ArrayList<>();
        try {
            JSONObject root=new JSONObject(json);
            JSONArray articles=root.getJSONArray("articles");
            for(int i=0;i<articles.length();i++){
                JSONObject object=articles.getJSONObject(i);
                String title=object.getString("title");
              //  String desc=object.getString("description");
                String url=object.getString("url");
                String urlToImage=object.getString("urlToImage");
                News row=new News(title,url,urlToImage);
                newsArrayList.add(row);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
return newsArrayList;

    }


}
