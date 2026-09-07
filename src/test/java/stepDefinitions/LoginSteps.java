package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.DataTable;
import org.testng.Assert;
import pages.LoginPage;

import java.util.*;

public class LoginSteps {
    LoginPage loginPage=new LoginPage();
    @Given("I open the login page")
       public void openLoginPage(){
        loginPage.openLoginPage();
    }

        @When("I enter valid username and password")
        public void enterUsernamePassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        }

        @Then("I should be logged in successfully")
        public void loginSuccessfully() {
        String actualUrl= BaseClass.driver.getCurrentUrl();
      //  Assert.assertTrue(false);
            Assert.assertTrue(actualUrl.contains("inventory.html"));
            System.out.println("login sucess");
        }

 /*   @When("I enter username {String} and password {String}")
    public void iEnterInvalidUsernamePassword(String username,String password) {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("hihello");
        loginPage.clickLoginin();
    }*/

    @Then("I should see the login error message")
    public void iShouldSeeTheLoginErrorMessage() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(loginPage.errorMessageDisplayed());
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("I enter login details")
    public void iEnterLoginDetails( Map<String,String>data) {
        loginPage.enterUsername(data.get("username"));
        loginPage.enterPassword(data.get("password"));
        loginPage.clickLogin();
    }
}
