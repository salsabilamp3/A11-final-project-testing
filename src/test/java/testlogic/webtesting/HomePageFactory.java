package testlogic.webtesting;

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

}
