package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {
    public AppiumDriver driver;


    public void Setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage","com.swaglabsmobileapp");
        caps.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
        //caps.setCapability("app", System.getProperty("user.dir") + "\\apk\\ApiDemos.apk");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, caps);

    }

//

    //@AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }



}
