package com.test.maxlukin.epochtimeconverter.Services;

import android.app.DialogFragment;
import android.view.View;
import android.widget.DatePicker;

/**
 * Created by Zadrotisha on 28.02.2018.
 */

public class DataTimeCustomePicker {

    private DatePickerFragment datePickerFragment;
    private TimePickerFragment timePickerFragment;

    public DataTimeCustomePicker() {
        datePickerFragment = new DatePickerFragment();
        timePickerFragment = new TimePickerFragment();
    }

    public void showTimePickerDialog(View v) {
        DialogFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(timePickerFragment.getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(datePickerFragment.getFragmentManager(), "datePicker");
    }

}
