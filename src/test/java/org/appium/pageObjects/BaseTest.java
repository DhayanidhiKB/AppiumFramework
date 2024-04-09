package org.appium.pageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AppiumDriverLocalService server;
    public AndroidDriver driver;

    public FormPage formPage;
    public ProductPage productPage;
    public CartPage cartPage;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        server = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//Praveen//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        server.start();

        UiAutomator2Options ui = new UiAutomator2Options();
        ui.setDeviceName("Pixel7Pro");
        ui.setApp(System.getProperty("user.dir") + "\\src\\test\\resources\\General-Store.apk");

        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723/"), ui);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        objectsForPages();

    }

    public void objectsForPages() {
        formPage = new FormPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        server.stop();
    }
}

