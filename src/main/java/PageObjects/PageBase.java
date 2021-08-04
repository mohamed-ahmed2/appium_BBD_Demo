package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBase {

    AppiumDriver driver;
    public static final long Waitime = 30;

    public PageBase(AppiumDriver appiumdriver){

        PageFactory.initElements(new AppiumFieldDecorator(appiumdriver,Duration.ofSeconds(10)), this);
        driver = appiumdriver;
    }

    public void waitForVisibility(MobileElement element){

        WebDriverWait wait = new WebDriverWait(driver,Waitime);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void enterText(MobileElement element , String text){

        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void click(MobileElement element){

        waitForVisibility(element);
        element.click();

    }
    public void clear(MobileElement element){

        waitForVisibility(element);
        element.clear();

    }

    public String getAttribute(MobileElement element , String attribute){

        waitForVisibility(element);
        return element.getAttribute(attribute);
    }




}
