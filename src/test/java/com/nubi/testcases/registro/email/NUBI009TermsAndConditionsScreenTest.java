package com.nubi.testcases.registro.email;

import com.nubi.Utils.ComUtils;
import com.nubi.base.TestBase;
import com.nubi.dataproviders.DataProviderRegistro;
import com.nubi.screens.registroScreens.email.actions.ConfirmEmailScreenActions;
import com.nubi.screens.registroScreens.email.actions.EmailScreenActions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NUBI009TermsAndConditionsScreenTest extends TestBase {

    private boolean aux = false;
    private static String testPath = path + "\\registro\\TermsConditions";
    private static EmailScreenActions emailScreenActions;


    @BeforeTest
    public void initTest(){
        emailScreenActions = new EmailScreenActions(driver);
    }


    @Test
    public void completarTermsAndConditionsScreen(){

        try {
            emailScreenActions.waitVisibilityOfChkTerms();
            emailScreenActions.implicitWaitBySeconds(600);


            aux = emailScreenActions.chkTermsIsSelected();
            Assert.assertEquals(false,aux);

            aux = emailScreenActions.btnCreateAccountIsEnabled();
            Assert.assertEquals(false, aux);

            emailScreenActions.clickChkTerms();
            emailScreenActions.implicitWaitBySeconds(300);

            aux = emailScreenActions.btnCreateAccountIsEnabled();
            Assert.assertEquals(true, aux);

            ComUtils.takeScreeShoot(testPath, "ValidacionTerms.png");

            emailScreenActions.clickBtnCreateAccount();

            emailScreenActions.waitVisibilityOfLblWelcome();
            emailScreenActions.implicitWaitBySeconds(500);


        }catch (Exception e){

            e.printStackTrace();
            ComUtils.takeScreeShoot(testPath, "Error.png");
            //Assert.assertEquals(true, aux);

        }
    }

}
