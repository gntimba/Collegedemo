package com.demo.college_demo;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;

import com.demo.college_demo.Adapter.academicAdapter;
import com.demo.college_demo.model.academicModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class academic extends AppCompatActivity {
    private List<academicModel> marksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Results");
        RecyclerView recyclerView = findViewById(R.id.academic_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new academicAdapter(recyclerView, marksList, getApplicationContext()));
        fakeData();
    }

    private void fakeData() {
        Map mark = new HashMap();
        mark.put('1', "ssf1:50");
        mark.put('2', "ssf2:50");
        mark.put('3', "ssf3:50");
        academicModel marks = new academicModel("ISY34BT", 50.3, mark);
        marksList.add(marks);

        mark = new HashMap();
        mark.put('1', "abc1:50");
        mark.put('2', "abc2:50");
        mark.put('3', "abc3:50");
        marks = new academicModel("DSO34BT", 50.3, mark);
        marksList.add(marks);

        mark = new HashMap();
        mark.put('1', "def1:50");
        mark.put('2', "def2:50");
        mark.put('3', "def3:50");
        marks = new academicModel("ISY24AT", 50.3, mark);
        marksList.add(marks);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent myIntent = new Intent(this, MainActivity.class);

                startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
