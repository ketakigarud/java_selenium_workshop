package Steps;

import Utils.ConfigUtil;
import Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BaseSteps extends TestContext {
    int explicit_wait;
    int implicit_wait;
    int pageload_time;
    String appURL;

    @Before
    public void initialize(Scenario scenario)
    {

        try {
             explicit_wait = Integer.parseInt(ConfigUtil.getPropValues("EXPLICIT_WAIT"));
             implicit_wait = Integer.parseInt(ConfigUtil.getPropValues("IMPLICIT_WAIT"));
             pageload_time = Integer.parseInt(ConfigUtil.getPropValues("PAGE_LOAD_TIMEOUT"));
             appURL = ConfigUtil.getPropValues("AppURL");
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        System.out.println("Before");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(explicit_wait));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait));   //implicit wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageload_time));  //page load timeout
        driver.get(appURL);
    }
    @After
    public void close_driver(Scenario scenario)
    {
        driver.quit();
    }
}
