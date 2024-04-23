package org.appium.tests;

import org.appium.properties.UserConfig;
import org.appium.testUtils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EcommerceApp_TC01 extends BaseTest {

    @BeforeMethod
    public void preSetup() {
        formPage.setActivity();
    }

    @Test
    public void ErrorValidation() {
        formPage.setNameField("");
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
