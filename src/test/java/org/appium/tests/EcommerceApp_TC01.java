package org.appium.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import org.appium.properties.UserConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceApp_TC01 extends BaseTest {

    @BeforeMethod
    public void preSetup() {
        formPage.setActivity();
    }

    @Test
    public void ErrorValidation() {
        formPage.setNameField(UserConfig.getProperties().name());
        formPage.setFormSelection();
        formPage.validateErrorMessage();

    }

    @Test
    public void FillForm() {
        formPage.setNameField(UserConfig.getProperties().name());
        formPage.setGender(UserConfig.getProperties().gender());
        formPage.setFormSelection();
        formPage.formPagePositiveCase();
    }


}
