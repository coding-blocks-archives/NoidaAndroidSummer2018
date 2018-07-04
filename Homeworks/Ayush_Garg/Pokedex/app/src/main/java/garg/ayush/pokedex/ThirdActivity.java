package garg.ayush.pokedex;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity implements Serializable {

    String statsImage = "https://www.shareicon.net/data/128x128/2016/07/11/794232_graph_512x512.png";
    String movesImage = "https://cdn3.iconfinder.com/data/icons/unigrid-flat-military/90/002_022_military_battle_attack_swords-512.png";
    String abilityImage = "https://curiositygym.com/wp-content/uploads/who-can-intern-1.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent i =getIntent();
        ImageView stats =findViewById(R.id.Stats);
        ImageView ability = findViewById(R.id.ability);
        ImageView moves = findViewById(R.id.moves);
        Picasso.get().load(statsImage).into(stats);
        Picasso.get().load(movesImage).into(moves);
        Picasso.get().load(abilityImage).into(ability);
        TextView abilitytext = findViewById(R.id.abilitytext);
        TextView statstext = findViewById(R.id.statstext);
        TextView movestext = findViewById(R.id.movestext);
        ArrayList<Stats> statsArrayList= (ArrayList<Stats>) i.getSerializableExtra("ArrayStats");
        ArrayList<Moves> movesArrayList = (ArrayList<Moves>) i.getSerializableExtra("ArrayMoves");
        final ArrayList<Abilities> abilitiesArrayList = (ArrayList<Abilities>) i.getSerializableExtra("ArrayAbilities");

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),FourthActivity.class);
                i.putExtra("Display",(Serializable) abilitiesArrayList);
                startActivity(i);
            }
        });

        moves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
