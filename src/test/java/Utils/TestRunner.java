package Utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static java.lang.Thread.sleep;


@CucumberOptions(features = {"src/test/java/Features"},
        glue = {"Steps"}
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void BeforeSuite() {

    }

    @AfterSuite
    public void AfterSuite() {

    }
}



