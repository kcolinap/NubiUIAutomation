package com.nubi.screens.registroScreens.email.objects;

import com.nubi.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EmailScreenObjects extends ScreenBase {


    public EmailScreenObjects(AndroidDriver driver){

        super(driver);

    }

    private static WebElement element = null;

    //private AndroidDriver driver;

    /****
     * Screen pantalla email
     */

    @AndroidFindBy(xpath="//android.widget.EditText[@class='android.widget.EditText']")
    public WebElement inputEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Siguiente']")
    public WebElement btnSiguiente;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='  Formato de email no válido']")
    public WebElement lblFormatoNoValido;

    public WebElement getInputEmail(){
        return inputEmail;
    }

    public WebElement getBtnSiguiente(){
        return btnSiguiente;
    }
    public WebElement getLblFormatoNoValido(){
        return lblFormatoNoValido;
    }

    /*****************************
     *
     */

    /***********
     * Screen confirmar mail
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enviamos un mail a tu cuenta']")
    public WebElement lblPrimaryMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Abrir Mail']")
    public WebElement btnAbrirMail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Modificar email']")
    public WebElement lnkModificarEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@id='com.tunubi.wallet:id/backButton']")
    public WebElement btnBack;

    public WebElement getBtnAbrirMail(){
        return btnAbrirMail;
    }

    public WebElement getLblPrimaryMessage(){
        return lblPrimaryMessage;
    }

    public WebElement getLnkModificarEmail(){
        return lnkModificarEmail;
    }

    /*****************************************/


    /**********************************
     *
     * Screen datos personales
     ********************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/nameInput")
    public WebElement inputNombres;

    @AndroidFindBy(id = "com.tunubi.wallet:id/lastNameInput")
    public WebElement inputApellidos;

    @AndroidFindBy(id = "com.tunubi.wallet:id/dniInput")
    public WebElement inputDni;

    @AndroidFindBy(id = "com.tunubi.wallet:id/maleGenderOption")
    public WebElement optButtonMale;

    @AndroidFindBy(id = "com.tunubi.wallet:id/femaleGenderOption")
    public WebElement optButtonFemale;

    @AndroidFindBy(id = "com.tunubi.wallet:id/circleButton")
    public WebElement btnCircleSiguiente;


    public WebElement getInputNombres(){
        return inputNombres;
    }

    public WebElement getInputApellidos(){
        return inputApellidos;
    }

    public WebElement getInputDni(){
        return inputDni;
    }

    public WebElement getOptButtonMale(){
        return optButtonMale;
    }
    public WebElement getOptButtonFemale(){
        return optButtonFemale;
    }

    public WebElement getBtnCircleSiguiente(){
        return btnCircleSiguiente;
    }

    /********************************************/


    /*************************
     * Screen cuil
     *
     ******************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/dniInput")
    public WebElement inputCuil;

    public WebElement getInputCuil(){
        return inputCuil;
    }

    /**********************************/


    /****************************
     *      Screen creacion de usuario
     ***************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/userInput")
    public WebElement inputUsuario;

    @AndroidFindBy(id = "com.tunubi.wallet:id/passwordInput")
    public WebElement inputPassword;

    public WebElement getInputUsuario(){
        return inputUsuario;
    }

    public WebElement getInputPassword(){
        return inputPassword;
    }
    /********************************/


    /*********************************
     * SCREEN validacion de telefono
     **********************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/areaCodeInput")
    public WebElement inputCodePhone;

    @AndroidFindBy(id = "com.tunubi.wallet:id/phoneInput")
    public WebElement inputPhoneNumber;

    @AndroidFindBy(id = "com.tunubi.wallet:id/firstDigitInput")
    public WebElement inputFirstDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/secondDigitInput")
    public WebElement inputSecondDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/thirdDigitInput")
    public WebElement inputThirdDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/fourthDigitInput")
    public WebElement inputFourthDigitCode;

    public WebElement getInputCodePhone(){
        return inputCodePhone;
    }

    public WebElement getInputPhoneNumber(){
        return inputPhoneNumber;
    }

    public WebElement getInputFirstDigitCode(){
        return inputFirstDigitCode;
    }

    public WebElement getInputSecondDigitCode(){
        return inputSecondDigitCode;
    }

    public WebElement getInputThirdDigitCode(){
        return inputThirdDigitCode;
    }

    public WebElement getInputFourthDigitCode(){
        return inputFourthDigitCode;
    }

    /**********************************/


    /********************************************
     * TERMINOS Y CONDICIONES SCREEN
     *******************************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/checkboxTerms")
    public WebElement chkTerms;

    @AndroidFindBy(id = "com.tunubi.wallet:id/createAccountButton")
    public WebElement btnCreateAccount;

    public WebElement getChkTerms(){
        return chkTerms;
    }

    public WebElement getBtnCreateAccount(){
        return btnCreateAccount;
    }
    /******************************************/


    /******************************************
     *  Welcome screen
     *****************************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/welcome_message")
    public WebElement lblWelcome;

    @AndroidFindBy(id = "com.tunubi.wallet:id/actionButtonPrimary")
    public WebElement btnContinuar;

    public WebElement getLblWelcome(){
        return lblWelcome;
    }

    public WebElement getBtnContinuar(){
        return btnContinuar;
    }
    /*****************************************/

}
