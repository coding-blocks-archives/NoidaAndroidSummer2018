package com.example.dell1.news_app_hw_l09;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;
    NewsAdapter newsAdapter;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.news_rv);
        pb=findViewById(R.id.pb);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        MyNetworkTask myNetworkTask=new MyNetworkTask();
        myNetworkTask.execute("https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6ea5b3ad9ba04139b8601638cc7a61f2");
    }


    public Result convertJsonToResult(String json){

        try {
            JSONObject jsonObject=new JSONObject(json);
            String status=jsonObject.getString("status");
            Integer totalResults=jsonObject.getInt("totalResults");
            JSONArray jsonArray=jsonObject.getJSONArray("articles");

            ArrayList<Article> articleArrayList=new ArrayList<>();

            for(int i=0;i<jsonArray.length();i++){
                    JSONObject articleObject= jsonArray.getJSONObject(i);
                    String title=articleObject.getString("title");
                    String author=articleObject.getString("author");
                    String publishDate=articleObject.getString("publishedAt");
                    String image=articleObject.getString("urlToImage");
                    String desc=articleObject.getString("description");
                    String link=articleObject.getString("url");

                     Article article=new Article(title,author,publishDate,image,desc,link);
                     articleArrayList.add(article);
            }

            Result result=new Result(status,totalResults,articleArrayList);

            return result;
            
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    class MyNetworkTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String string=strings[0]; ///since this can recieve any no. of inputs therefore we need to pass the we require only
            ///the first string i.e. the link of the news api.

            try {
                //pass the link into the constructor of class URL
                URL url=new URL(string);

                //open a new connection using the url
                HttpsURLConnection httpsURLConnection=(HttpsURLConnection) url.openConnection();

                //Store the contents of the webpage as a stream
                InputStream inputStream=httpsURLConnection.getInputStream();

                //create a scanner fro the stream to get data in human readable form
                Scanner scanner=new Scanner(inputStream);

                //tell the sscanner to read file from very start to very end of file
                scanner.useDelimiter("\\A");

                String result="";

                if(scanner.hasNext()){
                    //read the whole content of scanner in one go
                    result=scanner.next();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Something went Wrong!!";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.GONE);
            Result finalResult=convertJsonToResult(s);
            int n=finalResult.getTotalResults();
            if(n>0)
            {Toast.makeText(getBaseContext(),""+finalResult.getStatus(),Toast.LENGTH_SHORT).show();

            newsAdapter=new NewsAdapter(finalResult,MainActivity.this);
            rv.setAdapter(newsAdapter);}

        }
    }
}
