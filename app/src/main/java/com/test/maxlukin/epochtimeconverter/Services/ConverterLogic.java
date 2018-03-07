package com.test.maxlukin.epochtimeconverter.Services;

import java.text.ParseException;

/**
 * Created by Zadrotisha on 28.02.2018.
 */

public interface ConverterLogic {

    String convertUnixToHumanTime(long unixTime);

    String convertHumanToUnixTime(String humanTime) throws ParseException;

}
