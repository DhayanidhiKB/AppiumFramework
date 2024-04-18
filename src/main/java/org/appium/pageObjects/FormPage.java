package org.appium.pageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appium.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FormPage extends AndroidActions {

    AndroidDriver driver;

    public FormPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
    private WebElement femaleGenderField;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleGenderField;

    @AndroidFindBy(id="android:id/text1")
    private WebElement countrySelection;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement submitForm;

    @AndroidFindBy(xpath ="(//android.widget.Toast)[1]")
    private WebElement errorMessage;

    @AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
    private List<WebElement> formPageValidation;

    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender){
        if(gender.contains("Female"))
            femaleGenderField.click();
        else
            maleGenderField.click();
    }

    public void setCountrySelection(String countryName){
        countrySelection.click();
        ScrollGesture(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }

    public void setFormSelection(){
        submitForm.click();
    }

    public void validateErrorMessage(){
        String attributeName=errorMessage.getAttribute("name");
        Assert.assertEquals(attributeName, "Please enter your name");
    }

    public void formPagePositiveCase(){
        formPageValidation.isEmpty();
    }

    public void setActivity(){
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
    }
}
