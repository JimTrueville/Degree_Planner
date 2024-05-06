package com.c196.degreeplanner.Utils;


import android.app.DatePickerDialog;
import android.content.Context;

import java.util.Calendar;

public class DatePicker {
    private final Context context;

    public DatePicker(Context context) {
        this.context = context;
    }

    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener listener) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(context, listener, year, month, dayOfMonth).show();
    }


}
