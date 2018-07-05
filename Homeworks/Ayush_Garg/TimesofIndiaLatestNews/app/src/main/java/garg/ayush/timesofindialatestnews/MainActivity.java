package garg.ayush.timesofindialatestnews;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
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

    String timesURL = "https://newsapi.org/v2/top-headlines?sources=the-times-of-india&apiKey=cae3ad7e821a42c494506c3991daf2c2";
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RVnews);

        MyTask myTask = new MyTask();
        myTask.execute(timesURL);

    }

    public Result convertJSONToResponse(String json) {
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
//                Source sourceJava = new Source(id,name);

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


    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String urlTimes = strings[0];
            String s = makeNetworkCall(urlTimes);
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Result result = convertJSONToResponse(s);
            ArrayList<Article> articleArrayList = result.getArticles();
            LinearLayoutManager ll = new LinearLayoutManager(getBaseContext());
            recyclerView.setLayoutManager(ll);
            recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),
                    DividerItemDecoration.VERTICAL));
            recyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(),DividerItemDecoration.HORIZONTAL));

            recyclerView.setAdapter(new MyAdapter(articleArrayList));
        }


    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        public MyAdapter(ArrayList<Article> articleArrayList) {
            this.articleArrayList = articleArrayList;
        }

        ArrayList<Article> articleArrayList;

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View inflatedView = li.inflate(R.layout.item_row, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflatedView);
            return  viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
            final Article article = articleArrayList.get(position);

            holder.title.setText(article.getTitle());
            holder.description.setText(article.getDesc());
            Picasso.get().load(article.getImageUrl()).into(holder.imageView);

            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i =new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(article.getUrl()));
                    startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return articleArrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView title, description;
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.IDImage);
                title = itemView.findViewById(R.id.IDTitle);
                description = itemView.findViewById(R.id.IDDec);


            }
        }

    }

    private String makeNetworkCall(String urlTimes) {
        try {
            URL url = new URL(urlTimes);

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

        return "Something went wrong";
    }
}
