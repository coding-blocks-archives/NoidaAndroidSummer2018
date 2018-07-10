package garg.sarthik.news;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

        MyNews myNews = new MyNews();
        myNews.execute("https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6ea5b3ad9ba04139b8601638cc7a61f2");
    }

    private class MyNews extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            String str = strings[0];

            try {
                URL url = new URL(str);

              //  Log.e(str, "doInBackground:"  );

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();

                Scanner scanner = new Scanner(inputStream);

                scanner.useDelimiter("\\A");

                String result = "";

                if(scanner.hasNext())
                {
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

            News news = convertJSON(s);

            RecyclerView rvNews = findViewById(R.id.rvNews);
            rvNews.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            NewsAdaptor newsAdaptor = new NewsAdaptor(MainActivity.this,news.getArticlesArrayList());
            rvNews.setAdapter(newsAdaptor);
        }


    }

    private News convertJSON(String s) {

        try {
            JSONObject jsonObject = new JSONObject(s);

            JSONArray jsonArray = jsonObject.getJSONArray("articles");

            ArrayList<Articles> articlesArrayList = new ArrayList<>();

            for( int i = 0 ; i < jsonArray.length() ; i++)
            {
                JSONObject articleObject = jsonArray.getJSONObject(i);

                String author = articleObject.getString("author");
                String title = articleObject.getString("title");
                String moreURL = articleObject.getString("url");
                String imageURL = articleObject.getString("urlToImage");
                String publishedAt = articleObject.getString("publishedAt");

                articlesArrayList.add(new Articles(author,title,moreURL,imageURL,publishedAt));
            }

            News news = new News(articlesArrayList);

            return news;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
