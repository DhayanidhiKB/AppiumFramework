package org.appium.testUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.appium.pageObjects.CartPage;
import org.appium.pageObjects.FormPage;
import org.appium.pageObjects.ProductPage;
import org.appium.properties.UserConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import static org.appium.constants.ROOT_DIRECTORY;

public class BaseTest {

    public AppiumDriverLocalService server;
    public AndroidDriver driver;

    public FormPage formPage;
    public ProductPage productPage;
    public CartPage cartPage;


    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        server = new AppiumServiceBuilder()
                .withAppiumJS(new File(UserConfig.getProperties().appiumNodeJSProperty()))
                .withIPAddress(UserConfig.getProperties().ipAddress()).usingPort(UserConfig.getProperties().portNo()).build();
        server.start();

        UiAutomator2Options ui = new UiAutomator2Options();
        ui.setDeviceName(UserConfig.getProperties().deviceName());
        ui.setApp(ROOT_DIRECTORY +UserConfig.getProperties().appPath());

        driver = new AndroidDriver(server.getUrl(), ui);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

