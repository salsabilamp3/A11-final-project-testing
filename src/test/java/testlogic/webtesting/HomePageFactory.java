package testlogic.webtesting;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageFactory {
    private WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement closeSidebarButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateButton;

    @FindBy(className = "bm-menu-wrap")
    private WebElement sidebarMenu;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBurgerMenuButton() {
        burgerMenuButton.click();
    }

    public void clickLogoutLink() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(this.logoutLink));
        logoutLink.click();
    }

    public boolean isSidebarMenuDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(sidebarMenu));
            return true; // Jika elemen ditemukan, kembalikan true
        } catch (TimeoutException e) {
            return false; // Jika elemen tidak ditemukan dalam waktu 10 detik, kembalikan false
        }
    }    

    public void clickCloseSidebarButton() {
        // Scroll to close button
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", closeSidebarButton);

        // Wait until close button is clickable
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeSidebarButton));
        closeButton.click();
    }   

    public void clickAllItemsButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement allItemsButton = wait.until(ExpectedConditions.elementToBeClickable(this.allItemsButton));
        allItemsButton.click();
    }

    public void clickAboutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement aboutButton = wait.until(ExpectedConditions.elementToBeClickable(this.aboutButton));
        aboutButton.click();
    }

    public void clickResetAppStateButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement resetAppStateButton = wait.until(ExpectedConditions.elementToBeClickable(this.resetAppStateButton));
        resetAppStateButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
