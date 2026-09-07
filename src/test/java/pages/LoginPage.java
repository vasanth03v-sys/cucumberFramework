package pages;

import base.BaseClass;
import org.openqa.selenium.By;

public class LoginPage {
    By username= By.id("user-name");
    By password=By.id("password");
    By loginButton=By.id("login-button");
    By errorMessage=By.cssSelector("[data-test='error']");

    public void openLoginPage() {
        BaseClass.driver.get(BaseClass.properties.getProperty("url"));
    }

    public void enterUsername(String value){
        BaseClass.waitForElement(username);
        BaseClass.driver.findElement(username).sendKeys(value);
    }
    public void enterPassword(String value){
        BaseClass.waitForElement(password);
        BaseClass.driver.findElement(password).sendKeys(value);
    }
    public void clickLogin(){
        BaseClass.waitForElement(loginButton);
        BaseClass.driver.findElement(loginButton).click();
    }
    public boolean errorMessageDisplayed(){
        return BaseClass.driver.findElement(errorMessage).isDisplayed();
    }
}
