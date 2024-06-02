package testlogic.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPageFactory {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='first-name']")
    WebElement firstName;

    @FindBy(xpath = "//*[@id='last-name']")
    WebElement lastName;

    @FindBy(xpath = "//*[@id='postal-code']")
    WebElement postalCode;

    @FindBy(xpath = "//*[@id='continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//*[@id='cancel']")
    WebElement btnCancel;

    @FindBy(className = "error-message-container")
    WebElement errorMessage;

    public CheckoutInformationPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String strFirstName){
        firstName.sendKeys(strFirstName);
    }

    public void setlastName(String strlastName){
        lastName.sendKeys(strlastName);
    }

    public void setPostalCode(String strPostalCode){
        postalCode.sendKeys(strPostalCode);
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public void clickCancel(){
        btnCancel.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void continueCheckout(String firstName, String lastName, String postalCode){
        setFirstName(firstName);
        setlastName(lastName);
        setPostalCode(postalCode);
        clickContinue();
    }
}
