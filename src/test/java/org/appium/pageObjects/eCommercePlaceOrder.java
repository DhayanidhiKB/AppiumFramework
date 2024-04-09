package org.appium.pageObjects;


import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommercePlaceOrder extends BaseTest {


    @Test
    public void FillForm() throws InterruptedException {

        formPage.setNameField("Praveen");
        formPage.setGender("Male");
        formPage.setCountrySelection("Argentina");
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
