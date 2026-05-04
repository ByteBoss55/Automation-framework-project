package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage login;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
    }

    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials() {
        login.enterUsername("invalid");
        login.enterPassword("wrong");
        login.clickLogin();
    }

    @Then("User should see homepage")
    public void user_should_see_homepage() {
        System.out.println("Login Successful");
        driver.quit();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        System.out.println("Login Failed");
        driver.quit();
    }
}
