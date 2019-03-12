package com.demo.college_demo.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.college_demo.R;
import com.demo.college_demo.model.academicModel;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;
import java.util.Map;

public class academicAdapter extends RecyclerView.Adapter<academicAdapter.ViewHolder> {
    private List<academicModel> marksList;
    private static final int UNSELECTED = -1;
    private Context context;

    private RecyclerView recyclerView;
    private int selectedItem = UNSELECTED;

    public academicAdapter(RecyclerView recyclerView, List<academicModel> moviesList, Context context) {
        this.recyclerView = recyclerView;
        this.marksList = moviesList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_ac_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return marksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
        private ExpandableLayout expandableLayout;
        private CardView expandButton;
        private TextView subject;
        private TextView average;
        private TextView test;

        public ViewHolder(View itemView) {
            super(itemView);

            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            expandableLayout.setInterpolator(new OvershootInterpolator());
            expandableLayout.setOnExpansionUpdateListener(this);
            expandButton = itemView.findViewById(R.id.expand_button);
            subject = itemView.findViewById(R.id.subject2);
            average = itemView.findViewById(R.id.average);
            test = itemView.findViewById(R.id.test);
            expandButton.setOnClickListener(this);
        }

        public void bind() {

            int position = getAdapterPosition();
            boolean isSelected = position == selectedItem;
            academicModel marks = marksList.get(position);
            Map map = marks.getMarks();
            String t = "";
            for (int x = 1; x <= map.size(); x++) {
                char b = (char) (x + '0');
                t += map.get(b).toString() + "\n";
            }


            test.setText(t);
            subject.setText(marks.getSubject());
            average.setText(marks.getAverage() + "");
            // textView.setText(position + ". Tap to expand");
            expandButton.setSelected(isSelected);
            expandableLayout.setExpanded(isSelected, false);
        }

        @Override
        public void onClick(View view) {
            ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
            if (holder != null) {
                holder.expandButton.setSelected(false);
                holder.expandableLayout.collapse();
            }

            int position = getAdapterPosition();
            if (position == selectedItem) {
                selectedItem = UNSELECTED;
            } else {
                expandButton.setSelected(true);
                expandableLayout.expand();
                selectedItem = position;
            }
        }

        @Override
        public void onExpansionUpdate(float expansionFraction, int state) {
            Log.d("ExpandableLayout", "State: " + state);
            if (state == ExpandableLayout.State.EXPANDING) {
                recyclerView.smoothScrollToPosition(getAdapterPosition());
            }
        }
    }
}