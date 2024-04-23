package org.appium.testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.appium.properties.UserConfig;
import org.appium.utils.AppiumUtils;
import static org.appium.constants.ROOT_DIRECTORY;

public class ExtentReporter {

    public static ExtentReports extentReports;

    public static ExtentReports getReport(){
        ExtentSparkReporter reporter=new ExtentSparkReporter(ROOT_DIRECTORY+ UserConfig.getProperties().reportPath() +  "_" + AppiumUtils.currentDateTime());
        reporter.config().setDocumentTitle("Mobile Automation Results");

        extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Test Engineer","Dhaya");
        return extentReports;
    }
}
