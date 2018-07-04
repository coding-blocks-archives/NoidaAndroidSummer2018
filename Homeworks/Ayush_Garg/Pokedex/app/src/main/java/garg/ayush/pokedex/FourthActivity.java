package garg.ayush.pokedex;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity implements Serializable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        Intent i =getIntent();

        ArrayList<Abilities> abilitiesArrayList = (ArrayList<Abilities>) i.getSerializableExtra("Display");
        ArrayList<Stats> statsArrayList = (ArrayList<Stats>) i.getSerializableExtra("Display");
        ArrayList<Moves> movesArrayList = (ArrayList<Moves>) i.getSerializableExtra("Display");
        int number = Integer.parseInt(i.getStringExtra("num"));
        Log.e("TAG", "onCreate: "+number );
        if(number==1)
            recyclerView.setAdapter(new MyAbilitiesAdapter(getBaseContext(),abilitiesArrayList));
        else if(number==2)
            recyclerView.setAdapter(new MyStatsAdapter(getBaseContext(),statsArrayList));
        else if (number==3)
            recyclerView.setAdapter(new MyMovesAdapter(getBaseContext(),movesArrayList));
    }

    class MyAbilitiesAdapter extends RecyclerView.Adapter<MyAbilitiesAdapter.ViewHolder>{

        Context ctx;
        ArrayList<Abilities> arrayList;

        public MyAbilitiesAdapter(Context ctx, ArrayList<Abilities> arrayList) {
            this.ctx = ctx;
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            String text = arrayList.get(i).getAbility().getName();
//            Log.e("TAG", "onBindViewHolder: "+ text );
            viewHolder.textView.setText(text);
            viewHolder.textView.setTypeface(null, Typeface.BOLD);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.textDisplay);
            }
        }
    }

    class MyStatsAdapter extends RecyclerView.Adapter<MyStatsAdapter.ViewHolder>{
        Context ctx;
        ArrayList<Stats> arrayList;

        public MyStatsAdapter(Context ctx, ArrayList<Stats> arrayList) {
            this.ctx = ctx;
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            String text = arrayList.get(i).getStat().getName();
//            Log.e("TAG", "onBindViewHolder: "+ text );
            viewHolder.textView.setText(text);
            viewHolder.textView.setTypeface(null, Typeface.BOLD);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.textDisplay);
            }
        }
    }

    class MyMovesAdapter extends RecyclerView.Adapter<MyMovesAdapter.ViewHolder>{
        Context ctx;
        ArrayList<Moves> arrayList;

        public MyMovesAdapter(Context ctx, ArrayList<Moves> arrayList) {
            this.ctx = ctx;
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            String text = arrayList.get(i).getMove().getName();
//            Log.e("TAG", "onBindViewHolder: "+ text );
            viewHolder.textView.setText(text);
            viewHolder.textView.setTypeface(null, Typeface.BOLD);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.textDisplay);
            }
        }
    }
}
