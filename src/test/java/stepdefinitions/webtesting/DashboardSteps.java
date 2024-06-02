package stepdefinitions.webtesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.SwagWebDriverManager;
import testlogic.webtesting.LoginPageFactory;
import testlogic.webtesting.DashboardPageFactory;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class DashboardSteps {
    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private DashboardPageFactory inventoryPageFactory;

    public DashboardSteps() {
        this.driver = SwagWebDriverManager.getWebDriver();
        this.loginPageFactory = new LoginPageFactory(driver);
        this.inventoryPageFactory = new DashboardPageFactory(driver);
    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String item) {
        switch(item) {
            case "Sauce Labs Backpack":
                inventoryPageFactory.addToCartSauceLabsBackpack();
                break;
            case "Sauce Labs Bolt T-Shirt":
                inventoryPageFactory.addToCartSauceLabsBoltTShirt();
                break;
            case "Sauce Labs Onesie":
                inventoryPageFactory.addToCartSauceLabsOnesie();
                break;
            default:
                throw new IllegalArgumentException("Invalid item: " + item);
        }
    }

    @Then("The item {string} should be added to the cart")
    public void the_item_should_be_added_to_the_cart(String itemName) {
        inventoryPageFactory.openShoppingCart();
        Assert.assertTrue("Item not added to cart: " + itemName, inventoryPageFactory.isItemInCart(itemName));
    }

    @When("I click the product {string} image")
    public void I_click_the_product_image(String name) {
        int itemIndex = inventoryPageFactory.getItemIndexByName(name);
        inventoryPageFactory.clickItemImage(itemIndex);
    }

    @When("I click the product {string} name")
    public void I_click_the_product_name(String name) {
        int itemIndex = inventoryPageFactory.getItemIndexByName(name);
        inventoryPageFactory.clickItemName(itemIndex);
    }

    @Then("I should be navigated to detail product page")
    public void I_should_be_navigated_to_detail_product_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedSubUrl = "inventory-item.html";
        Assert.assertTrue("The URL should contain '" + expectedSubUrl + "', but it was: " + currentUrl,
                currentUrl.contains(expectedSubUrl));
    }
}
