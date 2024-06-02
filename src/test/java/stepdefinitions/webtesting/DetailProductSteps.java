package stepdefinitions.webtesting;

import org.openqa.selenium.WebDriver;

import helper.SwagWebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testlogic.webtesting.DetailProductPageFactory;

public class DetailProductSteps {
    WebDriver driver;
    private DetailProductPageFactory detailProductPageFactory;

    public DetailProductSteps(){
        this.driver = SwagWebDriverManager.getWebDriver();
        this.detailProductPageFactory = new DetailProductPageFactory(driver);
    }

    @When("I click the product {string} image")
    public void I_click_the_product_image(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the detail product image alt is {string}")
    public void the_detail_product_image_alt_is(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the detail prodcut price is {string}")
    public void the_detail_prodcut_price_is(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the detail product description is {string}")
    public void the_detail_product_description_is(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the detail product name is {string}")
    public void the_detail_product_name_is(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should be navigated to detail product page")
    public void I_should_be_navigated_to_detail_product_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should remain on the detail product page")
    public void I_should_remain_on_the_detail_product_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the detail product button become remove")
    public void the_detail_product_button_become_remove() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click Add to cart button in detail product")
    public void I_click_Add_to_cart_button_in_detail_product() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click the product {string} name")
    public void I_click_the_product_name(String s) {
        // Write code here that turns the phrase above into concrete actions
    }
}
