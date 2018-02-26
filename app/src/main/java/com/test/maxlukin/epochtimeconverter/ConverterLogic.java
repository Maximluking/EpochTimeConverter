package com.test.maxlukin.epochtimeconverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterLogic {

    public String convertEpochToHumanTime(long valueLeft){
        Date date = new Date(valueLeft);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
        return format.format(date);
    }
}
