package com.codingblocks.apisearchusers;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        editText=findViewById(R.id.et);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             updateText();

            }
        });
    }

    private void updateText() {

        MyNetwork myTask=new MyNetwork();
        myTask.execute("https://api.github.com/search/users?q="+editText.getText().toString());
    }


    class MyNetwork extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String string = strings[0];

            try {
                URL url = new URL(string);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");

                String result = "";
                if (scanner.hasNext()) {
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

            ArrayList<GithubUsers> users=parseJson(s);
            Log.e("TAG","onPostExecte    :  "+users.size());

            GithubUsersAdapter githubUsersAdapter=new GithubUsersAdapter(users,MainActivity.this);
            RecyclerView recyclerView=findViewById(R.id.rvUsers);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(githubUsersAdapter);
        }
    }


     public ArrayList<GithubUsers> parseJson(String json){

        ArrayList<GithubUsers> githubusers =new ArrayList<>();
        // parse json
        try {
            JSONObject root=new JSONObject(json);
            JSONArray items= root.getJSONArray("items");
            for(int i=0;i<items.length();i++){     //loop runs for 30 times
                JSONObject object=items.getJSONObject(i);
                String login=object.getString("login");
                Integer id=object.getInt("id");
                String avatar_url=object.getString("avatar_url");
                Double score =object.getDouble("score");
                String html_url=object.getString("html_url");
                //quotation marks keys mapped
                GithubUsers users=new GithubUsers(login,html_url,avatar_url,id,score);
                githubusers.add(users);


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return githubusers;

    }


}
