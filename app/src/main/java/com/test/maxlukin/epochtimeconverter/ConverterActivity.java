package com.test.maxlukin.epochtimeconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.test.maxlukin.epochtimeconverter.Util.ConverterLogic;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonC, buttonConvert, buttonBackSpace;

    EditText valueLeftField, valueRightField;

    private long valueLeft;
    private String valueRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        final ConverterLogic converterLogic = new ConverterLogic();

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonC = findViewById(R.id.buttonC);
        buttonBackSpace = findViewById(R.id.buttonBackSpace);
        buttonConvert = findViewById(R.id.buttonConvert);
        valueLeftField = findViewById(R.id.valueLeftField);
        valueRightField = findViewById(R.id.valueRightField);


        valueLeftField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueRightField.setText("");

                button0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "0");
                    }
                });

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "1");
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "2");

                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "3");

                    }
                });

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "4");

                    }
                });

                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "5");

                    }
                });

                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "6");

                    }
                });

                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "7");

                    }
                });

                button8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "8");

                    }
                });

                button9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText(valueLeftField.getText() + "9");

                    }
                });

                buttonC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        valueLeftField.setText("");
                        valueRightField.setText("");

                    }
                });

                buttonBackSpace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

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
