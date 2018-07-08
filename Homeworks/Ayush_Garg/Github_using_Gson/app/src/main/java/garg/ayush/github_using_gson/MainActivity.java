package garg.ayush.github_using_gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText =findViewById(R.id.IDname);
        Button go =findViewById(R.id.IDbtnGO);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.github.com/search/users?q=";
                String name  = editText.getText().toString();
                makeNetworkCall(url+name);
            }
        });

    }

    private void makeNetworkCall(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                final APIResponse apiResponse = gson.fromJson(result,APIResponse.class);
                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView=findViewById(R.id.IDrv);
                        ArrayList<Users> users = apiResponse.getUsers();
                        LinearLayoutManager ll = new LinearLayoutManager(getBaseContext());
                        recyclerView.setLayoutManager(ll);
                        recyclerView.setAdapter(new MyAdapter(getBaseContext(),users));
                    }
                });

            }
        });
    }
}
