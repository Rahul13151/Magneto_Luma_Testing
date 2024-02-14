package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage{
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "(//div[contains(@id,'option-label-size')])[1]")
    WebElement sizeSelector;
    @FindBy(xpath = "(//div[contains(@id,'option-label-color')])[1]")
    WebElement colorSelector;
    @FindBy(id="product-addtocart-button")
    WebElement addToCartButton;
    @FindBy(id=".logo")
    WebElement lumaLogo;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectSizeAndColor(){
        sizeSelector.click();
        colorSelector.click();
    }
    public void clickAddToCart(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
    public void redirectToHomePage(){
        lumaLogo.click();
    }

}
