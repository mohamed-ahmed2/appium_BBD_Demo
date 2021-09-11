package PageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutCompletePage extends PageBase{

    public CheckoutCompletePage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    public MobileElement thank_you_text;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK HOME']")
    public MobileElement backHome_button;

 }
