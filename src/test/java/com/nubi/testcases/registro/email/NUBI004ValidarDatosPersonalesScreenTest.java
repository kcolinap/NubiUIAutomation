package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.base.TestBase;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.ConfirmEmailScreenActions;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI004ValidarDatosPersonalesScreenTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\datosPersonales";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;
    String dniRandom = "95";

    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver)     ;
    }


    @Test(dataProvider = "dataproviderRegistroDatosPersonales", dataProviderClass = DataProviderRegistro.class)
    public void datosPersonalesScreenValidation(String nombres, String apellidos, String dni, String genero, String imgName){

        String[] datosPersonales = {"", "", "", ""};
        try {
            dniRandom=dniRandom+String.valueOf(emailScreenActions.generateRamdonNumber(6));

            if(!dni.contentEquals("")){
                datosPersonales[0] = nombres;
                datosPersonales[1] = apellidos;
                datosPersonales[2] = dniRandom;
                datosPersonales[3] = genero;
            }else{
                datosPersonales[0] = nombres;
                datosPersonales[1] = apellidos;
                datosPersonales[2] = dni;
                datosPersonales[3] = genero;
            }
            emailScreenActions.esperarVisibilidadInputNombres();

            String dato = "";

            if(nombres.contentEquals("") || apellidos.contentEquals("") || dni.contentEquals("") ||
                    genero.contentEquals("")){
                for (int i=0; i<datosPersonales.length; i++){
                    if((i==0 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setApellidos(apellidos);
                        emailScreenActions.setDni(dniRandom);

                        break;
                    }
                    if((i==1 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setNombres(nombres);
                        emailScreenActions.setApellidos("");
                        emailScreenActions.setDni(dniRandom);

                    }

                    if((i==2 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setNombres(nombres);
                        emailScreenActions.setApellidos(apellidos);
                        emailScreenActions.setDni("");

                        break;
                    }

                    if((i==3 && datosPersonales[i].contentEquals(""))){
                        emailScreenActions.setNombres(nombres);
                        emailScreenActions.setApellidos(apellidos);
                        emailScreenActions.setDni(dniRandom);

                        break;
                    }
                }

                aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

                if(aux==true){
                    throw new Exception();
                }

                Assert.assertEquals(false, aux);
            }else{
                emailScreenActions.setNombres(nombres);
                emailScreenActions.setApellidos(apellidos);
                emailScreenActions.setDni(dniRandom);
                if(genero.toUpperCase().contentEquals("H")){
                    emailScreenActions.clickMale();
                }else{
                    emailScreenActions.clickFemale();
                }

                aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

                if(aux==false){
                    throw new Exception();
                }

                Assert.assertEquals(true, aux);
            }

            ComUtils.takeScreeShoot(testPath, imgName+".png");

            emailScreenActions.clickButtonCircleSiguiente();


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

}
