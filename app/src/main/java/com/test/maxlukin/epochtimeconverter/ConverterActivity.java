package com.test.maxlukin.epochtimeconverter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import com.test.maxlukin.epochtimeconverter.Logic.ConverterLogic;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity {

    Button buttonConvert;

    EditText valueLeftField, valueRightField;

    private ConverterLogic converterLogic;
    private Calendar calendar;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private View dialogView;
    private AlertDialog alertDialog;
    private long valueLeft;
    private String valueRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        converterLogic = new ConverterLogic();

        valueLeftField = findViewById(R.id.valueLeftField);
        valueRightField = findViewById(R.id.valueRightField);
        buttonConvert = findViewById(R.id.buttonConvert);

        valueLeftField.setFocusable(true);

        valueLeftField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueRightField.setText("");
                if(valueLeftField.requestFocus()){
                    InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
                    }
                }

                buttonConvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeft = Long.parseLong(valueLeftField.getText().toString());
                        valueRightField.setText(converterLogic.convertUnixToHumanTime(valueLeft));
                    }
                });
            }

        });

        valueRightField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueLeftField.setText("");
//                if(valueRightField.requestFocus()){
//                    InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    if (imm != null) {
//                        imm.hideSoftInputFromWindow((IBinder) view, InputMethodManager.HIDE_IMPLICIT_ONLY);
//                    }
//                }

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

                        long time = calendar.getTimeInMillis();
                        alertDialog.setCancelable(true);
                        alertDialog.dismiss();
                        valueRightField.setText(converterLogic.convertUnixToHumanTime(calendar.getTimeInMillis()));
                        valueLeftField.setText("" + calendar.getTimeInMillis());
                    }});
                alertDialog.setView(dialogView);
                alertDialog.show();


            }
        });


    }
}
