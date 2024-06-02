package testlogic.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePageFactory {
    WebDriver driver;

    @FindBy(className = "complete-header")
    WebElement completeMessage;

    @FindBy(xpath = "//*[@id='back-to-products']")
    WebElement btnBackHome;

    public CheckoutCompletePageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCompleteMessage(){
        return completeMessage.getText();
    }

    public void clickBackHome(){
        btnBackHome.click();
    }
}
