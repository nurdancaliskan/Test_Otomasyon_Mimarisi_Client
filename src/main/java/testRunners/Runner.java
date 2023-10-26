package testRunners;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import util.DriverFactor;

public class Runner { // cucumber ile ilgili option eklenebilir buraya.
    //cucumberoptions bize raporlamayı sağlayacak.
@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"StepDefinitions","util"},
        tags = "", //@before, @after için
        plugin = {
                "summary","pretty","html:Reports/CucumberReport/Reports.html"   // cucumber için anahtar kelimeler //summary özey pretty raporun renklendirilmesi
        }

)
    public class runner extends AbstractTestNGCucumberTests { // extend ettiğimizde abstracttestngcucumber içindekileri aldık.
     AppiumDriver driver = DriverFactor.getDriver();

    }
}
