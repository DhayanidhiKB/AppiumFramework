package org.appium.tests;


import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testCode {

    @Test
    public void testing(){
      /*  System.out.println(ROOT_DIRECTORY+ UserConfig.getProperties().appPath());
        System.out.println(UserConfig.getProperties().ipAddress());
        System.out.println(UserConfig.getProperties().portNo());
        System.out.println(UserConfig.getProperties().deviceName());
        System.out.println(UserConfig.getProperties().appiumNodeJSProperty());
        System.out.println(ROOT_DIRECTORY+ UserConfig.getProperties().reportPath());*/

        var date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(dateFormat.format(date));
    }
}
