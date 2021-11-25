package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class calculator_page {

    WebDriver driver;
    WebDriverWait wait;
    String number1_xpath = "//span[@onclick='r(x)']";
    String result_xpath = "//div[@id='sciOutPut']";
    public calculator_page(WebDriver driver1, WebDriverWait wait)
    {
        driver = driver1;
        this.wait = wait;

    }

    public void goto_url(String url)
    {
        driver.get(url);
    }
    public void enterNumber(String n) //15
    {

        for(int i =0; i<n.length();i++) {
            //driver.findElement(By.xpath("//span[@onclick='r(" + n.charAt(i) + ")']")).click();
            driver.findElement(By.xpath(number1_xpath.replace('x',n.charAt(i)))).click();
        }

    }
    public void enterOperator(String op)
    {
        driver.findElement(By.xpath("//span[@onclick=\"r('"+op+"')\"]")).click();
    }
    public String getResult()
    {
        WebElement result=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(result_xpath)));
        String actual_result =(result.getText()).trim();
        return actual_result;
    }

//    String calculate (String n1, String op, String n2)
//    {
//     enterNumber(n1);
//     enterOperator(op);
//     enterNumber(n2);
//     enterOperator("=");
//     String actual_result = getResult();
//     return actual_result;
//    }
}
