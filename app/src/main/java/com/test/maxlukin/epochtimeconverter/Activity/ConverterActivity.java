package com.test.maxlukin.epochtimeconverter.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
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
import com.test.maxlukin.epochtimeconverter.R;
import com.test.maxlukin.epochtimeconverter.Services.ConverterLogic;
import com.test.maxlukin.epochtimeconverter.Services.impl.ConverterLogicImpl;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity implements
        View.OnTouchListener, View.OnClickListener{

    Button buttonConvert, buttonClearAll;
    EditText valueUnixTime, valueHumanTime;
    View dialogView;

    private Calendar calendar;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private AlertDialog alertDialog;
    private ConverterLogic converterLogic;
    private long value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        converterLogic = new ConverterLogicImpl();

        valueUnixTime = findViewById(R.id.unixTime);
        valueHumanTime = findViewById(R.id.humanTime);
        buttonConvert = findViewById(R.id.buttonConvert);
        buttonClearAll = findViewById(R.id.buttonClearAll);


        valueUnixTime.setOnTouchListener(this);
        valueHumanTime.setOnTouchListener(this);
        buttonClearAll.setOnClickListener(this);
        buttonConvert.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){

            case R.id.unixTime:

                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);
                }
                v.setOnTouchListener(null);
                break;

            case R.id.humanTime:

                dialogView = View.inflate(ConverterActivity.this, R.layout.date_picker, null);
                alertDialog = new AlertDialog.Builder(ConverterActivity.this).create();
                alertDialog.setCanceledOnTouchOutside(false);

                dialogView.findViewById(R.id.date_set).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        datePicker = dialogView.findViewById(R.id.date_picker);

                        final int year = datePicker.getYear();
                        final int month = datePicker.getMonth();
                        final int day = datePicker.getDayOfMonth();

                        alertDialog.dismiss();


                        dialogView = View.inflate(ConverterActivity.this, R.layout.time_picker, null);
                        alertDialog = new AlertDialog.Builder(ConverterActivity.this).create();
                        alertDialog.setCanceledOnTouchOutside(false);

                        dialogView.findViewById(R.id.time_set).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                timePicker = dialogView.findViewById(R.id.time_picker);
                                calendar = new GregorianCalendar(year,
                                        month,
                                        day,
                                        timePicker.getCurrentHour(),
                                        timePicker.getCurrentMinute());

                                value = calendar.getTimeInMillis()/1000L;
                                alertDialog.dismiss();
                                valueHumanTime.setText(converterLogic.convertUnixToHumanTime(value));
                            }
                        });
                        alertDialog.setView(dialogView);
                        alertDialog.show();
                    }});
                alertDialog.setView(dialogView);
                alertDialog.show();
                v.setOnTouchListener(null);
                break;
            default:
                v.setOnTouchListener(null);
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buttonClearAll:

                valueUnixTime.setText("");
                valueHumanTime.setText("");
                break;

            case R.id.buttonConvert:

                if((valueHumanTime.getText().toString().isEmpty())&&(!valueUnixTime.getText().toString().isEmpty())&&(valueUnixTime.isFocused())){
                    value = Long.parseLong(valueUnixTime.getText().toString());
                    valueHumanTime.setText(converterLogic.convertUnixToHumanTime(value));
                } else if((valueUnixTime.getText().toString().isEmpty())&&(valueHumanTime.isFocused())&&(!valueHumanTime.getText().toString().isEmpty())){
                    try {
                        valueUnixTime.setText(converterLogic.convertHumanToUnixTime(valueHumanTime.getText().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
