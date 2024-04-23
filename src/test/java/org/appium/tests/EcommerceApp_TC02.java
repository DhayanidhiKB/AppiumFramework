package org.appium.tests;


import org.appium.properties.UserConfig;
import org.appium.testUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceApp_TC02 extends BaseTest {


    @Test
    public void PlaceOrder() throws InterruptedException {

        formPage.setNameField(UserConfig.getProperties().name());
        formPage.setGender(UserConfig.getProperties().gender());
        formPage.setCountrySelection(UserConfig.getProperties().country());
        formPage.setFormSelection();

        productPage.addItemToCart(0);
        productPage.addItemToCart(0);
        productPage.goToCartPage();

        double totalSum = cartPage.getProductSum();
        double formattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum, formattedSum);

        cartPage.acceptTermsAndConditions();
        cartPage.submitOrder();

    }
}
