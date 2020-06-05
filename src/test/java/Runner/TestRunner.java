package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;

import static Keyword.Module.*;
import static Runner.TestInitialiser.*;


/**
 * @author Syed Caazimuddin
 */



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Feature"
        ,glue = {"stepDefinition"}
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-report.json"}


)


public class TestRunner {

@BeforeClass
    public static void beforeClass() throws MalformedURLException, InterruptedException {

    startAppiumServer();
    setDesiredCapability();
    loginDashboard();
    validCrendentials();
    skipPIN();
    termsAndConditions();
    handlingSystemError();


}


@AfterClass
    public static void afterClass(){

    stopAppiumServer();


}

}
