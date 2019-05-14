package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.ConfirmEmailScreenActions;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import com.nubi.base.TestBase;
import io.appium.java_client.android.Activity;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI001IngresarMailValidoTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\email";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;

    @BeforeTest
    public void init(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver);
    }
    /*
        Este tc valida que: cuando se ingrese un email valido, el boton siguiente quedara habilitado
     */
    @Test(dataProvider = "dataproviderRegistroEmailValido", dataProviderClass = DataProviderRegistro.class)
    public void validateEmailValido(String email){

        try {

            emailScreenActions.setEmail(email);
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

            ComUtils.takeScreeShoot(testPath, "emailValido.png");

            /*
            //confirmEmailScreenActions.clickBtnAbrirEmail();
            //confirmEmailScreenActions.getLinkToken();
            //Comienza activity de gmail
            String activity = driver.currentActivity();
            driver.startActivity(new Activity("com.google.android.gm","ConversationListActivityGmail"));

            System.out.println(driver.currentActivity());

            driver.startActivity(new Activity("com.nubi.registerFeature.view","RegistrationActivity"));*/


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "emailValidoError.png");
            Assert.assertEquals(true, aux);

        }

    }

    @AfterTest
    public void endTest(){

    }
}
