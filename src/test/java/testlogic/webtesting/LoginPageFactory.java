package testlogic.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;

    @FindBy(className = "error-message-container")
    WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName) {
        userName.sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLogin();
    }
}
