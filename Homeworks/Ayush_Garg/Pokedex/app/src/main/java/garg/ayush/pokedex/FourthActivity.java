package garg.ayush.pokedex;

import android.content.Context;
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

        ArrayList<String> Info = (ArrayList<String>) i.getSerializableExtra("Display");
        recyclerView.setAdapter(new MyAdapter(getBaseContext(),Info));
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        Context ctx;

        public MyAdapter(Context ctx, ArrayList<String> arrayList) {
            this.ctx = ctx;
            this.arrayList = arrayList;
        }

        ArrayList<String> arrayList;
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            String text = arrayList.get(i);
            viewHolder.textView.setText(text);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.name);
            }
        }
    }
}
