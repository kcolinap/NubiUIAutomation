package com.nubi.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ComUtils {

    private static Properties prop = new Properties();

    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String APP_NAME;
    public static String BASE_PKG;
    private static String APPIUM_PORT;
    public static String PLATFORM_NAME;
    public static String PLATFORM_VERSION;
    public static String DEVICE_NAME;

    private static DesiredCapabilities caps = new DesiredCapabilities();
   // private static URL serverUrl;
    private static AndroidDriver driver;

    public static void loadConfigProp(String propertyFileName) throws IOException{

        String userDir = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(userDir + "\\src\\main\\Resources\\properties\\"+propertyFileName);
        prop.load(fis);

        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
        APP_NAME = prop.getProperty("app.path");
        APPIUM_PORT  = prop.getProperty("appiumserver.port");
        PLATFORM_NAME = prop.getProperty("platform.name");
        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
    }

    public static void setCapabilities(){

        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ComUtils.PLATFORM_VERSION);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ComUtils.PLATFORM_NAME);
        caps.setCapability(MobileCapabilityType.APP, ComUtils.APP_NAME);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, ComUtils.DEVICE_NAME);
    }

    public static AndroidDriver getDriver() throws MalformedURLException{

        String serverUrl = "http://127.0.0.1:" + APPIUM_PORT + "/wd/hub";
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(serverUrl), caps);
        driver = new AndroidDriver(new URL(serverUrl), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // AndroidDriver driver = new AndroidDriver(new URL(serverUrl), caps);

        return driver;
    }
}
