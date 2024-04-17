package org.appium.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceApp_TC01 extends BaseTest {

    @BeforeMethod
    public void preSetup() {
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
    }

    @Test
    public void ErrorValidation() {
        formPage.setNameField("");
        formPage.setFormSelection();
        formPage.validateErrorMessage();

    }

    @Test
    public void FillForm() {
        formPage.setNameField("Praveen");
        formPage.setGender("Male");
        formPage.setFormSelection();
        formPage.formPagePositiveCase();
    }


}
