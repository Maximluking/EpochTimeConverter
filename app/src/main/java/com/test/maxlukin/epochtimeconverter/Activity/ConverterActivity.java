package com.test.maxlukin.epochtimeconverter.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.test.maxlukin.epochtimeconverter.R;
import com.test.maxlukin.epochtimeconverter.Services.ConverterLogic;
import com.test.maxlukin.epochtimeconverter.Services.DatePickerFragment;
import com.test.maxlukin.epochtimeconverter.Services.impl.ConverterLogicImpl;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity implements View.OnTouchListener{

    Button buttonConvert, buttonClearAll;

    EditText valueUnixTime, valueHumanTime;

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

        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUnixTime.setText("");
                valueHumanTime.setText("");
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){

            case R.id.unixTime:

                InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);
                }
                buttonConvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(valueUnixTime.getText().toString().isEmpty()){
                            Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                                    Toast.LENGTH_SHORT).show();} else {
                            value = Long.parseLong(valueUnixTime.getText().toString());
                            valueHumanTime.setText(converterLogic.convertUnixToHumanTime(value));
                        }
                    }
                });
                v.setOnTouchListener(null);
                break;

            case R.id.humanTime:
                DialogFragment dataPicker = new DatePickerFragment();



                valueHumanTime.setText(converterLogic.convertUnixToHumanTime(value));
                buttonConvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(valueHumanTime.getText().toString().isEmpty()) {
                            Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            valueUnixTime.setText("" + value);
                        }
                    }
                });
                v.setOnTouchListener(null);
                break;
        }
        return false;
    }
}
