package com.nubi.screens.registroScreens.email.objects;

import com.nubi.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class GmailScreenObjects extends ScreenBase {
    public GmailScreenObjects(AndroidDriver driver){

        super(driver);

    }

    @AndroidFindBy(xpath="//android.view.View[@class='android.view.View'][0]")
    public WebElement groupEmail;

    public WebElement getGroupEmail(){
        return groupEmail;
    }
}
