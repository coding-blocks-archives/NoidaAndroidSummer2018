package garg.sarthik.github;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.ViewHolder> {

    Context ctx;
    ArrayList<ReposDetail> reposDetailArrayListDetails;

    public UserAdaptor(Context ctx, ArrayList<ReposDetail> reposDetails) {
        this.ctx = ctx;
        this.reposDetailArrayListDetails = reposDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_reposlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ReposDetail reposDetail = reposDetailArrayListDetails.get(position);

        holder.tvName.setText(reposDetail.getName());
        holder.tvFullName.setText(reposDetail.getFull_name());
    }

    @Override
    public int getItemCount() {
        return reposDetailArrayListDetails.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvFullName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvFullName = itemView.findViewById(R.id.tvFullName);
        }
    }
}
