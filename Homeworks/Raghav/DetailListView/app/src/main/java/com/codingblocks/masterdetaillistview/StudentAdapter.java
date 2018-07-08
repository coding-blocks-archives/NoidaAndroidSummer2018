package com.codingblocks.masterdetaillistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private ArrayList<Student> students;
    private Context ctx;
    MainActivity mainActivity;

    public StudentAdapter(ArrayList<Student> students, Context ctx, MainActivity ma) {
        this.students = students;
        this.ctx = ctx;
        mainActivity = ma;
//        mainActivity = (MainActivity) ctx;
//        mainActivity.startFragmentDetail(new DetailFragment());
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, int i) {
        Student student = students.get(i);
        studentHolder.studentName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentHolder extends RecyclerView.ViewHolder {

        TextView studentName;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.tvStudentName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Student currentStudent = students.get(getAdapterPosition());
//                    int currentPosition = getAdapterPosition();
                    mainActivity.startFragmentDetail(new DetailFragment(currentStudent.getName(),currentStudent.getImageUrl(),currentStudent.getBio()));
                }
            });
        }
    }

}
