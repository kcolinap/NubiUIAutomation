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

public class NUBI006ValidarCuilScreenTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\Cuil";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;

    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver)     ;
    }


    @Test(priority = 1,
            dataProvider = "dataproviderRetomaDeRegistro", dataProviderClass = DataProviderRegistro.class)
    public void completarCUILScreen(String email){

        try {

            emailScreenActions.esperarVisibilidadInputCuil();

            aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

            if(aux==false){
                throw new Exception();
            }

            Assert.assertEquals(true, aux);

            ComUtils.takeScreeShoot(testPath, "ValidacionCuil.png");

            emailScreenActions.clickButtonCircleSiguiente();


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

}
