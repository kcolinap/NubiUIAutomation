package com.nubi.base;

import com.nubi.Utils.ComUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class    ScreenBase {

    public static AndroidDriver driver;

    public ScreenBase(AndroidDriver driver){

        this.driver = driver;
        loadElements();
    }

    public void loadElements(){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitTime() throws InterruptedException{
        Thread.sleep(ComUtils.DEFAULT_WAIT_TIME);
    }

    public void hideKeyword(){
        driver.hideKeyboard();
    }
}
