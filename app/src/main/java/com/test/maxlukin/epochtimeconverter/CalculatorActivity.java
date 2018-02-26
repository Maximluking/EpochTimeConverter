package com.test.maxlukin.epochtimeconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class CalculatorActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonConvert, buttonChangeOrientationFValues, buttonHyphen,
            buttonC, buttonColon;

    EditText valuLeftField, valueRightFileld;

    long valueLeft, valueRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonC = (Button)findViewById(R.id.buttonC);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "2");

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "3");

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "4");

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "5");

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "6");

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "7");

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "8");

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "9");

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuLeftField.setText(valuLeftField.getText() + "");

            }
        });

    }
}
