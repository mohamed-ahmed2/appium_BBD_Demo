package steps;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.appium.java_client.touch.WaitOptions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import tests.TestBase;

import java.net.MalformedURLException;

public class RemoveFromCard extends TestBase{
    LoginPage loginPage;
    HomePage homePage;


    // Background

    @Given("the user is a logged in user")
    public void theUserIsALoggedInUser() throws MalformedURLException {
    Setup();
    loginPage = new LoginPage(driver);
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.clickOnLogin();
    }


    // remove one element from card
    @Given("the user is in the Home page")
    public void TheUserIsInHomePage() {
        homePage = new HomePage(driver);

    }
    @When("he clicks on remove button for an added item")
    public void heClicksOnRemoveButtonForAnAddedItem() {
        homePage.click(homePage.addToCard_Button);
        homePage.click(homePage.remove_button);
    }

    @Then("items should removed from the card correctly")
    public void itemsShouldRemovedFromTheCardCorrectly() {
        Assert.assertFalse(homePage.isTextDisplayed(homePage.card_button, "1"));


    }



    // remove multiple items from the card

    @Given("the user in the Home screen")
    public void theUserInTheHomeScreen() {

        homePage = new HomePage(driver);


    }

    @When("he clicks on remove button for the added items")
    public void heClicksOnRemoveButtonForTheAddedItems() throws InterruptedException {

        homePage.click(homePage.addToCard_Button);
        homePage.click(homePage.addToCard_Button2);

        for (int i = 0; i < 2; i++) {
            if (homePage.isElementDisplayed(homePage.addToCard_Button)){
                homePage.click(homePage.addToCard_Button);
                homePage.click(homePage.addToCard_Button);
                homePage.click(homePage.remove_button);
                Thread.sleep(30);
                homePage.click(homePage.remove_button);
            } else {
                homePage.scroll();
            }
        }
            homePage.scrollup();
            homePage.click(homePage.remove_button);
            homePage.click(homePage.remove_button);



        /*
        for (int i = 0; i < 3; i++) {
            if (homePage.isElementDisplayed(homePage.remove_button)){
                homePage.click(homePage.remove_button);
            } else {
                homePage.scrollup();
            }
        }
**/

    }


    @Then("the items should be removed from the card correctly")
    public void theItemsShouldBeRemovedFromTheCardCorrectly() {
        Assert.assertFalse(homePage.isTextDisplayed(homePage.card_button, "4"));

    }


}
