package garg.ayush.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String pokedex_go="http://www.malta-comics.com/wp-content/uploads/2015/03/pokemon.png";
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView pokemon_go = findViewById(R.id.pokemon_go);
        Picasso.get().load(pokedex_go).into(pokemon_go);
        editText=findViewById(R.id.pokemonNum);
        pokemon_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getBaseContext(),SecondActivity.class);
                i.putExtra("NUM",editText.getText().toString());
                startActivity(i);
            }
        });
    }
}
