import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class L7_selenium_program {
    WebDriver driver;

    void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/");
    }

    String operation(String n1, String op , String n2) {
        for(int i=0; i<n1.length();i++) {
            driver.findElement(By.xpath("//span[@onclick=\"r(" + n1.charAt(i) + ")\"]")).click();
        }
        driver.findElement(By.xpath("//span[@onclick=\"r('"+op+"')\"]")).click();
        for(int i=0; i<n1.length();i++) {
            driver.findElement(By.xpath("//span[@onclick=\"r(" + n2.charAt(i) + ")\"]")).click();
        }
        driver.findElement(By.xpath("//span[@onclick=\"r('=')\"]")).click();
        WebElement result = driver.findElement(By.id("sciOutPut"));
        String expected_result = result.getText().trim();
        return expected_result;
    }

    void close_driver()
    {
        driver.close();
    }

    @Test(priority = 3)
    public void add()
    {
        initialize();
        Assert.assertEquals(operation("14","+","13"),"27");
        close_driver();
    }
    @Test(priority = 3)
    public void subtract()
    {
        initialize();
        Assert.assertEquals(operation("14","-","13"),"1");
        close_driver();
    }

    @Test(priority = 2)
    public void multiply()
    {
        initialize();
        Assert.assertEquals(operation("4","*","3"),"12");
        close_driver();
    }
}
