package com.test.maxlukin.epochtimeconverter.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Max.Tracker.NB on 26.02.2018.
 */

public class ConverterLogic {
    private static DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String convertUnixToHumanTime(long valueLeft){
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
        return simpleDateFormat.format(new Date(valueLeft*1000L));
    }

    public static long convertHumanToUnixTime(String valueRight) throws ParseException {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));
        Date date = simpleDateFormat.parse(valueRight );
        return date.getTime()/1000L;
    }
}
