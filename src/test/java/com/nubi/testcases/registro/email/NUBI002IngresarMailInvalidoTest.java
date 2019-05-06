package com.nubi.testcases.registro.email;

import com.nubi.screens.registroScreens.EmailScreen;
import com.nubi.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI002IngresarMailInvalidoTest extends TestBase {

    private boolean aux = false;
    //public EmailScreen rActions = new EmailScreen(driver);
    @BeforeTest
    public void initTest(){
        EmailScreen rActions = new EmailScreen(driver);
    }

    /*
        Validar un email sin @
     */
    @Test
    public void validateSinArroba(){

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("testtest.com");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);

    }

    /*
        Validar un email sin .com
     */
    @Test
    public void validateSinCom(){

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("testtest@");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);

    }

    /*
        Validar un email sin puntos
     */
    @Test
    public void validateSinPuntos(){

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("testtest@com");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);

    }

    /*
        Validar campo email vacio
     */
    @Test
    public void validateSinEmail(){

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);

    }

    /*
        Validar con caracteres especiales excepto(@,.,-,_)
     */
    @Test
    public void validateCaracteresEspeciales() throws InterruptedException{

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("test#*@test.com");
        rActions.waitTime();
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);
        aux=rActions.validarLabelFormatoNoValido();
        Assert.assertEquals(aux, true);

    }

    /*
        Validar con una letra
     */
    @Test
    public void validateEmailConLetra(){

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("t");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);


    }

    /*
        Validar con un numero
     */
    @Test
    public void validateEmailConNumero(){

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail("2");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);

    }

    /*
        Validar con email que supera los 254 caracteres
     */
    @Test
    public void validateEmailConMaximoCaracteres(){

        int resultado;
        char letra;
        String texto ="";

        for (int i=0; i<257; i++){
            resultado=(int)(Math.random()*26+65);//Sumamos al numero de letras (sin ñ) el valor en ASCII
            letra = (char)resultado;
            texto+=letra;
        }

        EmailScreen rActions = new EmailScreen(driver);
        rActions.setEmail(texto+"@test.com");
        aux = rActions.validarButtonSiguiiente();
        Assert.assertEquals(aux, false);
        aux=rActions.validarLabelFormatoNoValido();
        Assert.assertEquals(aux, true);
    }
}
