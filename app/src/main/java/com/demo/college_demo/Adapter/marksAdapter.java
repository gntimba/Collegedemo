package com.demo.college_demo.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.college_demo.R;
import com.demo.college_demo.model.marksModel;

import java.util.List;

public class marksAdapter extends RecyclerView.Adapter<marksAdapter.MyViewHolder> {

    private List<marksModel> marksList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView subject, date, marks;

        public MyViewHolder(View view) {
            super(view);
            subject =  view.findViewById(R.id.subject);
            date =  view.findViewById(R.id.ExamDate);
            marks =  view.findViewById(R.id.marks);
        }
    }


    public marksAdapter(List<marksModel> moviesList) {
        this.marksList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        marksModel MarksModel = marksList.get(position);
        holder.subject.setText(MarksModel.getSubject());
        holder.date.setText(MarksModel.getDate());

        if (MarksModel.getMarks() == -1) {
            holder.marks.setText("N/A");
            holder.marks.setTextColor(Color.GRAY);
        } else {
            holder.marks.setText(MarksModel.getMarks() + "%");
            if (MarksModel.getMarks() < 50) {
                holder.marks.setTextColor(Color.RED);
            }
        }
    }

    @Override
    public int getItemCount() {
        return marksList.size();
    }
}