package Steps;

import Pages.calculator_page;
import Utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calculator_steps extends TestContext {
    //WebDriver driver;
    calculator_page calc_page;
    @Given("I am on Calculator page")
    public void iAmOnCalculatorPage() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        calc_page = new calculator_page(driver,wait);
        calc_page.goto_url("https://www.calculator.net/");

    }

    @When("I enter {string} in calculator")
    public void iPressInCalculator(String n) {
    calc_page.enterNumber(n);
    }

    @And("I Press {string}")
    public void iPress(String op) {
    calc_page.enterOperator(op);
    }


    @Then("I see the result is {string}")
    public void iSeeTheResultIs(String Expected_result) {
    String actual_result = calc_page.getResult();
    Assert.assertEquals(actual_result,Expected_result);
    driver.close();
    }
}
