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

public class CartPages {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @FindBy(css = ".counter-number" )
    WebElement sizeOfCart;
    @FindBy(css = ".grand .price")
    WebElement orderTotal;
    @FindBy(css="button[data-role='proceed-to-checkout']")
    WebElement proceedToCheckoutBtn;
    @FindBy(id="label_method_flatrate_flatrate")
    WebElement fixedRateBtn;
    @FindBy(css="#shipping-method-buttons-container > div > button")
    WebElement nextBtn;
    @FindBy(css="button[title='Place Order']")
    WebElement placeOrderBtn;
    @FindBy(css=".order-number")
    WebElement orderNumber;
    public CartPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void printSizeOfCart(){
        int cartSize = Integer.parseInt(sizeOfCart.getText());
        System.out.println("Cart Size = "+cartSize);
    }
    public void printOrderTotal(){
        String orderPrice = (orderTotal.getText());
        System.out.println("Order Total : "+orderPrice);
    }
    public void clickProceedToCheckout(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
    }
    public void selectFixedShippingMethod(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fixedRateBtn));
        fixedRateBtn.click();
    }
    public  void clickOnNextButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
    }
    public void clickPlaceOrder(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        // Problem with site thread.sleep is necessary to use as explicit wait is unable to meet the the required condition
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        placeOrderBtn.click();
    }
    public void printOrderNumber(){
        String orderNum = orderNumber.getText();
        System.out.println("Order Number is : " + orderNum);
    }
}
