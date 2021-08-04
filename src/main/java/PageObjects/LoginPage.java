package PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends PageBase {

    public LoginPage(AppiumDriver appiumdriver) {
        super(appiumdriver);
    }

    @AndroidFindBy(accessibility = "test-Username")
    MobileElement loginTextField;
    @AndroidFindBy(accessibility = "test-Password")
    MobileElement passwordTextField;
    @AndroidFindBy(accessibility = "test-LOGIN")
    MobileElement loginButton;
    @AndroidFindBy(accessibility = "test-Error message")
    public MobileElement error_message;

    public void enterusername(String username){
        enterText(loginTextField,username);
    }

    public void enterpassword(String password){
        enterText(passwordTextField,password);
    }

    public void clickOnLogin(){

        click(loginButton);
    }

}
