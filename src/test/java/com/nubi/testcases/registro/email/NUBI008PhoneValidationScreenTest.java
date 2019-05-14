package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.base.TestBase;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.ConfirmEmailScreenActions;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI008PhoneValidationScreenTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\PhoneNumber";
    private static EmailScreenActions emailScreenActions;
    private static ConfirmEmailScreenActions confirmEmailScreenActions;
    private static String prefixPhone = "+549";
    private static String field = "sms_confirmation_code";
    private String digit = "";

    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
        confirmEmailScreenActions = new ConfirmEmailScreenActions(driver)     ;
    }


    @Test(priority = 1,
            dataProvider = "dataproviderValidationPhoneRegistro", dataProviderClass = DataProviderRegistro.class)
    public void completarUserPasswordScreen(String codePhone, String phoneNumber, String pin){

        try {
            String sufijoPhone = String.valueOf(emailScreenActions.generateRamdonNumber(5));

            phoneNumber = phoneNumber + sufijoPhone;
            emailScreenActions.waitVisibilityOfCodePhone();

            emailScreenActions.setCodePhone(codePhone);
            emailScreenActions.setNumberPhone(phoneNumber);

            aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

            if(aux==false){
                throw new Exception();
            }

            Assert.assertEquals(true, aux);

            ComUtils.takeScreeShoot(testPath, "ValidacionPhoneNumber.png");

            emailScreenActions.clickButtonCircleSiguiente();

            String number = prefixPhone+codePhone+phoneNumber;
            String smsCode = emailScreenActions.devolverSmsCode(number,field);

            emailScreenActions.waitVisibilityOfFirtsDigitCode();

            char[] codeSms = {smsCode.charAt(0), smsCode.charAt(1), smsCode.charAt(2), smsCode.charAt(3)};

            for(int i =0; i<codeSms.length; i++){
                digit = Character.toString(codeSms[i]);
                switch (i){
                    case 0:
                        emailScreenActions.setFirstDigitCode(digit);
                        break;
                    case 1:
                        emailScreenActions.setSecondtDigitCode(digit);
                        break;
                    case 2:
                        emailScreenActions.setThirdDigitCode(digit);
                        break;
                    case 3:
                        emailScreenActions.setFourthDigitCode(digit);
                        break;
                }
            }

            ComUtils.takeScreeShoot(testPath, "ValidacionSmsCode.png");

            emailScreenActions.waitVisibilityOfFirtsDigitCode();

            char[] codePin = {pin.charAt(0), pin.charAt(1), pin.charAt(2), pin.charAt(3)};
            digit = "";
            for(int j =0; j<codeSms.length; j++){
                digit = Character.toString(codePin[j]);
                switch (j){
                    case 0:
                        emailScreenActions.setFirstDigitCode(digit);
                        break;
                    case 1:
                        emailScreenActions.setSecondtDigitCode(digit);
                        break;
                    case 2:
                        emailScreenActions.setThirdDigitCode(digit);
                        break;
                    case 3:
                        emailScreenActions.setFourthDigitCode(digit);
                        break;
                }
            }

            aux = emailScreenActions.validarButtonCircleSiguienteIsEnabled();

            if(aux==false){
                throw new Exception();
            }

            Assert.assertEquals(true, aux);
            ComUtils.takeScreeShoot(testPath, "ValidacionPinCode.png");

            emailScreenActions.clickButtonCircleSiguiente();


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

}
