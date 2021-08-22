package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CardPage extends PageBase{

    public CardPage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    public MobileElement checkOut_button;


}
