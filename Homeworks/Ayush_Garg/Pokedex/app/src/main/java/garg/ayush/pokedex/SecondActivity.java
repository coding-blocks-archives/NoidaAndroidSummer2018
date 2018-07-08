package garg.ayush.pokedex;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SecondActivity extends AppCompatActivity {

    String pointedRight = "https://www.wpclipart.com/signs_symbol/button/metal_buttons/arrow_button_metal_green_right.png";
    String pointedLeft = "https://www.wpclipart.com/signs_symbol/button/metal_buttons/arrow_button_metal_green_left.png";
    String pokemonUrl = "http://pokeapi.co/api/v2/pokemon/";

    ImageView rightArrow;
    ImageView leftArrow;
    int count = 0;
    Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        rightArrow = findViewById(R.id.btnRgt);
        leftArrow = findViewById(R.id.btnLft);
        info = findViewById(R.id.info);
        final String enteredNum = i.getStringExtra("NUM");
        Picasso.get().load(pointedRight).into(rightArrow);
        Picasso.get().load(pointedLeft).into(leftArrow);
        if (Integer.parseInt(enteredNum) <2)
            leftArrow.setVisibility(View.GONE);
        makeNetworkCall(pokemonUrl + enteredNum);

        final int num = Integer.parseInt(enteredNum);
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                int numAdd = num + count;
                String finalNum = "" + numAdd;
                leftArrow.setVisibility(View.VISIBLE);
                makeNetworkCall(pokemonUrl + finalNum);

//                Toast.makeText(SecondActivity.this, finalNum, Toast.LENGTH_SHORT).show();
            }
        });

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                int numAdd = num + count;
                String finalNum = "" + numAdd;
//                leftArrow.setVisibility(View.VISIBLE);
                if (numAdd > 0) {
                    makeNetworkCall(pokemonUrl + finalNum);
                }
                if (numAdd < 2) {
                    leftArrow.setVisibility(View.INVISIBLE);
                }
            }
        });


    }

    private void makeNetworkCall(String s) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(s)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                String result = response.body().string();
                final Pokemon pokemon = gson.fromJson(result, Pokemon.class);
                (SecondActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Button info = findViewById(R.id.info);
                        ImageView imageView = findViewById(R.id.image);
                        TextView name = findViewById(R.id.name);
                        TextView id = findViewById(R.id.id);
//                        ArrayList<Sprites> arrayList = pokemon.getSprites();
//                        Toast.makeText(SecondActivity.this, pokemon.getSprites().toString(), Toast.LENGTH_SHORT).show();
                        Picasso.get()
                                .load(pokemon.getSprites().getImageUrl())
//                                .fit()
                                .into(imageView);
                        id.setText(pokemon.id);
                        name.setText(pokemon.name);
                        name.setTypeface(null, Typeface.BOLD);
                        info.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getBaseContext(), ThirdActivity.class);
                                intent.putExtra("ArrayStats",  pokemon.getStats());
                                intent.putExtra("ArrayMoves",  pokemon.getMoves());
                                intent.putExtra("ArrayAbilities", pokemon.getAbilities());
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }
}
