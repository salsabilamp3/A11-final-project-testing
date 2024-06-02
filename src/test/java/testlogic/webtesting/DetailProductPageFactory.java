package testlogic.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailProductPageFactory {
    WebDriver driver;

    @FindBy(className = "inventory_item_container")
    private WebElement inventoryItemContainer;

    @FindBy(className = "inventory_details")
    private WebElement inventoryDetails;

    @FindBy(className = "inventory_details_name")
    private WebElement itemName;

    @FindBy(className = "inventory_details_desc")
    private WebElement itemDescription;

    @FindBy(className = "inventory_details_price")
    private WebElement itemPrice;

    @FindBy(className = "inventory_details_img")
    private WebElement itemImage;

    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(id = "remove")
    private WebElement removeButton;

    public DetailProductPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getItemImageSrc() {
        return itemImage.getAttribute("src");
    }

    public String getItemImageAlt() {
        return itemImage.getAttribute("alt");
    }

    public boolean isItemImageDisplayed() {
        return itemImage.isDisplayed();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickRemoveFromCart() {
        removeButton.click();
    }

    public boolean isItemAddedToCart() {
        return removeButton.isDisplayed();
    }

    public boolean isItemRemovedFromCart() {
        return addToCartButton.isDisplayed();
    }
}
