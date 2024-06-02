package stepdefinitions.webtesting;

import org.openqa.selenium.WebDriver;

import helper.SwagWebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testlogic.webtesting.CheckoutCompletePageFactory;
import testlogic.webtesting.CheckoutInformationPageFactory;
import testlogic.webtesting.CheckoutOverviewPageFactory;

public class CheckoutSteps {
    WebDriver driver;
    private CheckoutInformationPageFactory checkoutInformationPageFactory;
    private CheckoutOverviewPageFactory checkoutOverviewPageFactory;
    private CheckoutCompletePageFactory checkoutCompletePageFactory;

    public CheckoutSteps(){
        this.driver = SwagWebDriverManager.getWebDriver();
        this.checkoutInformationPageFactory = new CheckoutInformationPageFactory(driver);
        this.checkoutOverviewPageFactory = new CheckoutOverviewPageFactory(driver);
        this.checkoutCompletePageFactory = new CheckoutCompletePageFactory(driver);
    }

    @When("I click the cancel checkout button")
    public void I_click_the_cancel_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click the continue button")
    public void I_click_the_continue_button() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I enter my firstname {string}, lastname {string}, and postal code {string}")
    public void I_enter_my_firstname_lastname_and_postal_code(String s, String s2, String s3) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should be navigated to checkout overview page")
    public void I_should_be_navigated_to_checkout_overview_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the overview should contain {int} item")
    public void the_overview_should_contain_item(int i) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see an error checkout message saying {string}")
    public void I_should_see_an_error_checkout_message_saying(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should remain on the checkout information page")
    public void I_should_remain_on_the_checkout_information_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the total should be {string}")
    public void the_total_should_be(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the tax should be {string}")
    public void the_tax_should_be(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the item total should be {string}")
    public void the_item_total_should_be(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the shipping information should be {string}")
    public void the_shipping_information_should_be(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the payment information should be {string}")
    public void the_payment_information_should_be(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the item on overwiew at index {int} should have have quantity {string}, title {string}, description {string}, and price {string}")
    public void the_item_on_overwiew_at_index_should_have_have_quantity_title_description_and_price(int i, String s, String s2, String s3, String s4) {
        // Write code here that turns the phrase above into concrete actions
    }
}
