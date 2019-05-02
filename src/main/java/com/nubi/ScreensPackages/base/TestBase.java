package com.nubi.ScreensPackages.base;

import com.nubi.Utils.ComUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static AndroidDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {

        ComUtils.loadConfigProp("AppTest.properties");
        ComUtils.setCapabilities();
        driver = ComUtils.getDriver();
    }

    @AfterSuite
    public void tearDown(){

        driver.quit();
    }
}
