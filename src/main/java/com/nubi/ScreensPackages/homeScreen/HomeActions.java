package com.nubi.ScreensPackages.homeScreen;

import com.nubi.ScreensPackages.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeActions extends ScreenBase {

    public HomeActions(AndroidDriver driver){
        super(driver);
    }

    //private AndroidDriver driver;

    @AndroidFindBy(id="io.selendroid.testapp:id/my_text_field")
    public WebElement textField;

    @AndroidFindBy(id="io.selendroid.testapp:id/visibleButtonTest")
    public WebElement btnDisplayTextView;

    public HomeActions setString(String data){
        textField.sendKeys(data);
        return this;
    }

    public HomeActions clickBtnDisplayTextView(){
        btnDisplayTextView.click();
        return this;
    }
}
