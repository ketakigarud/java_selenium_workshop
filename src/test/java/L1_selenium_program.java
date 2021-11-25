import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class L1_selenium_program {
   public static void main(String args[])
   {
//     System.setProperty("webdriver.chrome.driver","src/test/Resources/chromedriver.exe");
//     WebDriver driver = new ChromeDriver();
//     driver.get("https://www.calculator.net/");
//     OR
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.calculator.net/");
       driver.findElement(By.xpath("//span[@onclick=\"r(1)\"]")).click();
       driver.findElement(By.xpath("//span[@onclick=\"r('+')\"]")).click();
       driver.findElement(By.xpath("//span[@onclick=\"r(5)\"]")).click();
       driver.findElement(By.xpath("//span[@onclick=\"r('=')\"]")).click();
       WebElement result = driver.findElement(By.id("sciOutPut"));
       String actual_result=result.getText().trim();
       String expected_result = "6";
       if (actual_result.equals(expected_result))
           System.out.println("pass");
       else
           System.out.println("Fail");
       driver.close();

   }
}
