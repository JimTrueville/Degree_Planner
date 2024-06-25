package com.c196.degreeplanner.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.c196.degreeplanner.R;
import com.c196.degreeplanner.Utils.DatePicker;
import com.c196.degreeplanner.Utils.KeyBoardMngr;

public class TermDetails extends AppCompatActivity {

    private EditText termTitle;
    private EditText startDate;
    private EditText endDate;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_details);

        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate); // Initialize end date EditText
        datePicker = new DatePicker(this);

        startDate.setOnClickListener(v -> {
            KeyBoardMngr.hideKeyboard(TermDetails.this, v);
            datePicker.showDatePickerDialog((view, year, month, dayOfMonth) -> {
                startDate.setText((month + 1) + "/" + dayOfMonth + "/" + year);
            });
        });

        endDate.setOnClickListener(v -> {
            KeyBoardMngr.hideKeyboard(TermDetails.this, v);
            datePicker.showDatePickerDialog((view, year, month, dayOfMonth) -> {
                endDate.setText((month + 1) + "/" + dayOfMonth + "/" + year);
            });
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_term_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.termExit) {
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