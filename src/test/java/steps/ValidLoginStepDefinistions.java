package steps;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class ValidLoginStepDefinistions extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @Given("the user enters valid {string}")
    public void theUserEntersValid(String username) throws MalformedURLException {
        Setup();
        loginPage = new LoginPage(driver);
        loginPage.enterusername(username);

    }

    @And("he entered valid {string}")
    public void heEnteredValid(String pass) {
        loginPage = new LoginPage(driver);
        loginPage.enterpassword(pass);

    }

    @When("he clicks on login button")
    public void heClcikedonLogin() {
        loginPage.clickOnLogin();
    }
    @Then("he should be redirected to Home page")
    public void heShouldBeRedirectedToHomePage() {
        homePage = new HomePage(driver);
        homePage.waitForVisibility(homePage.products_text);
    }

}
