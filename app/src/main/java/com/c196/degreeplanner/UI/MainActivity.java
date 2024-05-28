package com.c196.degreeplanner.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.c196.degreeplanner.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=findViewById(R.id.buttonCourses);
        Button button2=findViewById(R.id.buttonTerms);
        Button button3=findViewById(R.id.buttonAssessments);

        button1.setOnClickListener(v -> {
              Intent intent=new Intent(MainActivity.this, CoursesList.class);
              startActivity(intent);
        });

        button2.setOnClickListener(v -> {
                Intent intent=new Intent(MainActivity.this, TermList.class);
                startActivity(intent);
        });

        button3.setOnClickListener(v -> {

                Intent intent=new Intent(MainActivity.this, AssessmentList.class);
                startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {if (item.getItemId() == R.id.exitApp) {
        finishAffinity();
        System.exit(0);
        return true;
    }
        return false;
    }

}