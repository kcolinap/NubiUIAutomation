package com.nubi.Utils;

import com.nubi.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.loading.PrivateClassLoader;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Actions extends ScreenBase {

    public Actions(AndroidDriver driver){

        super(driver);

    }

    WebDriverWait wait = new WebDriverWait(driver,30);

    DataBaseConnection con = new DataBaseConnection();

    private static String URLNubi = "http://tunubi.app/registration/confirm/";

    public void setText(WebElement element, String text){
        element.sendKeys(text);
        hideKeyword();
    }

    public void hideKeyword(){

        driver.hideKeyboard();
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public boolean validarElementEnabled(WebElement element){
        return element.isEnabled();
    }

    public boolean validarElementPresent(WebElement element){
        return element.isDisplayed();
    }

    public void waitForElementPresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void implicitWaitBySeconds(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
    }

    public void explicitWaitByElement(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.MILLISECONDS);
    }

    public boolean validateElementIsChecked(WebElement element){
        return element.isSelected();
    }

   public String ConsultaBDSimple(String query, String field) throws SQLException{
        con.iDataBaseConnection();
        String resultQuery = con.execute(query, field);
        con.closeConecction();
        return resultQuery;
   }

   public void iConfirmEmailFromDB(String token){
        driver.get(URLNubi+token);
   }

   public void cerrarApp(){
        driver.closeApp();
   }

   public int generateRamdonNumber(int lenght){
        int numberGenerated;
        switch (lenght){
            case 1:
                numberGenerated=  (int)(10 * Math.random());
                break;
            case 2:
                numberGenerated =  (int)(100 * Math.random());
                break;
            case 3:
                numberGenerated =  (int)(1000 * Math.random());
                break;
            case 4:
                numberGenerated = (int)(10000 * Math.random());
                break;
            case 5:
                numberGenerated = (int)(100000 * Math.random() + 1);
                break;
            case 6:
                numberGenerated = (int)(1000000 * Math.random());
                break;
            case 8:
                numberGenerated = (int)(100000000 * Math.random() +1);
                break;
                default:
                    numberGenerated  = (int)(1 * Math.random());
                    break;

        }

        return numberGenerated;
   }
}