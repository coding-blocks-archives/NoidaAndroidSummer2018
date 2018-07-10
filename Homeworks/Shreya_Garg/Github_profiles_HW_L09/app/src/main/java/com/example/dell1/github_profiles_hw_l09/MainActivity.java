package com.example.dell1.github_profiles_hw_l09;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    ProfileAdapter profileAdapter;
    ProgressBar pb;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        pb=findViewById(R.id.pb);
        editText=findViewById(R.id.et);
        Button btn=findViewById(R.id.searchbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName=editText.getText().toString();
                pb.setVisibility(View.VISIBLE);
                LinearLayoutManager llm=new LinearLayoutManager(getBaseContext());
                rv.setLayoutManager(llm);

                MyNetworkTask myNetworkTask=new MyNetworkTask();
                myNetworkTask.execute("https://api.github.com/search/users?q="+userName);


            }
        });
    }


    public Result convertJsonToResult(String json){

        try {
            JSONObject jsonObject=new JSONObject(json);
            Integer totalcount=jsonObject.getInt("total_count");
            Boolean incompleteResults=jsonObject.getBoolean("incomplete_results");
            JSONArray jsonArray=jsonObject.getJSONArray("items");

            ArrayList<User> userArrayList=new ArrayList<>();

            for(int i=0;i<jsonArray.length();i++){
                JSONObject userObject= jsonArray.getJSONObject(i);
                String login=userObject.getString("login");
                String id=userObject.getString("id");
                String image=userObject.getString("avatar_url");
                String url=userObject.getString("html_url");

                User user=new User(login,id,image,url);
                userArrayList.add(user);
            }

            Result result=new Result(totalcount,incompleteResults,userArrayList);

            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    class MyNetworkTask extends AsyncTask<String,Void,String> {

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
//            pb.setVisibility(View.INVISIBL);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.GONE);
            Result finalResult=convertJsonToResult(s);
            int n=finalResult.getTotalCount();
            if(n==0 || finalResult.getIncompleteResults()){
                Toast.makeText(getBaseContext(),"Something went wrong!Try Again",Toast.LENGTH_SHORT).show();
            }
            if(n>0)
            {
                ProfileAdapter profileAdapter=new ProfileAdapter(finalResult,MainActivity.this);
                rv.setAdapter(profileAdapter); }

        }
    }
}
