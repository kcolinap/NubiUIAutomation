package com.nubi.screens.registroScreens.email.objects;

import com.nubi.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ConfirmEmailScreenObjects extends ScreenBase {


    public ConfirmEmailScreenObjects(AndroidDriver driver){

        super(driver);

    }

    private static WebElement element = null;

    //private AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enviamos un mail a tu cuenta']")
    public WebElement lblPrimaryMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Abrir Mail']")
    public WebElement btnAbrirMail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='com.tunubi.wallet:id/actionButtonLink']")
    public WebElement lnkModificarEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='com.tunubi.wallet:id/backButton']")
    public WebElement btnBack;

    @AndroidFindBy(xpath = "//android.widget.EditText[@id='com.tunubi.wallet:id/nameInput']")
    public WebElement inputNombres;


    public WebElement getBtnAbrirMail(){
        return btnAbrirMail;
    }

    public WebElement getLblPrimaryMessage(){
        return lblPrimaryMessage;
    }

    public WebElement getInputNombres(){
        return inputNombres;
    }



}
