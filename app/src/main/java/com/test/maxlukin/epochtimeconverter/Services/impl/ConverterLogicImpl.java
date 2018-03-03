package com.test.maxlukin.epochtimeconverter.Services.impl;

import com.test.maxlukin.epochtimeconverter.Services.ConverterLogic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterLogicImpl implements ConverterLogic {
    private DateFormat simpleDateFormat;

    public ConverterLogicImpl(){
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
    }

    @Override
    public String convertUnixToHumanTime(long unixTime){
        return simpleDateFormat.format(new Date(unixTime*1000L));
    }

    @Override
    public String convertHumanToUnixTime(String humanTime) throws ParseException {
        Date date = simpleDateFormat.parse(humanTime);
        return "" + (date.getTime()/1000L);
    }
}
