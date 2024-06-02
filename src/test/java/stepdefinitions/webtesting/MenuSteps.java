package stepdefinitions.webtesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import helper.SwagWebDriverManager;
import testlogic.webtesting.HomePageFactory;

public class MenuSteps {
    private WebDriver driver;
    private HomePageFactory homePageFactory;

    public MenuSteps() {
        this.driver = SwagWebDriverManager.getWebDriver();
        this.homePageFactory = new HomePageFactory(driver);
    }

    @When("The user clicks the sidebar button")
    public void the_user_clicks_the_sidebar_button() {
        homePageFactory.clickBurgerMenuButton();
    }

    @Then("The sidebar menu should be displayed")
    public void the_sidebar_menu_should_be_displayed() {
        Assert.assertTrue("Sidebar menu is not displayed", homePageFactory.isSidebarMenuDisplayed());
    }

    @Given("The sidebar menu is displayed")
    public void the_sidebar_menu_is_displayed() {
        Assert.assertTrue("Sidebar menu is not displayed", homePageFactory.isSidebarMenuDisplayed());
    }

    @When("The user clicks the 'X' button")
    public void the_user_clicks_the_X_button() {
        homePageFactory.clickBurgerMenuButton();
        homePageFactory.clickCloseSidebarButton();
    }

    @Then("The sidebar menu should be closed")
    public void the_sidebar_menu_should_be_closed() {
        // Add delay to ensure sidebar is closed
        try {
            Thread.sleep(1000); // Delay for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse("Sidebar menu is still displayed", homePageFactory.isSidebarMenuDisplayed());
    }

    @When("The user clicks the 'Logout' button")
    public void the_user_clicks_the_Logout_button() {
        // Ensure sidebar is clicked before logging out
        the_user_clicks_the_sidebar_button();
        homePageFactory.clickLogoutLink();
    }

    @Then("The user should be logged out")
    public void the_user_should_be_logged_out() {
        // Add logout verification logic here
    }

    @Then("The login page should be displayed")
    public void the_login_page_should_be_displayed() {
        String currentUrl = homePageFactory.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/", currentUrl);
    }
}
