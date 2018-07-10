package xyz.vinayak.news;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Article> articleArrayList;

    public NewsAdapter(Context ctx, ArrayList<Article> articleArrayList) {
        this.ctx = ctx;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View view = li.inflate(R.layout.news_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article currentArticle = articleArrayList.get(position);
        holder.title.setText(currentArticle.getTitle());
        holder.description.setText(currentArticle.getDescription());
        Picasso.get().load(currentArticle.getUrlToImage()).fit().placeholder(R.mipmap.ic_error).into(holder.imageView);
        holder.url.setText(currentArticle.getUrl());
        holder.url.setPaintFlags(holder.url.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, description,url;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
            url = itemView.findViewById(R.id.tvUrl);

            url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url.getText().toString()));
                    ctx.startActivity(intent);
                }
            });
        }
    }
}
