package stepdefinitions.webtesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import helper.SwagWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testlogic.webtesting.DashboardPageFactory;
import testlogic.webtesting.CartPageFactory;

public class CartSteps {
    WebDriver driver;
    private DashboardPageFactory dashboardPageFactory;
    private CartPageFactory cartPageFactory;

    public CartSteps() {
        this.driver = SwagWebDriverManager.getWebDriver();
        this.dashboardPageFactory = new DashboardPageFactory(driver);
        this.cartPageFactory = new CartPageFactory(driver);
    }

    @Given("I am logged in to the inventory page")
    public void i_am_logged_in_to_the_inventory_page() {
        driver.get("https://www.saucedemo.com/");
        dashboardPageFactory.login("standard_user", "secret_sauce");
    }

    @When("I click the cart icon")
    public void i_click_the_cart_icon() {
        dashboardPageFactory.openShoppingCart();
    }

    @Then("The system displays the cart page without any items listed")
    public void the_system_displays_the_cart_page_without_any_items_listed() {
        Assert.assertTrue("The cart should be empty", cartPageFactory.isCartEmpty());
    }

    @Then("The system displays the cart page with the items that have been added, namely 'Sauce Labs Backpack' and 'Sauce Labs Bolt T-Shirt'")
    public void the_system_displays_the_cart_page_with_the_items_that_have_been_added_namely_sauce_labs_backpack_and_sauce_labs_bolt_t_shirt() {
        Assert.assertTrue("The cart should contain Sauce Labs Backpack", cartPageFactory.isItemInCart("Sauce Labs Backpack"));
        Assert.assertTrue("The cart should contain Sauce Labs Bolt T-Shirt", cartPageFactory.isItemInCart("Sauce Labs Bolt T-Shirt"));
    }

    @When("I click the 'Continue Shopping' button")
    public void i_click_the_continue_shopping_button() {
        cartPageFactory.clickContinueShopping();
    }

    @Then("The system displays the dashboard page")
    public void the_system_displays_the_dashboard_page() {
        Assert.assertTrue("The URL should contain 'inventory.html'", driver.getCurrentUrl().contains("inventory.html"));
    }

    @When("I click the 'Checkout' button")
    public void i_click_the_checkout_button() {
        cartPageFactory.clickCheckout();
    }

    @Then("The current screen remains on the cart page, and an error message 'You Need Item In Cart To Proceed Checkout Process' is displayed")
    public void the_current_screen_remains_on_the_cart_page_and_an_error_message_you_need_item_in_cart_to_proceed_checkout_process_is_displayed() {
        Assert.assertTrue("The URL should contain 'cart.html'", driver.getCurrentUrl().contains("cart.html"));
        Assert.assertTrue("Error message should be displayed", cartPageFactory.isCheckoutErrorMessageDisplayed());
    }

    @Then("The system displays the checkout information page")
    public void the_system_displays_the_checkout_information_page() {
        Assert.assertTrue("The URL should contain 'checkout-step-one.html'", driver.getCurrentUrl().contains("checkout-step-one.html"));
    }
}
