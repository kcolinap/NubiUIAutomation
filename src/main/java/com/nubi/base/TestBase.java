package com.nubi.base;

import com.nubi.Utils.ComUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public static AndroidDriver driver;

    //public static EmailScreen emailScreen;

    public static String path = System.getProperty("user.dir")+"\\screenshots";
    public static DateFormat dateTest = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
    public static String dateFolder = dateTest.format(new Date());
    public static String[] baseEmail = {"nwtest", "@yopmail.com"};

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
