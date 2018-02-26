package com.test.maxlukin.epochtimeconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }
}

