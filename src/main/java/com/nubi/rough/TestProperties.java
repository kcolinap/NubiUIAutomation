package com.nubi.rough;

import com.nubi.ScreensPackages.homeScreen.HomeActions;
import com.nubi.Utils.ComUtils;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class TestProperties {

   public static AndroidDriver driver;

    public static void main(String[] args) throws IOException {

       ComUtils.loadConfigProp("AppTest.properties");
       ComUtils.setCapabilities();
       driver = ComUtils.getDriver();

        HomeActions homeActions = new HomeActions(driver);
        homeActions.setString("Hola");
        homeActions.clickBtnDisplayTextView();

        System.out.println("cha");
    }
}
