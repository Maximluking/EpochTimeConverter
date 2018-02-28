package com.test.maxlukin.epochtimeconverter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.test.maxlukin.epochtimeconverter.Logic.ConverterLogic;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity {

    Button buttonConvert, buttonClearAll;

    EditText valueLeftField, valueRightField;

    private ConverterLogic converterLogic;
    private Calendar calendar;
    private long time;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private View dialogView;
    private AlertDialog alertDialog;
    private long value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        converterLogic = new ConverterLogic();

        valueLeftField = findViewById(R.id.valueLeftField);
        valueRightField = findViewById(R.id.valueRightField);
        buttonConvert = findViewById(R.id.buttonConvert);
        buttonClearAll = findViewById(R.id.buttonClearAll);

        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueLeftField.setText("");
                valueRightField.setText("");
            }
        });


        valueLeftField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);
                }
                buttonConvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        value = Long.parseLong(valueLeftField.getText().toString());
                        if(value == 0){
                            Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                                    Toast.LENGTH_LONG).show();} else
                            valueRightField.setText(converterLogic.convertUnixToHumanTime(value));
                    }
                });
                v.setOnTouchListener(null);
                return false;
            }
        });

        valueRightField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dialogView = View.inflate(ConverterActivity.this, R.layout.date_time_picker, null);
                alertDialog = new AlertDialog.Builder(ConverterActivity.this).create();

                dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        datePicker = dialogView.findViewById(R.id.date_picker);
                        timePicker = dialogView.findViewById(R.id.time_picker);

                        calendar = new GregorianCalendar(datePicker.getYear(),
                                datePicker.getMonth(),
                                datePicker.getDayOfMonth(),
                                timePicker.getCurrentHour(),
                                timePicker.getCurrentMinute());

                        time = calendar.getTimeInMillis()/1000L;
                        alertDialog.setCancelable(true);
                        alertDialog.dismiss();
                        if(time == 0){
                            Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                                    Toast.LENGTH_LONG).show();} else
                            valueRightField.setText(converterLogic.convertUnixToHumanTime(time));

                        buttonConvert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                valueLeftField.setText("" + time);
                            }
                        });

                    }});
                alertDialog.setView(dialogView);
                alertDialog.show();
                v.setOnTouchListener(null);
                return false;
            }
        });
    }
}
