import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calculator_Page {
    WebDriver driver;
    public Calculator_Page(WebDriver driver1)
    {
        driver=driver1;
    }


    String calculate(String n1, String op , String n2) {
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
}
