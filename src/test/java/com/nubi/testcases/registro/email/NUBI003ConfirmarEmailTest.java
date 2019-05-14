package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.base.TestBase;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.ConfirmEmailScreenActions;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import io.appium.java_client.android.Activity;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI003ConfirmarEmailTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\confirmEmail";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;
    private String emailRegistered="";
    private String emailarmed ="";
    private int sufijoMail;

    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver);
    }


    @Test
    public void confirmarEmail(){

        sufijoMail = emailScreenActions.generateRamdonNumber(3);
        emailarmed = baseEmail[0]+String.valueOf(sufijoMail)+baseEmail[1];
        emailRegistered = emailarmed;
        try {

            emailScreenActions.setEmail(emailarmed);
            aux = emailScreenActions.validarButtonSiguienteIsEnabled();// valida que el boton siguiente este habilitado

            if(aux==false){
                throw new Exception();
            }

            Assert.assertEquals(true, aux);

            //ComUtils.takeScreeShoot(testPath, "emailValido.png");

            emailScreenActions.clickBtnSiguiente();

            emailScreenActions.esperarVisibilidadElemento();
            emailScreenActions.validarPrimaryMessageIsDisplayed();
            emailScreenActions.validarModificarEmailIsDisplayed();


            emailScreenActions.clickBtnAbrirEmail();

            String token = confirmEmailScreenActions.devolverToken(emailarmed, "email_confirmation_jwt");
            confirmEmailScreenActions.iConfirmEmailFromDB(token);

            System.out.println(driver.currentActivity());

            emailScreenActions.esperarVisibilidadInputNombres();

            ComUtils.takeScreeShoot(testPath, "confirmarMail.png");



        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

    /*
    @Test(dataProvider = "dataproviderRegistroDatosPersonales", dataProviderClass = DataProviderRegistro.class)
    public void datosPersonalesScreenValidation(String nombres, String apellidos, String dni, String genero, String imgName){

        String[] datosPersonales = {nombres, apellidos, dni, genero};
        try {

            emailScreenActions.esperarVisibilidadInputNombres();

            String dato = "";

            if(nombres.contentEquals("") || apellidos.contentEquals("") || dni.contentEquals("") ||
                    genero.contentEquals("")){
                for (int i=0; i<datosPersonales.length; i++){
                    if((i==0 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setApellidos(apellidos);
                        emailScreenActions.setDni(dni);
                        if(genero.toUpperCase().contentEquals("H")){
                            emailScreenActions.clickMale();
                        }else{
                            emailScreenActions.clickFemale();
                        }

                        break;
                    }
                    if((i==1 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setNombres(nombres);
                        emailScreenActions.setDni(dni);
                        if(genero.toUpperCase().contentEquals("H")){
                            emailScreenActions.clickMale();
                        }else{
                            emailScreenActions.clickFemale();
                        }
                        break;
                    }

                    if((i==2 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setNombres(nombres);
                        emailScreenActions.setApellidos(apellidos);
                        //emailScreenActions.setDni(dni);
                        if(genero.toUpperCase().contentEquals("H")){
                            emailScreenActions.clickMale();
                        }else{
                            emailScreenActions.clickFemale();
                        }
                        break;
                    }

                    if((i==3 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setNombres(nombres);
                        emailScreenActions.setApellidos(apellidos);
                        emailScreenActions.setDni(dni);

                        break;
                    }
                }

                aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

                if(aux==true){
                    throw new Exception();
                }

                Assert.assertEquals(false, aux);
            }

            ComUtils.takeScreeShoot(testPath, imgName+".png");


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }*/

}
