package garg.sarthik.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.ViewHolder> {

    private Context ctx;
    private ArrayList<Articles> articlesArrayList;

    NewsAdaptor(Context ctx, ArrayList<Articles> articlesArrayList) {
        this.ctx = ctx;
        this.articlesArrayList = articlesArrayList;

        Log.e("TAG", "NewsAdaptor: " );
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_itemlist,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Articles articles = articlesArrayList.get(position);

        holder.tvTitle.setText(articles.getTitle());
        if(articles.getAuthor().equals("null"))
            holder.tvAuthor.setText("-anonymous");
        else
            holder.tvAuthor.setText("-"+articles.getAuthor());
        Log.e("TAG", "onBindViewHolder: " + articles.getAuthor());
        holder.tvTime.setText(articles.getPublishedAt());
        Picasso.get()
                .load(articles.getImageURL())
                .placeholder(R.drawable.ic_wallpaper)
                .error(R.drawable.ic_report)
                .resize(250,250)
                .into(holder.ivImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity ma = (MainActivity) ctx;
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(articles.getMoreURL()));
                ma.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvAuthor;
        TextView tvTime;
        ImageView ivImage;

        ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTime = itemView.findViewById(R.id.tvTime);
            ivImage = itemView.findViewById(R.id.ivImageList);
        }
    }
}
