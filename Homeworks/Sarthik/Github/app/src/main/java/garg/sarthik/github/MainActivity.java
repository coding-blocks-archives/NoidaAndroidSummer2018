package garg.sarthik.github;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        final EditText etUser = findViewById(R.id.etInput);
        Button btn = findViewById(R.id.btnGo);
        final String[] Input = new String[1];


        Log.e("TAG", "INPUT= "+ Input[0]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etUser.getText().toString().contains(" "))
                {   Input[0] = "https://api.github.com/search/users?q=" + etUser.getText().toString().replace(" ","%20");
                    Log.e("TAG", "onCreate: IF"+ Input[0]);
                }
                else
                {   Input[0] = "https://api.github.com/search/users?q=" + etUser.getText().toString();
                    Log.e("TAG", "onCreate: ELSE"+ Input[0]);
                }
                Mygithub mygithub = new Mygithub();
                mygithub.execute(Input[0]);
            }
        });
    }

    void addIntent(Items items)
    {
        Intent i = new Intent(getBaseContext(),SecondActivity.class);
        i.putExtra("url",items.getUrl());
        startActivity(i);
    }

    private class Mygithub extends AsyncTask<String,Void,String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            github_users gh_users = convertJSON(s);
            ArrayList<Items> items = gh_users.getItems();

            ListAdaptor la = new ListAdaptor(items,MainActivity.this);
            RecyclerView rvList = findViewById(R.id.rvList);

            rvList.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            rvList.setAdapter(la);
        }

        @Override
        protected String doInBackground(String... strings) {

            String string = strings[0];
            Log.e("TAG", string);

            try {

                URL url = new URL(string);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                String result = "";

                if(scanner.hasNext())
                {
                    result = scanner.next();
                    Log.e("TAG", "doInBackground: ");
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "";
        }
    }

    private github_users convertJSON(String s) {

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            ArrayList<Items> items = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject itemObject = jsonArray.getJSONObject(i);

                String login = itemObject.getString("login");
                String avatar_url = itemObject.getString("avatar_url");
                String url = itemObject.getString("url");

                items.add(new Items(login, avatar_url, url));
            }

            return new github_users(items);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
