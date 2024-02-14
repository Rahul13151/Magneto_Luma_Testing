package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @FindBy(css = "a[title='Compare Products']")
    WebElement compareProductButton;
    @FindBy(xpath = "(//*[@class='product details product-item-details'])[1]")
    WebElement bag1;
    @FindBy(xpath = "(//*[@class='product details product-item-details'])[2]")
    WebElement bag2;
    @FindBy(xpath = "(//a[@title='Add to Compare'])[1]")
    WebElement bag1CompareButton;
    @FindBy(xpath = "(//a[@title='Add to Compare'])[2]")
    WebElement bag2CompareButton;


    public BagsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void add2ItemsToCompareList(){
        actions = new Actions(driver);
        actions.moveToElement(bag1).perform();
        bag1CompareButton.click();
        actions = new Actions(driver);
        actions.moveToElement(bag2).perform();
        bag2CompareButton.click();
    }

    public void openCompareProductPage(){
        compareProductButton.click();
    }

}
