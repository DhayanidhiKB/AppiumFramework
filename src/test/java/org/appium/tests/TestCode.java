package org.appium.tests;

import org.appium.properties.UserConfig;
import org.testng.annotations.Test;

public class TestCode {

    @Test
    public void owner(){
        System.out.println(UserConfig.getProperties().name());
        System.out.println(UserConfig.getProperties().gender());
        System.out.println(UserConfig.getProperties().country());
        System.out.println(UserConfig.getProperties().hashCode());
    }
}
