package org.appium.utils;

import io.appium.java_client.AppiumDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;

public class AppiumUtils {

    public AppiumDriver driver;

    public AppiumUtils(AppiumDriver driver){
        this.driver=driver;
    }

    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public static String currentDateTime() {
        var date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd-HH-mm-ss");
        return dateFormat.format(date);
    }

}
