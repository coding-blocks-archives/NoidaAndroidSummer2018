package com.example.shabnamkhatun.jsonh;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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


    String input = "https://newsapi.org/v2/top-headlines?sources=the-times-of-india&apiKey=507bf5b2fa7745f8b60cba2dd6a90f84";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        MyNetworking myNetworking = new MyNetworking();
        myNetworking.execute(input);
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
//                Source sourceJava = new Source(id, name);

                Article article = new Article(author, title, desc, url, imageUrl, published);

                articleArrayList.add(article);
            }

            Result result = new Result(status, totalResults, articleArrayList);

            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {
        ArrayList<Article> articles;

        public MyAdapter(ArrayList<Article> articles) {
            this.articles = articles;
        }

        @NonNull
        @Override
        public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_row, parent, false);
            return new Viewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Viewholder holder, int position) {
            final Article article=articles.get(position);
            holder.desc.setText(article.desc);
            holder.Headl.setText(article.title);
            Picasso.get().load(article.imageUrl).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return articles.size();
        }

        class Viewholder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView desc, Headl;

            public Viewholder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image);
                desc = itemView.findViewById(R.id.desc);
                Headl = itemView.findViewById(R.id.headline);
            }
        }
    }


    class MyNetworking extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String string = strings[0];
            String s = MakeCall(string);
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Result result=convertJsonToResponse(s);
            ArrayList<Article> articleArrayList=result.getArticles();
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getBaseContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new MyAdapter(articleArrayList));
        }
    }

    private String MakeCall(String string) {
        try {
            URL url = new URL(string);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");
            String s = "";

            if (scanner.hasNext()) {
                s = scanner.next();
            }

            return s;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Something is wrong";

    }



}
