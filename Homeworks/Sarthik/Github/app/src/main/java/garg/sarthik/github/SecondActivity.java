package garg.sarthik.github;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
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

public class SecondActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvLogin;
    TextView tvBio;
    TextView tvLocation;
    TextView tvCompany;
    TextView tvBlog;
    ImageView ivUser;
    RecyclerView rvUserList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle bundle = getIntent().getExtras();
        String userURL = bundle.getString("url");

        UserDetails userList =  new UserDetails();
        userList.execute(userURL);


    }

    private class UserDetails extends AsyncTask<String,Void,String> {
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

                if (scanner.hasNext()) {
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

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            user_detail userDetail = convertJSON(s);

            tvName = findViewById(R.id.tvUserName);
            tvLogin = findViewById(R.id.tvUserLogin);
            tvBio = findViewById(R.id.tvUserBio);
            tvBio.setMovementMethod(new ScrollingMovementMethod());
            tvCompany = findViewById(R.id.tvUserCompany);
            tvBlog = findViewById(R.id.tvUserBlog);
            tvLocation = findViewById(R.id.tvUserLocation);
            ivUser = findViewById(R.id.ivUserImage);
            rvUserList = findViewById(R.id.rvUserList);

            tvName.setText(userDetail.getName());
            tvLogin.setText(userDetail.getLogin());
            tvBio.setText(userDetail.getBio());
            tvCompany.setText(userDetail.getCompany());
            tvLocation.setText(userDetail.getLocation());
            tvBlog.setText(userDetail.getBlog());

            Picasso.get()
                    .load(userDetail.getAvatar_url())
                    .placeholder(R.drawable.ic_report)
                    .resize(250, 250)
                    .error(R.drawable.ic_wallpaper)
                    .into(ivUser);

            ReposSync reposSync = new ReposSync();
            reposSync.execute(userDetail.getRepos_url().toString());

    //The Problem is from this part of the code to the line number 145

        }
    }

    private user_detail convertJSON(String s) {

        try {
            JSONObject jsonObject = new JSONObject(s);
            String avatar_url = jsonObject.getString("avatar_url");
            String name = jsonObject.getString("name");
            String login = jsonObject.getString("login");
            String bio = jsonObject.getString("bio");
            String location = jsonObject.getString("location");
            String company = jsonObject.getString("company");
            String blog = jsonObject.getString("blog");
            String repos_url = jsonObject.getString("repos_url");

            return new user_detail(avatar_url,name,login,bio,location,company,blog,repos_url);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private class ReposSync extends AsyncTask<String,Void,String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ArrayList<ReposDetail> reposDetails = convertJSON2(s);
            UserAdaptor userAdaptor = new UserAdaptor(SecondActivity.this,reposDetails);
            rvUserList.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            rvUserList.setAdapter(userAdaptor);
        }

        @Override
        protected String doInBackground(String... strings) {

            String s = strings[0];
            URL url;
            try {
                url = new URL(s);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

    }

    private ArrayList<ReposDetail> convertJSON2(String s) {

        try {

            JSONArray jsonArray = new JSONArray(s);
            ArrayList<ReposDetail> reposDetails = new ArrayList<>();
            for(int i = 0; i < jsonArray.length() ; i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String full_name = jsonObject.getString("full_name");
                reposDetails.add(new ReposDetail(name,full_name));
            }

            return reposDetails;


        }  catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
