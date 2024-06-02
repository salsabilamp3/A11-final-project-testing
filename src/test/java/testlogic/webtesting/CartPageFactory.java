package testlogic.webtesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageFactory {
    WebDriver driver;

    @FindBy(css = ".btn_secondary.back.btn_medium")
    private WebElement continueShoppingButton;

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement checkoutButton;

    @FindBy(className = "cart_list")
    private WebElement cartList;

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    @FindBy(css = ".cart_footer .error-message-container")
    private WebElement checkoutErrorMessage;

    public CartPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public boolean isItemInCart(String itemName) {
        return cartItems.stream().anyMatch(item -> item.getText().contains(itemName));
    }

    public boolean isCheckoutErrorMessageDisplayed() {
        return checkoutErrorMessage.isDisplayed();
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public WebElement getCartItemByIndex(int index) {
        return cartItems.get(index);
    }

    public String getItemQuantity(WebElement item) {
        return item.findElement(By.cssSelector("[data-test='item-quantity']")).getText();
    }

    public String getItemTitle(WebElement item) {
        return item.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText();
    }

    public String getItemDescription(WebElement item) {
        return item.findElement(By.cssSelector("[data-test='inventory-item-desc']")).getText();
    }

    public String getItemPrice(WebElement item) {
        return item.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();
    }

}
