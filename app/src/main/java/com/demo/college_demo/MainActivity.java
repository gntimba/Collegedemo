package com.demo.college_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mainGrid =findViewById(R.id.grid);

    }


    public void timeTable (View view)
    {
        Toast.makeText(this, "timeTable", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, timeTable.class);
        startActivity(i);
        Toast.makeText(this, "finance", Toast.LENGTH_SHORT).show();
    }
    public void attendance (View view)
    {
        Toast.makeText(this, "attendance", Toast.LENGTH_SHORT).show();
    }
    public void chat (View view)
    {
        Toast.makeText(this, "chat", Toast.LENGTH_SHORT).show();
    }
    public void query (View view)
    {
        Toast.makeText(this, "query", Toast.LENGTH_SHORT).show();
    }
    public void upload (View view)
    {
        Toast.makeText(this, "upload", Toast.LENGTH_SHORT).show();
    }
    public void finance (View view)
    {
        Intent i = new Intent(this, finance.class);
        startActivity(i);
        Toast.makeText(this, "finance", Toast.LENGTH_SHORT).show();
    }
    public void academic (View view)
    {

        Intent i = new Intent(this, academic.class);
        startActivity(i);
        Toast.makeText(this, "academic", Toast.LENGTH_SHORT).show();
    }
    public void libray (View view)
    {
        Toast.makeText(this, "libray", Toast.LENGTH_SHORT).show();
    }

}
