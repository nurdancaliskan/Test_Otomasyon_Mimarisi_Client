package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {
    AppiumDriver appiumDriver;
    WebDriverWait wait;
    Actions actions;

    public ElementHelper(AppiumDriver appiumDriver){
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        this.actions = new Actions(appiumDriver);
    }

}
