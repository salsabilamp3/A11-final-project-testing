package stepdefinitions.webtesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.After;
import helper.SwagWebDriverManager;
import testlogic.webtesting.LoginPageFactory;

public class LoginSteps {
    private WebDriver driver;
    private LoginPageFactory loginPageFactory;

    public LoginSteps() {
        this.driver = SwagWebDriverManager.getWebDriver();
        this.loginPageFactory = new LoginPageFactory(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter my username {string} and password {string}")
    public void i_enter_my_username_and_password(String username, String password) {
        loginPageFactory.setUserName(username);
        loginPageFactory.setPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPageFactory.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @Then("I should remain on the login page")
    public void i_should_remain_on_the_login_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/", currentUrl);
    }

    @Then("I should see a message saying {string}")
    public void i_should_see_a_message_saying(String expectedMessage) {
        String actualMessage = loginPageFactory.getErrorMessage();
        Assert.assertTrue("Expected error message : '" + expectedMessage + "' not found. Found: " + actualMessage,
                actualMessage.contains(expectedMessage));
    }

    @After
    public void closeBrowser() {
        SwagWebDriverManager.quitWebDriver();
    }
}
