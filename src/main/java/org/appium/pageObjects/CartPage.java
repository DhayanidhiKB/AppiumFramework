package org.appium.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.appium.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver driver;

    public CartPage(AndroidDriver driver){
        super(driver);
       this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productList;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    private WebElement termsButton;

    @AndroidFindBy(id="android:id/button1")
    private WebElement acceptButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedButton;

    @AndroidFindBy(className="android.widget.CheckBox")
    private WebElement checkbox;

    public List<WebElement> getProductList(){
        return  productList;
    }

    public double getProductSum(){
        int count=productList.size();
        double totalSum=0;

        for (int i=0; i<count;i++){
            String amountString=productList.get(i).getText();
            Double price=getFormattedAmount(amountString);
            totalSum=totalSum+price;
        }
        return totalSum;
    }

    public Double getTotalAmountDisplayed(){
            return getFormattedAmount(totalAmount.getText());
    }

    public void acceptTermsAndConditions(){
        longPressAction(termsButton);
        acceptButton.click();
    }

    public void submitOrder(){
        checkbox.click();
        proceedButton.click();
    }

    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

}
