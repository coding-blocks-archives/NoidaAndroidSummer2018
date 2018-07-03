package com.codingblocks.masterdetaillistview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
  private ArrayList<Student> students;
    private Context ctx;
    private MainActivity mainActivity;

    public StudentAdapter(ArrayList<Student> students, Context ctx, MainActivity mainActivity) {
        this.students = students;
        this.ctx = ctx;
        this.mainActivity = mainActivity;
    }


    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        Student student = students.get(position);
        holder.studentName.setText(student.getName());
    }




    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentHolder extends RecyclerView.ViewHolder{
        TextView studentName;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            studentName=itemView.findViewById(R.id.tvStudentName);
            studentName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Student currentStudent = students.get(getAdapterPosition());
                 mainActivity.startFragmentDetail(new DetailFragment(currentStudent.getName(),currentStudent.getImageUrl(),currentStudent.getBio()));
                }
            });


        }
    }


}
