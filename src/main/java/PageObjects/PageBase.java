package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBase {

    AppiumDriver driver;
    public static final long Waitime = 30;

    public PageBase(AppiumDriver appiumdriver) {

        PageFactory.initElements(new AppiumFieldDecorator(appiumdriver, Duration.ofSeconds(10)), this);
        driver = appiumdriver;
    }

    public void waitForVisibility(MobileElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Waitime);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForDisappear(MobileElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Waitime);
        wait.until(ExpectedConditions.invisibilityOf(element));

    }
    public void enterText(MobileElement element, String text) {

        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void click(MobileElement element) {

        waitForVisibility(element);
        element.click();

    }

    public void clear(MobileElement element) {

        waitForVisibility(element);
        element.clear();

    }

    public String getAttribute(MobileElement element, String attribute) {

        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public String getText(MobileElement element) {

        waitForVisibility(element);
        return element.getText();
    }

    public TouchAction scroll() {
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int scrollStart = (int) (height * 0.8);
        int scrollEnd = (int) (height * 0.1);
        TouchAction touch = new TouchAction(driver).press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(0, scrollEnd)).release().perform();
        return touch;
    }

    public TouchAction scrollup() {
        Dimension dimension = driver.manage().window().getSize();
        int height = dimension.getHeight();
        int scrollStart = (int) (height * 0.1);
        int scrollEnd = (int) (height * 0.5);

        //TouchAction touch = new TouchAction(driver).press(PointOption.point(scrollStart, 0)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).moveTo(PointOption.point(scrollEnd, 0)).release().perform();
        TouchAction action = new TouchAction(driver);
        action.press(new PointOption().withCoordinates(366,453)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).moveTo(new PointOption().withCoordinates(345,862)).release().perform();

        return action;
    }



    public boolean isElementDisplayed(MobileElement el) {
        try {
            return el.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTextDisplayed(MobileElement el, String text) {
        try {
            String actual = el.getText();
            return actual.equals(text);

        } catch (Exception e) {
            return false;
        }


    }
}
