package steps;

import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.TestBase;

import java.net.MalformedURLException;

public class CheckOut extends TestBase {

    @Given("the user has added elements to the card")
    public void theUserHasAddedElementsToTheCard() throws MalformedURLException {
        Setup();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.clickOnLogin();
        HomePage homePage = new HomePage(driver);
        homePage.waitForVisibility(homePage.products_text);
        homePage.click(homePage.addToCard_Button);
        homePage.click(homePage.addToCard_Button2);
        homePage.click(homePage.card_button);
    }

    @Given("the user in card page")
    public void theUserInCardPage() {
      CardPage cardPage = new CardPage(driver);
        cardPage.scroll();
        while (!cardPage.isElementDisplayed(cardPage.checkOut_button)){
            cardPage.scroll();
        }
        cardPage.click(cardPage.checkOut_button);

    }

    @When("he clicks on the checkout button and confirm the checkout")
    public void heClicksOnTheCheckoutButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName("user1");
        checkoutPage.enterLastName("buy");
        checkoutPage.enterZipCode("12345789");
        checkoutPage.clickOnContinue();

    }

    @Then("order should be checked out correctly")
    public void heShouldBeRedirectedToCheckoutPage() throws InterruptedException {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        while (!checkoutOverviewPage.isElementDisplayed(checkoutOverviewPage.finish_button)){
            checkoutOverviewPage.scroll();
        }
        checkoutOverviewPage.clickOnFinish();
        Thread.sleep(200);
            Assert.assertFalse(checkoutOverviewPage.isElementDisplayed(checkoutOverviewPage.finish_button));

        }
}
