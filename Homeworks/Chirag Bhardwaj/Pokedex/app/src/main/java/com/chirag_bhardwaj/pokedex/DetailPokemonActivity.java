package com.chirag_bhardwaj.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailPokemonActivity extends AppCompatActivity {

    ArrayList<String> imageUrls = new ArrayList<>();

    PokemonResult pokemonResult;
    TextView pokemonNameTextView, pokemonIdTextView, pokemonOrderTextView,
            pokemonWeightTextView, pokemonHeightTextView, pokemonAbilitiesTextView,
            pokemonStatsTextView, pokemonBaseExpTextView;

    CircleImageView pokemonImage;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        pokemonResult = (PokemonResult) getIntent().getSerializableExtra("POKEMON");

        pokemonNameTextView = (TextView) findViewById(R.id.pokemonNameDetailTextViewId);
        pokemonIdTextView = (TextView) findViewById(R.id.pokemonDetailIdTextViewId);
        pokemonOrderTextView = (TextView) findViewById(R.id.pokemonDetailOrderTextViewId);
        pokemonWeightTextView = (TextView) findViewById(R.id.pokemonWeightIdTextViewId);
        pokemonHeightTextView = (TextView) findViewById(R.id.pokemonHeightIdTextViewId);
        pokemonAbilitiesTextView = (TextView) findViewById(R.id.pokemonAbilitiesTextViewId);
        pokemonStatsTextView = (TextView) findViewById(R.id.pokemonStatsTextViewId);
        pokemonBaseExpTextView = (TextView) findViewById(R.id.pokemonBaseExpIdTextViewId);
        pokemonImage = (CircleImageView) findViewById(R.id.pokemomDetailImageViewId);

        pokemonNameTextView.setText(pokemonResult.getName());

        if (pokemonResult.getAbilities().size() > 0) {
            String finalAbilities = "";
            StringBuilder stringBuilderAbilities = new StringBuilder();
            stringBuilderAbilities.append(pokemonResult.getAbilities().get(0).getAbility().getName() + " : " +
                    pokemonResult.getAbilities().get(0).getSlot());
            for (i = 1; i < pokemonResult.abilities.size(); i++) {
                stringBuilderAbilities.append("\n" + pokemonResult.getAbilities().get(i).getAbility().getName() + " : " +
                        pokemonResult.getAbilities().get(i).getSlot());
            }
            finalAbilities = stringBuilderAbilities.toString();
            pokemonAbilitiesTextView.setText(finalAbilities);
        } else {
            pokemonAbilitiesTextView.setText("NULL");
        }

        if (pokemonResult.getStats().size() > 0) {
            String finalStats = "";
            StringBuilder stringBuilderStats = new StringBuilder();
            stringBuilderStats.append(pokemonResult.getStats().get(0).getStat().getName() + " : " +
                    pokemonResult.getStats().get(0).getEffort() + " : " + pokemonResult.getStats().get(0).getBase_stat());
            for (i = 1; i < pokemonResult.stats.size(); i++) {
                stringBuilderStats.append("\n" + pokemonResult.getStats().get(i).getStat().getName() + " : " +
                        pokemonResult.getStats().get(i).getEffort() + " : " + pokemonResult.getStats().get(i).getBase_stat());
            }
            finalStats = stringBuilderStats.toString();
            pokemonStatsTextView.setText(finalStats);
        } else {
            pokemonStatsTextView.setText("NULL");
        }

        pokemonIdTextView.setText("" + pokemonResult.getId());
        pokemonOrderTextView.setText("" + pokemonResult.getOrder());
        pokemonWeightTextView.setText("" + pokemonResult.getWeight());
        pokemonHeightTextView.setText("" + pokemonResult.getHeight());
        pokemonBaseExpTextView.setText("" + pokemonResult.getBase_experience());

        Picasso.with(this).load(pokemonResult.getSprites().getFront_default())
                .into(pokemonImage);

    }

}