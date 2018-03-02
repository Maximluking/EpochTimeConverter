package com.test.maxlukin.epochtimeconverter.Activity;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.test.maxlukin.epochtimeconverter.R;
import com.test.maxlukin.epochtimeconverter.Services.ConverterLogic;
import com.test.maxlukin.epochtimeconverter.Services.DatePickerFragment;
import com.test.maxlukin.epochtimeconverter.Services.impl.ConverterLogicImpl;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity implements
        View.OnTouchListener, View.OnClickListener {

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

                DialogFragment dataPickerFragment = new DatePickerFragment();
                valueHumanTime.setText(converterLogic.convertUnixToHumanTime(value));
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

                if((valueHumanTime.getText().toString().isEmpty())&&(valueUnixTime.isFocused())){
                    value = Long.parseLong(valueUnixTime.getText().toString());
                    valueHumanTime.setText(converterLogic.convertUnixToHumanTime(value));
                } else if((valueUnixTime.getText().toString().isEmpty())&&(valueHumanTime.isFocused())){

                } else {
                    Toast.makeText(ConverterActivity.this, "Please, enter your time to convert!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
