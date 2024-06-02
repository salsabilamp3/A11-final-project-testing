package stepdefinitions.webtesting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import helper.SwagWebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testlogic.webtesting.CheckoutInformationPageFactory;
import testlogic.webtesting.CheckoutOverviewPageFactory;

public class CheckoutSteps {
    WebDriver driver;
    private CheckoutInformationPageFactory checkoutInformationPageFactory;
    private CheckoutOverviewPageFactory checkoutOverviewPageFactory;

    public CheckoutSteps(){
        this.driver = SwagWebDriverManager.getWebDriver();
        this.checkoutInformationPageFactory = new CheckoutInformationPageFactory(driver);
        this.checkoutOverviewPageFactory = new CheckoutOverviewPageFactory(driver);
    }

    @When("I click the cancel checkout button")
    public void I_click_the_cancel_checkout_button() {
        checkoutInformationPageFactory.clickCancel();
    }

    @When("I click the continue button")
    public void I_click_the_continue_button() {
        checkoutInformationPageFactory.clickContinue();
    }

    @When("I enter my firstname {string}, lastname {string}, and postal code {string}")
    public void I_enter_my_firstname_lastname_and_postal_code(String firstname, String lastname, String postalcode) {
        checkoutInformationPageFactory.setFirstName(firstname);
        checkoutInformationPageFactory.setlastName(lastname);
        checkoutInformationPageFactory.setPostalCode(postalcode);
    }

    @Then("I should be navigated to checkout overview page")
    public void I_should_be_navigated_to_checkout_overview_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "checkout-step-two.html";
        Assert.assertTrue("The URL should contain '" + expectedUrl + "', but it was: " + currentUrl,
                currentUrl.contains(expectedUrl));
    }

    @Then("the overview should contain {int} item")
    public void the_overview_should_contain_item(int num) {
        Assert.assertEquals(num, checkoutOverviewPageFactory.getItemCount());
    }

    @Then("I should see an error checkout message saying {string}")
    public void I_should_see_an_error_checkout_message_saying(String message) {
        Assert.assertEquals(message, checkoutInformationPageFactory.getErrorMessage());
    }

    @Then("I should remain on the checkout information page")
    public void I_should_remain_on_the_checkout_information_page() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "checkout-step-one.html";
        Assert.assertTrue("The URL should contain '" + expectedUrl + "', but it was: " + currentUrl,
                currentUrl.contains(expectedUrl));
    }

    @Then("the total should be {string}")
    public void the_total_should_be(String total) {
        Assert.assertEquals(total, checkoutOverviewPageFactory.getTotal());
    }

    @Then("the tax should be {string}")
    public void the_tax_should_be(String tax) {
        Assert.assertEquals(tax, checkoutOverviewPageFactory.getTax());
    }

    @Then("the item total should be {string}")
    public void the_item_total_should_be(String itemtotal) {
        Assert.assertEquals(itemtotal, checkoutOverviewPageFactory.getSubTotal());
    }

    @Then("the shipping information should be {string}")
    public void the_shipping_information_should_be(String shipping) {
        Assert.assertEquals(shipping, checkoutOverviewPageFactory.getShippingInfo());
    }

    @Then("the payment information should be {string}")
    public void the_payment_information_should_be(String payment) {
        Assert.assertEquals(payment, checkoutOverviewPageFactory.getPaymentInfo());
    }

    @Then("the item on overwiew at index {int} should have have quantity {string}, name {string}, description {string}, and price {string}")
    public void the_item_on_overwiew_at_index_should_have_have_quantity_name_description_and_price(int index, String qty, String title, String desc, String price) {
        Assert.assertEquals(qty, checkoutOverviewPageFactory.getItemQuantity(index).getText());
        Assert.assertEquals(title, checkoutOverviewPageFactory.getItemTitle(index).getText());
        Assert.assertEquals(desc, checkoutOverviewPageFactory.getItemDescription(index).getText());
        Assert.assertEquals(price, checkoutOverviewPageFactory.getItemPrice(index).getText());
    }
}
