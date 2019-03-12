package com.demo.college_demo;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.demo.college_demo.model.marksAdapter;
import com.demo.college_demo.model.marksModel;

import java.util.ArrayList;
import java.util.List;

public class timeTable extends AppCompatActivity {

    private List<marksModel> marksModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private marksAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("TG Godfrey\nExams");
        recyclerView =  findViewById(R.id.my_recycler_view);


        mAdapter = new marksAdapter(marksModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        // recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, new RecyclerView.State(), 5);
        fakeData();
    }

    private void fakeData() {
        marksModel marks = new marksModel("ISY34BT", "1993/02/07", 50);
        marksModelList.add(marks);
        marks = new marksModel("DSO32AT", "1993/02/02", 78);
        marksModelList.add(marks);
        marks = new marksModel("DSO34BT", "1993/02/01", 30);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", -1);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", 49);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", 49);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", 49);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", 49);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", 49);
        marksModelList.add(marks);
        marks = new marksModel("IDC34AT", "1993/02/12", 49);
        marksModelList.add(marks);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent myIntent= new Intent(this,MainActivity.class);

                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
