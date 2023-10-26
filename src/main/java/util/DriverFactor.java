package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Appiumun ayağı kalkması için
public class DriverFactor {
    static AppiumDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities; //appiumdaki uidid gibi şeyler

    public static AppiumDriver initilalize_Driver(String browser) {
        properties = ConfigReader.getProperties(); // configreaderdan proper getir.
        capabilities = new DesiredCapabilities(); //ilk defa eklediğimiz için ekledik. appiumda ihtiyac var.
        if (browser.equals("Android")) {
            capabilities.setCapability("platformName", "Android");//capabilityin ayarının yapılması.
            capabilities.setCapability("udid", "");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
        } else if (browser.equals("IOS")) {
            capabilities.setCapability("platformName", "IOS");//capabilityin ayarının yapılması.
            capabilities.setCapability("udid", "");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
        }
        try {
            driver = new AppiumDriver(new URL("https://0.0.0.0:4723/wd/hub"), capabilities); //appium haberleşmesi
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS); //driver la ilgili özellikleri tanımlarız. seleniumun özelliği.config.propertieste tanımlanmıştı. ordaki bekleme süresini çekti.
        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}