package stepdefinitions.webtesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import helper.SwagWebDriverManager;
import testlogic.webtesting.HomePageFactory;
import testlogic.webtesting.LoginPageFactory;
import testlogic.webtesting.CheckoutInformationPageFactory;
import testlogic.webtesting.CheckoutCompletePageFactory;
import testlogic.webtesting.CheckoutOverviewPageFactory;
import testlogic.webtesting.CartPageFactory;
import testlogic.webtesting.DashboardPageFactory;;

public class EndToEndSteps {
    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePageFactory;
    private CheckoutInformationPageFactory checkoutInformationPageFactory;
    private CheckoutCompletePageFactory checkoutCompletePageFactory;
    private CheckoutOverviewPageFactory checkoutOverviewPageFactory;
    private CartPageFactory cartPageFactory;
    private DashboardPageFactory dashboardPageFactory;

    public EndToEndSteps() {
        this.driver = SwagWebDriverManager.getWebDriver();
        this.loginPageFactory = new LoginPageFactory(driver);
        this.homePageFactory = new HomePageFactory(driver);
        this.checkoutInformationPageFactory = new CheckoutInformationPageFactory(driver);
        this.checkoutCompletePageFactory = new CheckoutCompletePageFactory(driver);
        this.checkoutOverviewPageFactory = new CheckoutOverviewPageFactory(driver);
        this.cartPageFactory = new CartPageFactory(driver);
        this.dashboardPageFactory = new DashboardPageFactory(driver);
    }    

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enter their username {string} and password {string} then login")
    public void user_enter_their_username_and_password(String username, String password) {
        loginPageFactory.login(username, password);
    }

    @Then("User navigated to dashboard page")
    public void user_navigated_to_dashboard_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @When("User click add to cart on product {string}")
    public void user_click_add_to_cart_on_product(String productName) {
        homePageFactory.clickAddToCartSauceLabsBackpack();
    }

   @Then("User see badge with number 1 on icon cart")
    public void user_see_badge_with_number_1_on_icon_cart() {
        WebElement badgeElement = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        String badgeText = badgeElement.getText();
        assertEquals("1", badgeText);
    }

    @When("User click icon cart")
    public void user_click_icon_cart() {
        dashboardPageFactory.openShoppingCart();
    }

    @Then("User navigated to cart page")
    public void user_navigated_to_cart_page() {
        String expectedUrl = "https://www.saucedemo.com/cart.html";
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }

    @And("User see list of a product that added before")
    public void user_see_list_of_a_product_that_added_before() {
        Assert.assertTrue("The cart should contain Sauce Labs Backpack", cartPageFactory.isItemInCart("Sauce Labs Backpack"));
    }

    @When("User click Checkout button")
    public void user_click_checkout_button() {
        WebElement checkoutButton = driver.findElement(By.className("checkout_button"));
        checkoutButton.click();
    }

    @Then("User navigated to checkout information page")
    public void user_navigated_to_checkout_information_page() {
        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);   
    }

    @And("User enter first name {string}, last name {string}, and postal code {string} and continue")
    public void user_enter_first_name_last_name_and_postal_code(String firstName, String lastName, String postalCode) {
        checkoutInformationPageFactory.continueCheckout(firstName, lastName, postalCode);
    }

    @Then("User navigated to checkout overview page")
    public void user_navigated_to_checkout_overview_page() {
        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }

    @And("User see list of the product that they checkout {string}")
    public void user_see_list_of_the_product_that_they_checkout(String productName) {
        // Temukan elemen yang mewakili item dalam keranjang belanja
        WebElement itemElement = driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='" + productName + "']"));

        // Verifikasi bahwa item yang diharapkan ada dalam keranjang belanja
        assertTrue("Item '" + productName + "' should be in the cart", itemElement.isDisplayed());
    }

    @And("User see payment information {string}")
    public void user_see_payment_information(String paymentInfo) {
        String paymentInformation = checkoutOverviewPageFactory.getPaymentInfo();
        Assert.assertEquals(paymentInfo, paymentInformation);
    }

    @And("User see shipping information {string}")
    public void user_see_shipping_information(String shippingInfo) {
        String shippingInformation = checkoutOverviewPageFactory.getShippingInfo();
        Assert.assertEquals(shippingInfo, shippingInformation);
    }

    @And("User see item total {string}")
    public void user_see_item_total(String itemTotal) {
        String total = checkoutOverviewPageFactory.getSubTotal();
        Assert.assertEquals(itemTotal, total);
    }

    @And("User see tax {string}")
    public void user_see_tax(String taxAmount) {
        String tax = checkoutOverviewPageFactory.getTax();
        Assert.assertEquals(taxAmount, tax);
    }

    @And("User see total {string}")
    public void user_see_total(String totalAmount) {
        String total = checkoutOverviewPageFactory.getTotal();
        Assert.assertEquals(totalAmount, total);
    }

    @When("User click Finish button")
    public void user_click_finish_button() {
        checkoutOverviewPageFactory.clickFinish();
    }

    @Then("User should be navigated to checkout complete page")
    public void user_should_be_navigated_to_checkout_complete_page() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue("User should be navigated to the checkout complete page",
                currentUrl.contains("checkout-complete.html"));
    }

    @And("User should see a message saying 'Thank you for your order!'")
    public void user_should_see_a_message_saying_thank_you_for_your_order() {
        WebElement messageElement = driver.findElement(By.xpath("//*[contains(text(), 'Thank you for your order!')]"));
        assertTrue("User should see the message saying 'Thank you for your order!'",
                messageElement.isDisplayed());
    }
}
