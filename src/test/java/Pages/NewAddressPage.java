package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewAddressPage {
    WebDriver driver;
    WebDriverWait wait;
    String contactNumber ="4674052952";
    String zip="98103";
    String city="Seattle";
    String streetAddress="House No-1";


    @FindBy(id="telephone")
    WebElement contactNumberInputBox;
    @FindBy(xpath="//option[@value='US']")
    WebElement countryInputOption;
    @FindBy(xpath="//option[@value='62']")
    WebElement stateInputOption;
    @FindBy(id="zip")
    WebElement zipInputBox;
    @FindBy(id="city")
    WebElement cityInputBox;
    @FindBy(id="street_1")
    WebElement streetAddressInputBox;
    @FindBy(xpath = "//button[@title='Save Address']")
    WebElement saveAddressButton;

    @FindBy(css=".logo")
    WebElement lumaLogo;
    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterAddressDetails(){
        contactNumberInputBox.sendKeys(contactNumber);
        countryInputOption.click();
        stateInputOption.click();
        zipInputBox.sendKeys(zip);
        cityInputBox.sendKeys(city);
        streetAddressInputBox.sendKeys(streetAddress);
    }
    public void clickSaveAddressButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saveAddressButton));
        saveAddressButton.click();
    }
    public void redirectToHomePage(){
        lumaLogo.click();
    }
    public void updateCityAndZip(String zip,String city){
        zipInputBox.clear();
        zipInputBox.sendKeys(zip);
        cityInputBox.clear();
        cityInputBox.sendKeys(city);

    }
}
