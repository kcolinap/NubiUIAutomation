package com.nubi.screens.registroScreens.email.actions;

import com.nubi.Utils.Actions;
import com.nubi.screens.registroScreens.email.objects.ConfirmEmailScreenObjects;
import com.nubi.screens.registroScreens.email.objects.EmailScreenObjects;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;

public class ConfirmEmailScreenActions extends Actions {


    public ConfirmEmailScreenActions(AndroidDriver driver){

        super(driver);

    }

    private Actions actions = new Actions(driver);
    private ConfirmEmailScreenObjects confirmEmailScreenObjects = new ConfirmEmailScreenObjects(driver);


    public String devolverToken(String email, String field) throws SQLException {
        String query = "select * from email_registration WHERE EMAIL ='"+email+"'";
        return actions.ConsultaBDSimple(query, field);
    }

    public void esperarVisibilidadInputNombres(){
        actions.waitForElementPresent(confirmEmailScreenObjects.getInputNombres());
    }

    public ConfirmEmailScreenActions devolverScreen(){
        return this;
    }

}
