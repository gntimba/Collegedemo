package com.demo.college_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid =findViewById(R.id.grid);
        //set event
    //setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //loop all items of main grid

    }
    public void timeTable (View view)
    {
        Toast.makeText(this, "timeTable", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "finance", Toast.LENGTH_SHORT).show();
    }
    public void academic (View view)
    {
        Toast.makeText(this, "academic", Toast.LENGTH_SHORT).show();
    }
    public void libray (View view)
    {
        Toast.makeText(this, "libray", Toast.LENGTH_SHORT).show();
    }

}
