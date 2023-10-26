package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {
    // Ne zaman kullanırız? ör;browser ı başlatırken
    //bunları bir kez tanımlayıp kullanıcaz işlerde çağırarak.
    AppiumDriver appiumDriver;
    Properties properties;

    @Before // başlattıkç
    public void before(){
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");   //parallel.xlm den çekmeye yaradı kendi browserımız
        properties = ConfigReader.initialize_Properties();
        appiumDriver = DriverFactor.initilalize_Driver(browser);
    }

    @After
    public void after(){
        appiumDriver.quit();

    }
}
