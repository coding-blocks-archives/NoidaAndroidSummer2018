package com.codingblocks.postsfetch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

//https://andfun-weather.udacity.com/weather
//https://jsonformatter.curiousconcept.com/
//https://openweathermap.org/api

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvResult);

        MyNetworkTask myNetworkTask = new MyNetworkTask();
        myNetworkTask.execute("https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6ea5b3ad9ba04139b8601638cc7a61f2");

    }


    public Result convertJsonToResponse(String json) {

        try {
            JSONObject jsonObject = new JSONObject(json);

            String status = jsonObject.getString("status");
            Integer totalResults = jsonObject.getInt("totalResults");

            JSONArray jsonArray = jsonObject.getJSONArray("articles");

            ArrayList<Article> articleArrayList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject articleObject = jsonArray.getJSONObject(i);
                String author = articleObject.getString("author");
                String title = articleObject.getString("title");
                String desc = articleObject.getString("description");
                String url = articleObject.getString("url");
                String imageUrl = articleObject.getString("urlToImage");
                String published = articleObject.getString("publishedAt");

                JSONObject source = articleObject.getJSONObject("source");
                String id = source.getString("id");
                String name = source.getString("name");
                Source sourceJava = new Source(id,name);

                Article article = new Article(author,title,desc,url,imageUrl,published,sourceJava);

                articleArrayList.add(article);
            }

            Result result = new Result(status,totalResults,articleArrayList);

            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    class MyNetworkTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String string = strings[0];

            try {
                URL url = new URL(string);

                //Open a new Connection using the URL
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                //Store the contents of the web-page as a Stream
                InputStream inputStream = httpURLConnection.getInputStream();

                //Create a Scanner from the Stream to get data in a human readable form
                Scanner scanner = new Scanner(inputStream);

                //Tells the scanner to read the file from the very start to the very end of file
                scanner.useDelimiter("\\A");

                String result = "";

                if (scanner.hasNext()) {
                    //Read the entire content of scanner in a go, otherwise scanner reads individual bytes one by one
                    result = scanner.next();
                }
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
            Result result = convertJsonToResponse(s);

            ArrayList<Article> articleArrayList = result.getArticles();

//
//            result.getStatus();
//            result.getTotalResults();
        }
    }

}
