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

public class CompareProductPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @FindBy(xpath = "(//a[@class='action view'])[1]")
    WebElement element1Review;
    @FindBy(xpath = "(//a[@class='action view'])[2]")
    WebElement element2Review;
    @FindBy(xpath = "(//div[@class='product-item-actions hidden-print'])[1]//button")
    WebElement element1AddToCartButton;
    @FindBy(xpath = "(//div[@class='product-item-actions hidden-print'])[2]//button")
    WebElement element2AddToCartButton;
    @FindBy(xpath = "(//a[@title='Remove Product'])[1]")
    WebElement removeProductButton;
    @FindBy(css = ".action-accept")
    WebElement removeProductConfirmationBtn;
    @FindBy(css=".showcart")
    WebElement cartIconBtn;

    @FindBy(css=".viewcart")
    WebElement visitCartBtn;

    public CompareProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addElementToCartWithMoreReviews(){
        //Comparing first two elements from compare Products List
        String reviewText1 = element1Review.getText();
        int reviewCount1 = Integer.parseInt((reviewText1.split(" "))[0]);
        String reviewText2 = element2Review.getText();
        int reviewCount2 = Integer.parseInt((reviewText2.split(" "))[0]);
        if(reviewCount1>=reviewCount2){
            element1AddToCartButton.click();
        }else{
            element2AddToCartButton.click();
        }
    }
    public void removeComparedElements(){
        removeProductButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(removeProductConfirmationBtn));
        removeProductConfirmationBtn.click();
        removeProductButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(removeProductConfirmationBtn));
        removeProductConfirmationBtn.click();
    }
    public void openCartPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(cartIconBtn));
        cartIconBtn.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(visitCartBtn));
        visitCartBtn.click();

    }

}
