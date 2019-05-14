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

public class NUBI005RetomarRegistroScreenTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\RetomarRegistroScreen";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;

    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver)     ;
    }

/*
    @Test(priority = 2,
            dataProvider = "dataproviderRetomaDeRegistro", dataProviderClass = DataProviderRegistro.class)
    public void retomarRegistroDesdeMail(String email){

        try {

            ComUtils.takeScreeShoot(testPath, "RetomaAntes de cerrar.png");

            emailScreenActions.cerrarApp();

            driver.startActivity(new Activity("com.google.android.gm","ConversationListActivityGmail"));

            String token = confirmEmailScreenActions.devolverToken(email);
            confirmEmailScreenActions.iConfirmEmailFromDB(token);

            ComUtils.takeScreeShoot(testPath, "RetomaDespuesDeCerrar.png");


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }*/

    @Test(priority = 1)
    public void retomarRegistroDesdeApp(){

        try {

            String currentActivity=(driver.currentActivity());
            String currentPackage = driver.getCurrentPackage();

            ComUtils.takeScreeShoot(testPath, "RetomaAntes de cerrar.png");

            emailScreenActions.cerrarApp();


            driver.startActivity(new Activity(currentPackage,currentActivity));


            ComUtils.takeScreeShoot(testPath, "RetomaDespuesDeCerrar.png");


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

}
