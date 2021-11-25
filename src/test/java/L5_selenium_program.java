import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class L5_selenium_program {
    WebDriver driver;
    L5_selenium_program() {
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

    void close_driver() {
        driver.close();


    }

    @Test(priority = 3)
    void add()
    {
        String actual_result;
        actual_result=operation("14","+","13");
        if (actual_result.equals("27"))
            System.out.println("pass");
        else
            System.out.println("Fail");
        //close_driver();
    }
    @Test(priority = 3)
    void subtract()
    {
        String actual_result;
        actual_result = operation("14","-","13");
        if (actual_result.equals("1"))
            System.out.println("pass");
        else
            System.out.println("Fail");
        //close_driver();
    }

    @Test(priority = 2)
    public void multiply()
    {
        String actual_result;
        actual_result = operation("4","*","3");
        if (actual_result.equals("12"))
            System.out.println("pass");
        else
            System.out.println("Fail");
        //close_driver();
    }
}
