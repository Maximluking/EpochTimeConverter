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
    private DateFormat simpleDateFormat;

    public ConverterLogic(){
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Helsinki"));

    }
    public String convertUnixToHumanTime(long valueLeft){
        return simpleDateFormat.format(new Date(valueLeft*1000L));
    }

    public long convertHumanToUnixTime(String valueRight) throws ParseException {
        Date date = simpleDateFormat.parse(valueRight );
        return date.getTime()/1000L;
    }
}
