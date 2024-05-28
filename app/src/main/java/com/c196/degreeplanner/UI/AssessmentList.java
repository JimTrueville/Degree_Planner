package com.c196.degreeplanner.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.c196.degreeplanner.Database.Repository;
import com.c196.degreeplanner.Entities.Assessments;
import com.c196.degreeplanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AssessmentList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_list);
        FloatingActionButton fab = findViewById(R.id.addAssessmentButton);

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(AssessmentList.this, AssessmentDetails.class);
            startActivity(intent);
        });
        RecyclerView recyclerView= findViewById(R.id.assessmentRecyclerView);
        Repository repository = new Repository(getApplication());
        List<Assessments> allAssessments= repository.getAllAssessments();
        final AssessmentAdapter assessmentAdapter= new AssessmentAdapter(this);
        recyclerView.setAdapter(assessmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        assessmentAdapter.setAssessments(allAssessments);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_assessment_list, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == R.id.assessmentListExit) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if(item.getItemId()== android.R.id.home) {
            this.finish();
            return true;
        } else{
            return false;
        }
    }

}