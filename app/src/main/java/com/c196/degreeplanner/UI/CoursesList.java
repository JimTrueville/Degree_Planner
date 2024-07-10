package com.c196.degreeplanner.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.c196.degreeplanner.Database.Repository;
import com.c196.degreeplanner.Entities.Assessments;
import com.c196.degreeplanner.Entities.Courses;
import com.c196.degreeplanner.Entities.Instructors;
import com.c196.degreeplanner.Entities.Terms;
import com.c196.degreeplanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.List;

public class CoursesList extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        FloatingActionButton fab = findViewById(R.id.addCourseButton);

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(CoursesList.this, CourseDetails.class);
            startActivity(intent);
        });

        RecyclerView recyclerView= findViewById(R.id.courseRecyclerView);
        Repository repository = new Repository(getApplication());
        List<Courses> allCourses= repository.getAllCourses();
        final CourseAdapter courseAdapter= new CourseAdapter(this);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter.setCourses(allCourses);

        // System.out.println(getIntent(). getStringExtra("test"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_course_list, menu);
        return true;
    }

    Date startDate = new Date(2024 - 1900, 0, 1);
    Date endDate = new Date(2024 - 1900, 5, 1);


    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.sampleData) {
            Repository repository = new Repository(getApplication());
            Assessments assessments1 = new Assessments("Mobile Applications Development", "Performance Assessment", startDate, endDate);
            repository.insert(assessments1);
            Assessments assessments2= new Assessments("Mobile Applications Development", "Objective Assessment", startDate, endDate);
            repository.insert(assessments2);
            Courses courses = new Courses(1, "Mobile Applications",startDate, endDate, "In Progress", "I Love Android Studio and Java", 1);
            repository.insert(courses);
            Instructors instructors = new Instructors("Juan Ruiz", "385-428-2843", "juan.ruiz@wgu.edu");
            repository.insert(instructors);
            Terms terms = new Terms("Spring", startDate, endDate);
            repository.insert(terms);
            return true;
        }
        if (item.getItemId() == R.id.courseListExit) {
            this.finish();
            return true;
        }
        return false;
    }

}
