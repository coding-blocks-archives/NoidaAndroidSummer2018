package com.codingblocks.newspaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.newsHolder>{

    ArrayList<News> newsArrayList;
    Context ctx;

    public NewsAdapter(ArrayList<News> newsArrayList, Context ctx) {
        this.newsArrayList = newsArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public newsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflateView=layoutInflater.inflate(R.layout.item_row,viewGroup,false);
        newsHolder holder=new newsHolder(inflateView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull newsHolder newsHolder, int i) {
    News news=newsArrayList.get(i);
    newsHolder.title.setText(news.getTitle());
//        newsHolder.desc.setText(news.getDescription());
        newsHolder.url.setText(news.getUrl());
        Picasso.get().load(news.getUrltoImage()).into(newsHolder.urlToImage);


    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    class newsHolder extends RecyclerView.ViewHolder{
        TextView title,desc,url;
        ImageView urlToImage;

        public newsHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title_text);
//            desc=itemView.findViewById(R.id.title_desc);
            url=itemView.findViewById(R.id.title_url);
            urlToImage=itemView.findViewById(R.id.title_img);


        }
    }

}
