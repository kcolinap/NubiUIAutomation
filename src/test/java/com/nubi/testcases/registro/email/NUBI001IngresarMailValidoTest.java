package com.nubi.testcases.registro.email;

import com.nubi.screens.registroScreens.EmailScreen;
import com.nubi.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI001IngresarMailValidoTest extends TestBase {


    @BeforeTest
    public void init(){
        emailScreen = new EmailScreen(driver);
    }
    /*
        Este tc valida que: cuando se ingrese un email valido, el boton siguiente quedara habilitado
     */
    @Test
    public void validateEmailValido(){

        boolean aux=false;
        emailScreen.setEmail("test@test.com");
        aux = emailScreen.validarButtonSiguiiente();
        Assert.assertEquals(true, aux);
    }
}
