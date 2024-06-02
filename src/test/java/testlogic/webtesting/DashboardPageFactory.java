package testlogic.webtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPageFactory {
    WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartSauceLabsBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartSauceLabsBoltTShirt;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addToCartSauceLabsOnesie;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartLink;

    public DashboardPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCartSauceLabsBackpack() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartSauceLabsBackpack)).click();
    }

    public void addToCartSauceLabsBoltTShirt() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartSauceLabsBoltTShirt)).click();
    }

    public void addToCartSauceLabsOnesie() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartSauceLabsOnesie)).click();
    }

    public void openShoppingCart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    }

    public boolean isItemInCart(String itemName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + itemName + "')]")));
        return cartItem != null;
    }
}
