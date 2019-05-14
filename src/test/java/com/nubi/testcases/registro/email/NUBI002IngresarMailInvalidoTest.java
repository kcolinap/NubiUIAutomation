package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.nubi.base.TestBase;

public class NUBI002IngresarMailInvalidoTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\datosPersonales";
    private static EmailScreenActions emailScreenActions;

    @BeforeTest
    public void initTest(){
        try{
            setUp();
        }catch (Exception e){
            e.printStackTrace();
        }

        emailScreenActions = new EmailScreenActions(driver);
    }


    @Test(dataProvider = "dataproviderRegistroEmailInvalido", dataProviderClass = DataProviderRegistro.class)
    public void validateEmailInvalido(String email, String imgName){

        try {

            emailScreenActions.setEmail(email);
            aux = emailScreenActions.validarButtonSiguienteIsEnabled();

            if(imgName.contentEquals("carEspeciales")){
                if(aux==true){
                    throw new Exception();
                }

                Assert.assertEquals(false, aux);//Assert del boton siguiente, se espera false

                aux=emailScreenActions.validarLblFormatoNoValidoIsDisplayed();

                if(aux==false){
                    throw new Exception();
                }
                Assert.assertEquals(true, aux);//Assert del text formato no valido, se espera true


            }else{
                if(aux==true){
                    throw new Exception();
                }

                Assert.assertEquals(false, aux);//Assert del boton siguiente, se espera false
            }


            ComUtils.takeScreeShootIter(testPath, dateFolder, imgName+".png");

        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShootIter(testPath, dateFolder, "emailInValidoError.png");
            Assert.assertEquals(false, aux);

        }
    }

    /*
        Validar con email que supera los 254 caracteres
     */
    @Test()
    public void validateEmailConMaximoCaracteres(){

        int resultado;
        char letra;
        String texto ="";

        try{
            for (int i=0; i<257; i++){
                resultado=(int)(Math.random()*26+65);//Sumamos al numero de letras (sin ñ) el valor en ASCII
                letra = (char)resultado;
                texto+=letra;
            }

            emailScreenActions.setEmail(texto);
            aux = emailScreenActions.validarButtonSiguienteIsEnabled();
            if(aux==true){
                throw new Exception();
            }
            Assert.assertEquals(false, aux);

            aux=emailScreenActions.validarLblFormatoNoValidoIsDisplayed();
            if(aux==false){
                throw new Exception();
            }
            Assert.assertEquals(true, aux);

            ComUtils.takeScreeShootIter(testPath, dateFolder, "maximocaracteres.png");

        }catch (Exception e){
            e.printStackTrace();
            ComUtils.takeScreeShootIter(testPath, dateFolder, "emailInValidoError.png");
            Assert.assertEquals(true, aux);
        }

    }
}
