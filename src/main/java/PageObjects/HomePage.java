package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }
    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
   public MobileElement products_text;

}
