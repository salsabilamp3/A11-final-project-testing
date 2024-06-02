package stepdefinitions.webtesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import helper.SwagWebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testlogic.webtesting.DashboardPageFactory;
import testlogic.webtesting.DetailProductPageFactory;

public class DetailProductSteps {
    WebDriver driver;
    private DetailProductPageFactory detailProductPageFactory;

    public DetailProductSteps(){
        this.driver = SwagWebDriverManager.getWebDriver();
        this.detailProductPageFactory = new DetailProductPageFactory(driver);
    }

    @Then("the detail product image alt is {string}")
    public void the_detail_product_image_alt_is(String alt) {
        String actualAlt = detailProductPageFactory.getItemImageAlt();
        Assert.assertEquals("The product image alt text should match", alt, actualAlt);
    }

    @Then("the detail prodcut price is {string}")
    public void the_detail_prodcut_price_is(String price) {
        String actualPrice = detailProductPageFactory.getItemPrice();
        Assert.assertEquals("The product price should match", price, actualPrice);
    }

    @Then("the detail product description is {string}")
    public void the_detail_product_description_is(String desc) {
        String actualDesc = detailProductPageFactory.getItemDescription();
        Assert.assertEquals("The product description should match", desc, actualDesc);
    }

    @Then("the detail product name is {string}")
    public void the_detail_product_name_is(String name) {
        String actualName = detailProductPageFactory.getItemName();
        Assert.assertEquals("The product name should match", name, actualName);
    }

    @Then("I should remain on the detail product page")
    public void I_should_remain_on_the_detail_product_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("The URL should contain 'inventory-item.html?id='", currentUrl.contains("inventory-item.html?id="));
    }

    @Then("the detail product button become remove")
    public void the_detail_product_button_become_remove() {
        boolean isRemoveButtonDisplayed = detailProductPageFactory.isItemAddedToCart();
        Assert.assertTrue("The remove button should be displayed", isRemoveButtonDisplayed);
    }

    @When("I click Add to cart button in detail product")
    public void I_click_Add_to_cart_button_in_detail_product() {
        detailProductPageFactory.clickAddToCart();
    }
}
