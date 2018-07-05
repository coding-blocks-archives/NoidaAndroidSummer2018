package com.codingblocks.apisearchusers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GithubUsersAdapter extends RecyclerView.Adapter<GithubUsersAdapter.githubviewHolder> {

    ArrayList<GithubUsers> githubUsers;
    Context ctx;

    public GithubUsersAdapter(ArrayList<GithubUsers> githubUsers, Context ctx) {
        this.githubUsers = githubUsers;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public githubviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View inflateView=layoutInflater.inflate(R.layout.item_row,parent,false);
        githubviewHolder githubviewHolder=new githubviewHolder(inflateView);
        return githubviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull githubviewHolder holder, int position) {
    GithubUsers users= githubUsers.get(position);
    holder.login.setText(users.getLogin());
    holder.url.setText(users.getHtml_url());
    holder.score.setText(users.getScore().toString());


    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    class githubviewHolder extends RecyclerView.ViewHolder{
TextView login, url, score;

        public githubviewHolder(View itemView) {
            super(itemView);
            login=itemView.findViewById(R.id.tvView_login);
            url =itemView.findViewById(R.id.tvView_url);
            score =itemView.findViewById(R.id.tvView_score);

    }
    }

}
