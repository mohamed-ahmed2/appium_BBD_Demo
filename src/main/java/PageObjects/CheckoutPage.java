package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckoutPage extends PageBase{

    public CheckoutPage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }

    @AndroidFindBy(accessibility ="test-First Name")
    MobileElement firstName_textField;

    @AndroidFindBy(accessibility ="test-Last Name")
    MobileElement lastName_textField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    MobileElement zip_code_textField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    MobileElement continue_button;

    @AndroidFindBy(accessibility = "test-CANCEL")
    MobileElement cancel_button;



    public void enterFirstName(String firstName){ enterText(firstName_textField,firstName); }

    public void enterLastName(String lastName){
        enterText(lastName_textField,lastName);
    }

    public void enterZipCode(String zipCode){
        enterText(zip_code_textField,zipCode);
    }

    public void clickOnContinue(){ click(continue_button); }

    public void clickOnCancel(){ click(cancel_button); }



}
