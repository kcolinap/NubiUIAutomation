package com.nubi.ScreensPackages.registroScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

//Elementos de pagina registro
public class RegistroObjects {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public WebElement btnPreferences;
}
