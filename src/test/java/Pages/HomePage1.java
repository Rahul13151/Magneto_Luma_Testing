package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage1 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @FindBy(css = ".panel .authorization-link a")
    WebElement signInButton;

    @FindBy(css = ".panel button")
    WebElement dropDownList;
    @FindBy(xpath = "//*[@class='panel header']//a[contains(text(),'My Account')]")
    WebElement myAccountButton;
    @FindBy(id = "ui-id-3")
    WebElement whatsNewButton;

    @FindBy(id = "ui-id-6")
    WebElement gearIcon;
    @FindBy(id = "ui-id-25")
    WebElement bagsButton;

    public HomePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
    public void getTitle(){
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
    public void openUserAccountPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownList));
        dropDownList.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();

    }
    public void openBuyBagPage(){
        actions  = new Actions(driver);
        actions.moveToElement(gearIcon).perform();
        bagsButton.click();


    }
    public void openWhatsNewSection(){
        whatsNewButton.click();
    }
}
