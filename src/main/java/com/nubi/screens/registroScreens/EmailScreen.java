package com.nubi.screens.registroScreens;

import com.nubi.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EmailScreen extends ScreenBase {

    private boolean aux = false;

    public EmailScreen(AndroidDriver driver){

        super(driver);

    }

    //private AndroidDriver driver;

    @AndroidFindBy(xpath="//android.widget.EditText[@class='android.widget.EditText']")
    public WebElement inputEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Siguiente']")
    public WebElement btnSiguiente;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='  Formato de email no válido']")
    public WebElement lblFormatoNoValido;


    public EmailScreen setEmail(String email){
        inputEmail.sendKeys(email);
        hideKeyword();
        return this;
    }

    public EmailScreen clickButtonSiguiente(){
        return this;
    }

    public boolean validarButtonSiguiiente(){
        aux = btnSiguiente.isEnabled();
        return aux;
    }

    public boolean validarLabelFormatoNoValido(){
        aux = lblFormatoNoValido.isDisplayed();
        return aux;
    }
}
