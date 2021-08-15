package steps;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import tests.TestBase;

import java.net.MalformedURLException;

public class AddToCard extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

// Background

    @Given("user is a logged in user")
    public void theUserIsALoggedInUser() throws MalformedURLException {
        Setup();
        loginPage = new LoginPage(driver);
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.clickOnLogin();
    }

    // Add one element to card
    @Given("the user in Home page")
    public void theUserInHomePage() {

        homePage = new HomePage(driver);
        homePage.waitForVisibility(homePage.products_text);
    }

    @When("he clicks on Add to card button")
    public void heClicksOnAddToCardButton() {
        homePage.click(homePage.addToCard_Button);


    }

    @Then("item should be added to the card correctly")
    public void itemShouldBeAddedToTheCardCorrectly() {

        String number_of_items = homePage.getText(homePage.card_button);
        Assert.assertEquals(Integer.parseInt(number_of_items), 1);


    }



    // Add multiple elements to card


    @Given("the user in the Home page")
    public void theUserInTheHomePage() throws MalformedURLException {
        homePage = new HomePage(driver);

    }

    @When("he clicks on Add button for more than one item")
    public void heClicksOnAddButtonForMoreThanItem() {
        homePage.click(homePage.addToCard_Button);
        homePage.click(homePage.addToCard_Button2);
        for (int i = 0; i < 3; i++) {
            if (homePage.isElementDisplayed(homePage.addToCard_Button)){
                homePage.click(homePage.addToCard_Button);
            } else {
                homePage.scroll();
            }
        }
    }

    @Then("items should be added to the card correctly")
    public void itemsShouldBeAddedToTheCardCorrectly() {

        String number_of_items = homePage.getText(homePage.card_button);
        Assert.assertEquals(Integer.parseInt(number_of_items), 4);
    }
}
