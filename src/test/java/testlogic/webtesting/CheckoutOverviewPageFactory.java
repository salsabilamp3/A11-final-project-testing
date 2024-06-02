package testlogic.webtesting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPageFactory {
    WebDriver drive;

    @FindBy(css = "div[data-test='cart-list']")
    private WebElement cartList;

    @FindBy(css = "div[data-test='inventory-item']")
    private List<WebElement> inventoryItems;

    @FindBy(css = "div[data-test='item-quantity']")
    private List<WebElement> itemQuantities;

    @FindBy(css = "a[data-test*='title-link']")
    private List<WebElement> itemTitleLinks;

    @FindBy(css = "div[data-test='inventory-item-desc']")
    private List<WebElement> itemDescriptions;

    @FindBy(css = "div[class='item_pricebar']")
    private List<WebElement> itemPrices;

    @FindBy(css = "div[data-test='payment-info-value']")
    WebElement paymentInfo;

    @FindBy(css = "div[data-test='shipping-info-value']")
    WebElement shippingInfo;

    @FindBy(className = "summary_subtotal_label")
    WebElement subTotal;

    @FindBy(className = "summary_tax_label")
    WebElement tax;

    @FindBy(className = "summary_total_label")
    WebElement total;

    @FindBy(xpath = "//*[@id='finish']")
    WebElement btnFinish;

    @FindBy(xpath = "//*[@id='cancel']")
    WebElement btnCancel;

    public CheckoutOverviewPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public int getItemCount() {
        return inventoryItems.size();
    }

    public WebElement getItemTitle(int index) {
        return itemTitleLinks.get(index);
    }

    public WebElement getItemQuantity(int index) {
        return itemQuantities.get(index);
    }

    public WebElement getItemDescription(int index) {
        return itemDescriptions.get(index);
    }

    public WebElement getItemPrice(int index) {
        return itemPrices.get(index);
    }

    public String getPaymentInfo(){
        return paymentInfo.getText();
    }

    public String getShippingInfo(){
        return shippingInfo.getText();
    }

    public String getSubTotal(){
        return subTotal.getText();
    }

    public String getTax(){
        return tax.getText();
    }

    public String getTotal(){
        return total.getText();
    }

    public void clickFinish(){
        btnFinish.click();
    }

    public void clickCancel(){
        btnCancel.click();
    }
}
