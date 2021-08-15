package PageObjects;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }

    int counter;
    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
   public MobileElement products_text;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]")
    public MobileElement addToCard_Button;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])")
    public MobileElement addToCard_Button2;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    public MobileElement card_button;
    @AndroidFindBy(accessibility= "test-REMOVE")
    public MobileElement remove_button;


    public By setCard_counter(int counter){
        By Card_button = By.xpath("//android.widget.TextView[@text='"+Integer.toString(counter)+"')]");
        return Card_button;
    }


}