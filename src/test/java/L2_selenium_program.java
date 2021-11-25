import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class L2_selenium_program {
    WebDriver driver;
    void initialize_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/");
    }

    String operation() {
        driver.findElement(By.xpath("//span[@onclick=\"r(1)\"]")).click();
        driver.findElement(By.xpath("//span[@onclick=\"r('+')\"]")).click();
        driver.findElement(By.xpath("//span[@onclick=\"r(5)\"]")).click();
        driver.findElement(By.xpath("//span[@onclick=\"r('=')\"]")).click();
        WebElement result = driver.findElement(By.id("sciOutPut"));
        String actual_result = result.getText().trim();
        return actual_result;

    }

    void close_driver() {
        driver.close();
    }

    public static void main(String args[]) {

        L2_selenium_program obj = new L2_selenium_program();
        obj.initialize_driver();
        String actual_result=obj.operation();
        if (actual_result.equals("6"))
            System.out.println("pass");
        else
            System.out.println("Fail");
        obj.close_driver();
    }
}
