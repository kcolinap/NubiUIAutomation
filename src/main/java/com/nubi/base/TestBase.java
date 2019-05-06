package com.nubi.base;

import com.nubi.screens.registroScreens.EmailScreen;
import com.nubi.Utils.ComUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static AndroidDriver driver;

    public static EmailScreen emailScreen;

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {


            ComUtils.loadConfigProp("NubiWalletApp.properties");
            ComUtils.setCapabilities();
            driver = ComUtils.getDriver();

    }

    @AfterSuite
    public void tearDown() throws IOException{

        driver.closeApp();
        driver.quit();
    }
}
