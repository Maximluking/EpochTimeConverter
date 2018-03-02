package com.test.maxlukin.epochtimeconverter.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.test.maxlukin.epochtimeconverter.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }
}

