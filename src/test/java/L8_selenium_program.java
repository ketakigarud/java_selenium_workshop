import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
import org.testng.annotations.*;


public class L8_selenium_program {
    WebDriver driver;

//    @BeforeTest()
//    void initialize() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.calculator.net/");
//    }

    @BeforeMethod()
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

//    @AfterTest()
//    void close_driver() {
//        driver.close();
//    }

    @AfterMethod()
    void close_driver() {
        driver.close();
    }

    @Test(priority = 3)
    public void add()
    {
        Assert.assertEquals(operation("14","+","13"),"27");
    }
    @Test(priority = 3)
    public void subtract()
    {
        Assert.assertEquals(operation("14","-","13"),"1");
    }

    @Test(priority = 2)
    public void multiply()
    {
        Assert.assertEquals(operation("4","*","3"),"12");
    }
}
