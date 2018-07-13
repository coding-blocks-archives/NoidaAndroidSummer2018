package com.example.shabnamkhatun.pokemonapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Mainactivity2 extends AppCompatActivity {
//    TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent i = getIntent();
       final ArrayList<Ability> abilityArrayList = (ArrayList<Ability>) i.getSerializableExtra("Ability" );
//        final ArrayList<type>typeArrayList= (ArrayList<type>) i.getSerializableExtra("types");
        Log.e("TAG", "onCreate: "+abilityArrayList.size() );
        int weightof= i.getIntExtra("weight",0);
        int heightof= i.getIntExtra("height",0);
        int idof= i.getIntExtra("id",0);
        int orderof= i.getIntExtra("order",0);
        int baseexof= i.getIntExtra("baseexperience",0);
       // Log.e("TAG", "onCreate: " + weightof);
        TextView w=findViewById(R.id.weight);
        TextView h=findViewById(R.id.height);
        TextView id=findViewById(R.id.id);
        TextView or=findViewById(R.id.order);
        TextView be=findViewById(R.id.baseex);
        w.setText("weight: "+String.valueOf(weightof));
        h.setText("Height: "+ String.valueOf(heightof));
        id.setText("id : "+String.valueOf(idof));
        or.setText("order: "+String.valueOf(orderof));
        be.setText("Base experience: "+String.valueOf(baseexof));
        Button ability=findViewById(R.id.ability);
        Button type=findViewById(R.id.types);


        ability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Mainactivity2.this,Main3Activity.class);
                in.putExtra("Ability",abilityArrayList);
                startActivity(in);
            }
        });

//        type.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in=new Intent(Mainactivity2.this,Main3Activity.class);
//                in.putExtra("type",typeArrayList);
//
//                startActivity(in);
//            }
//        });




//        RecyclerView recyclerView=findViewById(R.id.rec);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        MyAdapter adapter=new MyAdapter(abilityArrayList,typeArrayList);
//        recyclerView.setAdapter(adapter);


    }


//    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
////        ArrayList<Ability>random;
////        ArrayList<type>random2;
////
////        public MyAdapter(ArrayList<Ability> random, ArrayList<type> random2) {
////            this.random = random;
////            this.random2 = random2;
////        }
//
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view=LayoutInflater.from(getBaseContext()).inflate(R.layout.item_row,parent,false);
//            return  new ViewHolder(view);
//
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////            Ability ability = random.get(position);
////            Name name = ability.getAbility();
////            String name = name.getName();
//
////            String Abilityname=random.get(position).getAbility().getName();
////             String Typename=random2.get(position).getType().getName();
////            holder.abilities.setText(Abilityname);
////            holder.types.setText(Typename);
//
//            holder.text.setText(pokemon.getWeight);
//
//        }
//
//        @Override
//
//        public int getItemCount() {
//            return 1;
//        }
//
//        class ViewHolder extends RecyclerView.ViewHolder {
//
////            TextView abilities,types;
//            TextView text;
//            public ViewHolder(View itemView) {
//                super(itemView);
////                abilities=itemView.findViewById(R.id.text1);
////                types=itemView.findViewById(R.id.text2);
//                text=itemView.findViewById(R.id.text1);
//            }
//        }
//   }
}