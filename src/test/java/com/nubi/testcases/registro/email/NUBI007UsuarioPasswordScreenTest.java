package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.base.TestBase;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.ConfirmEmailScreenActions;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI007UsuarioPasswordScreenTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\UserPassword";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;

    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver)     ;
    }


    @Test(priority = 1,
            dataProvider = "dataproviderUsuarioPasswordRegistro", dataProviderClass = DataProviderRegistro.class)
    public void completarUserPasswordScreen(String user, String pass){
        int sufijoUser = emailScreenActions.generateRamdonNumber(3);
        user = user + String.valueOf(sufijoUser);
        try {

            emailScreenActions.esperarVisibilidadInputUser();

            emailScreenActions.setUsuario(user);
            emailScreenActions.setPaswword(pass);

            aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

            if(aux==false){
                throw new Exception();
            }

            Assert.assertEquals(true, aux);

            ComUtils.takeScreeShoot(testPath, "ValidacionUserPassword.png");

            emailScreenActions.clickButtonCircleSiguiente();


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

}
