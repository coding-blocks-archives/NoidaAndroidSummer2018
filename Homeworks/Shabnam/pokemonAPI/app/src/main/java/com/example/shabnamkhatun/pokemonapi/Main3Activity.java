package com.example.shabnamkhatun.pokemonapi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.rec);
        Intent i=getIntent();
        ArrayList<Ability>abilityArrayList= (ArrayList<Ability>) i.getSerializableExtra("Ability");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(abilityArrayList);
        recyclerView.setAdapter(adapter);


    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
      ArrayList<Ability> random;
       // ArrayList<type>random2;

        public MyAdapter(ArrayList<Ability> random) {
            this.random = random;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_row, parent, false);
            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//           Ability ability = random.get(position);
//            Name name = ability.getAbility();
//            String name = name.getName();

           String Abilityname=random.get(position).getAbility().getName();
//            String Typename=random2.get(position).getType().getName();
          holder.abilities.setText(Abilityname);
//            holder.types.setText(Typename);

           // holder.text.setText(Abilityname);

        }

        @Override

        public int getItemCount() {
            return random.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

                       TextView abilities;
            // types;
            //TextView text;

            public ViewHolder(View itemView) {
                super(itemView);
               abilities=itemView.findViewById(R.id.text1);
//                types=itemView.findViewById(R.id.text2);
               // text = itemView.findViewById(R.id.text1);
            }
        }
    }
}
