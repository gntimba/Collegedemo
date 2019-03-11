package com.demo.college_demo.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.college_demo.R;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<marksModel> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView subject, date, marks;

        public MyViewHolder(View view) {
            super(view);
            subject =  view.findViewById(R.id.subject);
            date =  view.findViewById(R.id.ExamDate);
            marks =  view.findViewById(R.id.marks);
        }
    }


    public MoviesAdapter(List<marksModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_time_table, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        marksModel MarksModel = moviesList.get(position);
        holder.subject.setText(MarksModel.getSubject());
        holder.date.setText(MarksModel.getDate());
        holder.marks.setText(MarksModel.getMarks()+"%");
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}