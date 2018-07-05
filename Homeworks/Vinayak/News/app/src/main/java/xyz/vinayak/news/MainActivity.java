package xyz.vinayak.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkCall networkCall = new NetworkCall();
        networkCall.execute("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=1b2c5e5f4c1d4c0bbbb2c4c121704f47");
    }

    class NetworkCall extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            return fetchDataFromNetwork(url);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            Result result = convertJsonToResult(s);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(new NewsAdapter(getBaseContext(),result.getArticleArrayList()));

        }
    }

    private Result convertJsonToResult(String s) {

        try {
            JSONObject result = new JSONObject(s);
            String status = result.getString("status");
            int totalResults = result.getInt("totalResults");

            JSONArray articles = result.getJSONArray("articles");

            ArrayList<Article> articleArrayList = new ArrayList<>();

            for (int i=0; i < articles.length(); i++){
                JSONObject articleJSONObject = articles.getJSONObject(i);

                JSONObject sourceJSONObject = articleJSONObject.getJSONObject("source");
                String id = sourceJSONObject.getString("id");
                String name = sourceJSONObject.getString("name");

                Source source = new Source(id, name);

                String author = articleJSONObject.getString("author");
                String title = articleJSONObject.getString("title");
                String description = articleJSONObject.getString("description");
                String url = articleJSONObject.getString("url");
                String urlToImage = articleJSONObject.getString("urlToImage");
                String publishedAt = articleJSONObject.getString("publishedAt");

                Article article = new Article(source,author,title,description,url,urlToImage,publishedAt);
                articleArrayList.add(article);
            }

            return new Result(status,totalResults,articleArrayList);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    private String fetchDataFromNetwork(String mUrl) {
        try {
            URL url = new URL(mUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream is = httpURLConnection.getInputStream();
            Scanner s = new Scanner(is);

            s.useDelimiter("\\A");

            String result = "";

            if(s.hasNext()){
                result = s.next();
            }
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something Went Wrong";
    }

}
