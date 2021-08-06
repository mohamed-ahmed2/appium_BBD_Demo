package steps;

import PageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.TestBase;

import java.net.MalformedURLException;

public class InvalidLoginStepDefinitions extends TestBase {


    LoginPage loginPage;
    @Given("he entered invalid {string}")
    public void heEnteredInvalidUsername(String username ) throws MalformedURLException {
        Setup();
        loginPage = new LoginPage(driver);
        loginPage.enterusername(username);
    }

    @Given("he write invalid {string}")
    public void heEnteredInvalidPassword(String password) {
        loginPage.enterpassword(password);
    }

    @Given("he clicked on login button")
    public void heClickedOnLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
    loginPage.waitForVisibility(loginPage.error_message);
    }
}
