package com.c196.degreeplanner.UI;

import com.c196.degreeplanner.Utils.DatePicker;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.c196.degreeplanner.R;

public class courseDetails extends AppCompatActivity {

    private EditText startDate;
    private EditText endDate;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);


        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate); // Initialize end date EditText
        datePicker = new DatePicker(this);

        startDate.setOnClickListener(v -> datePicker.showDatePickerDialog((view, year, month, dayOfMonth) -> {
            startDate.setText( (month + 1)+ "/" + dayOfMonth + "/" + year);
        }));

        endDate.setOnClickListener(v -> datePicker.showDatePickerDialog((view, year, month, dayOfMonth) -> {
            endDate.setText((month + 1) + "/" + dayOfMonth + "/" + year);
        }));

        RadioGroup statusRadioGroup = findViewById(R.id.statusRadioGroup);
        statusRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String selectedOption = selectedRadioButton.getText().toString();
                // Do something with the selected option
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_courses_details, menu);
        return true;
    }

}