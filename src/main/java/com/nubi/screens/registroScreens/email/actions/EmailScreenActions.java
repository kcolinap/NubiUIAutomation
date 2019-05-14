package com.nubi.screens.registroScreens.email.actions;

import com.nubi.Utils.Actions;
import com.nubi.screens.registroScreens.email.objects.EmailScreenObjects;
import com.nubi.screens.registroScreens.email.objects.GmailScreenObjects;
import io.appium.java_client.android.AndroidDriver;

import java.sql.SQLException;

public class EmailScreenActions extends Actions {


    public EmailScreenActions(AndroidDriver driver){

        super(driver);

    }

    private Actions actions = new Actions(driver);
    private EmailScreenObjects emailScreenObjects = new EmailScreenObjects(driver);
    private GmailScreenObjects gmailScreenObjects = new GmailScreenObjects(driver);

    public EmailScreenActions setEmail(String email){
        actions.setText(emailScreenObjects.getInputEmail(), email);
        return this;
    }

    public boolean validarButtonSiguienteIsEnabled(){
       return actions.validarElementEnabled(emailScreenObjects.getBtnSiguiente());
    }

    public EmailScreenActions clickBtnSiguiente(){

        actions.clickOnElement(emailScreenObjects.getBtnSiguiente());
        return  this;
    }
    public boolean validarLblFormatoNoValidoIsDisplayed(){
       return actions.validarElementPresent(emailScreenObjects.getLblFormatoNoValido());
    }

    public EmailScreenActions clickBtnAbrirEmail(){

        actions.clickOnElement(emailScreenObjects.getBtnAbrirMail());
        return this;
    }

    public boolean validarPrimaryMessageIsDisplayed(){
        return actions.validarElementPresent(emailScreenObjects.getLblPrimaryMessage());
    }
    public boolean validarModificarEmailIsDisplayed(){
        return actions.validarElementPresent(emailScreenObjects.getLnkModificarEmail());
    }

    public void esperarVisibilidadElemento(){
        actions.waitForElementPresent(emailScreenObjects.getBtnAbrirMail());
    }

    public void esperarVisibilidadEmail(){
        actions.waitForElementPresent(gmailScreenObjects.getGroupEmail());
    }

    /*************************
     *
     * Acciones pantalla datos personales
     */

    public EmailScreenActions esperarVisibilidadInputNombres(){
        actions.waitForElementPresent(emailScreenObjects.getInputNombres());
        return this;
    }

    public EmailScreenActions setNombres(String nombres){
        actions.setText(emailScreenObjects.getInputNombres(), nombres);
        return this;
    }

    public EmailScreenActions setApellidos(String apellidos){
        actions.setText(emailScreenObjects.getInputApellidos(), apellidos);
        return this;
    }

    public EmailScreenActions setDni(String dni){
        actions.setText(emailScreenObjects.getInputDni(), dni);
        return this;
    }

    public EmailScreenActions clickMale(){
        actions.clickOnElement(emailScreenObjects.getOptButtonMale());
        return this;
    }
    public EmailScreenActions clickFemale(){
        actions.clickOnElement(emailScreenObjects.getOptButtonFemale());
        return this;
    }

    public boolean validarButtonCircleSiguienteIsEnabled(){
        return actions.validarElementEnabled(emailScreenObjects.getBtnCircleSiguiente());
    }

    public EmailScreenActions clickButtonCircleSiguiente(){
        actions.clickOnElement(emailScreenObjects.getBtnCircleSiguiente());
        return this;
    }


    /*********************************************/


    /*************************8
     * Datos cuil acciones
     ****************/
    public EmailScreenActions esperarVisibilidadInputCuil(){
        actions.waitForElementPresent(emailScreenObjects.getInputCuil());
        return this;
    }


    /****************************/

    /************************
     * Usiario password screen acciones
     ************************/
    public EmailScreenActions setUsuario(String text){
        actions.setText(emailScreenObjects.getInputUsuario(), text);
        return this;
    }

    public EmailScreenActions setPaswword(String text){
        actions.setText(emailScreenObjects.getInputPassword(), text);
        return this;
    }

    public EmailScreenActions esperarVisibilidadInputUser(){
        actions.waitForElementPresent(emailScreenObjects.getInputUsuario());
        return this;
    }

    /*****************************/


    /*********************************
     *  Phone validation screen
     ********************************/

    public EmailScreenActions waitVisibilityOfCodePhone(){
        actions.waitForElementPresent(emailScreenObjects.getInputCodePhone());
        return this;
    }

    public EmailScreenActions setCodePhone(String text){
        actions.setText(emailScreenObjects.getInputCodePhone(), text);
        return this;
    }

    public EmailScreenActions setNumberPhone(String text){
        actions.setText(emailScreenObjects.getInputPhoneNumber(), text);
        return this;
    }

    public EmailScreenActions waitVisibilityOfFirtsDigitCode(){
        actions.waitForElementPresent(emailScreenObjects.getInputFirstDigitCode());
        return this;
    }

    public EmailScreenActions setFirstDigitCode(String text){
        actions.setText(emailScreenObjects.getInputFirstDigitCode(), text);
        return this;
    }

    public EmailScreenActions setSecondtDigitCode(String text){
        actions.setText(emailScreenObjects.getInputSecondDigitCode(), text);
        return this;
    }

    public EmailScreenActions setThirdDigitCode(String text){
        actions.setText(emailScreenObjects.getInputThirdDigitCode(), text);
        return this;
    }
    public EmailScreenActions setFourthDigitCode(String text){
        actions.setText(emailScreenObjects.getInputFourthDigitCode(), text);
        return this;
    }

    /*********************************/

    /************************************
     *  TERMS AND CONDITIONS SCREEN
     **********************************/
    public EmailScreenActions waitVisibilityOfChkTerms(){
        actions.waitForElementPresent(emailScreenObjects.getChkTerms());
        return this;
    }

    public boolean chkTermsIsSelected(){
        return actions.validateElementIsChecked(emailScreenObjects.getChkTerms());
    }

    public boolean btnCreateAccountIsEnabled(){
        return actions.validarElementEnabled(emailScreenObjects.getBtnCreateAccount());
    }

    public EmailScreenActions clickChkTerms(){
        actions.clickOnElement(emailScreenObjects.getChkTerms());
        return this;
    }

    public EmailScreenActions clickBtnCreateAccount(){
        actions.clickOnElement(emailScreenObjects.getBtnCreateAccount());
        return this;
    }
    /*********************************/

    /************************************
     *      WELCOME SCREEN
     **********************************/
    public EmailScreenActions waitVisibilityOfLblWelcome(){
        actions.waitForElementPresent(emailScreenObjects.getLblWelcome());
        return this;
    }

    public EmailScreenActions clickBtnContinuar(){
        actions.clickOnElement(emailScreenObjects.getBtnContinuar());
        return this;
    }
    /*********************************/
    /********************************
     * DB actions
     ********************/
    public String devolverSmsCode(String number, String field) throws SQLException {
        String query = "select * from phone_data WHERE phone_number='"+number+"'";
        return actions.ConsultaBDSimple(query, field);
    }


}
