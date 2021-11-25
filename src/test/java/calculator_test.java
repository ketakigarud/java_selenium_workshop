import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class calculator_test {
    WebDriver driver;
    Calculator_Page calc_page;
    @BeforeTest()
    void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/");
        calc_page = new Calculator_Page(driver);
    }
    @AfterTest
    void close_driver() {
        driver.close();
    }
        @Test(priority = 3)
        public void add()
        {
            Assert.assertEquals(calc_page.calculate("14","+","13"),"27");
        }
        @Test(priority = 3)
        public void subtract()
        {
            Assert.assertEquals(calc_page.calculate("14","-","13"),"1");
        }

        @Test(priority = 2)
        public void multiply()
        {
            Assert.assertEquals(calc_page.calculate("4","*","3"),"12");
        }
    }

