package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//span[contains(text(),'Change Shipping')]/parent::a")
    WebElement changeShippingAddBtn;
    @FindBy(css="button[title='Add New Address']")
    WebElement addNewAddressButton;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAddNewAddressButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addNewAddressButton));
        addNewAddressButton.click();
    }
    public void clickChangeShippingAddressBtn(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(changeShippingAddBtn));
        changeShippingAddBtn.click();
    }
}
