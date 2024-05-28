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
import com.c196.degreeplanner.Entities.Terms;
import com.c196.degreeplanner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);
        FloatingActionButton fab = findViewById(R.id.addTermButton);

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(TermList.this, TermDetails.class);
            startActivity(intent);
        });

        RecyclerView recyclerView= findViewById(R.id.termRecyclerViewer);
        Repository repository = new Repository(getApplication());
        List<Terms> allTerms= repository.getAllTerms();
        final TermAdapter termAdapter= new TermAdapter(this);
        recyclerView.setAdapter(termAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        termAdapter.setTerms(allTerms);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_term_list, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.termListExit) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        } else {
            return false;
        }
    }
}