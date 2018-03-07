package com.test.maxlukin.epochtimeconverter.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
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
        View.OnClickListener {

    Button buttonConvert, buttonClearAll;
    EditText unixTimeActivity;
    TextView humanTimeActivity;
    View dialogView;

    private Calendar calendar;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private AlertDialog alertDialog;
    private ConverterLogic converterLogic;
    private long unixTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        converterLogic = new ConverterLogicImpl();

        unixTimeActivity = findViewById(R.id.unixTime);
        humanTimeActivity = findViewById(R.id.humanTime);
        buttonConvert = findViewById(R.id.buttonConvert);
        buttonClearAll = findViewById(R.id.buttonClearAll);


        unixTimeActivity.setOnClickListener(this);
        humanTimeActivity.setOnClickListener(this);
        buttonClearAll.setOnClickListener(this);
        buttonConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonClearAll:

                unixTimeActivity.setText("");
                humanTimeActivity.setText("");
                break;

            case R.id.buttonConvert:

                if ((humanTimeActivity.getText().toString().isEmpty()) && (!unixTimeActivity.getText().toString().isEmpty())) {
                    unixTime = Long.parseLong(unixTimeActivity.getText().toString());
                    humanTimeActivity.setText(converterLogic.convertUnixToHumanTime(unixTime));
                } else if ((unixTimeActivity.getText().toString().isEmpty()) && (!humanTimeActivity.getText().toString().isEmpty())) {
                    try {
                        unixTimeActivity.setText(converterLogic.convertHumanToUnixTime(humanTimeActivity.getText().toString()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                            Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.unixTime:

                InputMethodManager inputManagerUnixTime = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManagerUnixTime != null) {
                    inputManagerUnixTime.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
                }
                break;

            case R.id.humanTime:

                unixTimeActivity.clearFocus();
                InputMethodManager inputManagerHumanTime = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManagerHumanTime != null) {
                    inputManagerHumanTime.hideSoftInputFromInputMethod(humanTimeActivity.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
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

                                unixTime = calendar.getTimeInMillis() / 1000L;
                                alertDialog.dismiss();
                                humanTimeActivity.setText(converterLogic.convertUnixToHumanTime(unixTime));
                            }
                        });
                        alertDialog.setView(dialogView);
                        alertDialog.show();
                    }
                });
                alertDialog.setView(dialogView);
                alertDialog.show();
                break;
            default:
                break;
        }
    }
}
