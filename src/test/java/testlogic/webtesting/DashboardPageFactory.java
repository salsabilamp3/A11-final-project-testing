package testlogic.webtesting;

import java.util.List;
import java.util.NoSuchElementException;

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

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_img")
    private List<WebElement> itemImages;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(className = "inventory_item_desc")
    private List<WebElement> itemDescriptions;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

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

    public int getInventorySize() {
        return inventoryItems.size();
    }

    public void clickItemImage(int index) {
        itemImages.get(index).click();
    }

    public void clickItemName(int index) {
        itemNames.get(index).click();
    }

    public String getItemDescription(int index) {
        return itemDescriptions.get(index).getText();
    }

    public String getItemPrice(int index) {
        return itemPrices.get(index).getText();
    }

    public void clickAddToCartButton(int index) {
        addToCartButtons.get(index).click();
    }

    public int getItemIndexByName(String name) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equals(name)) {
                return i;
            }
        }
        throw new NoSuchElementException("Item with name " + name + " not found");
    }
}
