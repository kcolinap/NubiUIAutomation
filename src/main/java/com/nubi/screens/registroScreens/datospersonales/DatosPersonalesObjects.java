package com.nubi.screens.registroScreens.datospersonales;

import com.nubi.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DatosPersonalesObjects extends ScreenBase {

    public DatosPersonalesObjects(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Nombres']")
    public WebElement inputNombres;

    public WebElement getInputNombres(){
        return inputNombres;
    }
}
