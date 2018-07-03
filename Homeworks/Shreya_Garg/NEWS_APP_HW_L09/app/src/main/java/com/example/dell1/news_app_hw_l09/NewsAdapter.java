package com.example.dell1.news_app_hw_l09;

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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context ctx;
    private Result finalResult;

    public NewsAdapter(Result finalResult,Context ctx) {
        this.finalResult=finalResult;
        this.ctx=ctx;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView author;
        TextView date;
        ImageView image;
        TextView desc;
        TextView link;

        public ViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.newstitle);
            author=itemView.findViewById(R.id.newsauthor);
            date=itemView.findViewById(R.id.newspublishdate);
            image=itemView.findViewById(R.id.newsimage);
            desc=itemView.findViewById(R.id.newsdescription);
            link=itemView.findViewById(R.id.newslink);

        }
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflatedView=layoutInflater.inflate(R.layout.item_row,parent,false);
        return new ViewHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {

        ArrayList<Article> articleArrayList=finalResult.getArticleArrayList();
        final Article currentArticle=articleArrayList.get(position);
        if(currentArticle.getTitle()!=null)
        {holder.title.setText(currentArticle.getTitle());}
        else
        {
            holder.title.setText("");
        }
        if(currentArticle.getAuthor()!=null || currentArticle.getAuthor()!=("null") || currentArticle.getAuthor()!="")
        {holder.author.setText("- " + currentArticle.getAuthor());}
        else
        {
            holder.author.setText("");
        }
        holder.date.setText(currentArticle.getDate());
        if(currentArticle.getImage()!=null)
        {Picasso.with(ctx).load(currentArticle.getImage()).into(holder.image);}

        if(currentArticle.getDesc()!=null)
        {holder.desc.setText(currentArticle.getDesc());}
        else
        {
            holder.desc.setText("");
        }
        if(currentArticle.getLink()!=null) {
            final String linkcurrent = currentArticle.getLink();
            holder.link.setText(currentArticle.getLink());
            holder.link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(linkcurrent));
                    ctx.startActivity(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return finalResult.getArticleArrayList().size();
    }
}
