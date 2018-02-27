package com.test.maxlukin.epochtimeconverter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.test.maxlukin.epochtimeconverter.Util.ConverterLogic;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity {

    Button buttonConvert;

    EditText valueLeftField, valueRightField;

    private ConverterLogic converterLogic;
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



            }
        });


    }
}
