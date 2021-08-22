package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutOverviewPage extends PageBase{

    public CheckoutOverviewPage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }

    @AndroidFindBy(accessibility = "test-FINISH")
    public MobileElement finish_button;


    @AndroidFindBy(accessibility = "test-CANCEL")
    MobileElement cancel_button;


    public void clickOnFinish(){ click(finish_button); }

    public void clickOnCancel(){ click(cancel_button);}
}
