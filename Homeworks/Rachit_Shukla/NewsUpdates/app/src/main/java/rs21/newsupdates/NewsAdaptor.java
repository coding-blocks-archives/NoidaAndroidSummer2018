package rs21.newsupdates;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.ViewHolder> {

    private Context ctx;
    private ArrayList<Article> articlesArrayList;

    NewsAdaptor(Context ctx, ArrayList<Article> articlesArrayList) {
        this.ctx = ctx;
        this.articlesArrayList = articlesArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Article articles = articlesArrayList.get(position);

        holder.title.setText(articles.getTitle());
        if (articles.getAuthor().equals("null")) {
            holder.author.setText("- Anonymous");
        } else {
            holder.author.setText("- " + articles.getAuthor());
        }
        holder.time.setText(articles.getDate());
        Picasso.get()
                .load(articles.getImageUrl())
                .placeholder(R.drawable.ic_error_black_24dp)
                .error(R.drawable.ic_error_black_24dp)
                .resize(250, 250)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity ma = (MainActivity) ctx;
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(articles.getUrl()));
                ma.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView author;
        TextView time;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            img = itemView.findViewById(R.id.img);
        }
    }
}

