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


public class WhatisNewPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @FindBy(id = "ui-id-3")
    WebElement whatsNewButton;
    @FindBy(xpath = "(//*[@class='product-item']//div[@class='product-item-details'])[1]")
    WebElement product1ToBeAddedToWishlist;
    @FindBy(xpath = "(//*[@class='product-item']//div[@class='product-item-details'])[2]")
    WebElement product2ToBeAddedToWishlist;
    @FindBy(xpath = "(//*[@class='product-item']//div[@class='product-item-details'])[3]")
    WebElement product3ToBeAddedToWishlist;
    @FindBy(xpath="(//a[@class='action towishlist'])[1]")
    WebElement product1WishListButton;
    @FindBy(xpath="(//a[@class='action towishlist'])[2]")
    WebElement product2WishListButton;
    @FindBy(xpath="(//a[@class='action towishlist'])[3]")
    WebElement product3WishListButton;
    @FindBy(css=".action.details")
    WebElement viewWishlistBtn;
    @FindBy(xpath = "(//*[@class='product-item-info'])[1]")
    WebElement firstWishlistEle;
    @FindBy(xpath = "(//*[@class='product-item-info'])[1]//a[@title='Remove Item']")
    WebElement firstWishlistEleRemoveBtn;
    @FindBy(xpath ="(//*[@class='product-item-info'])[2]")
    WebElement lastWishlistEle;
    @FindBy(xpath = "(//*[@class='product-item-info'])[2]//button")
    WebElement lastWishlistEleAddBtn;

    @FindBy(id = "ui-id-6")
    WebElement GearSection;
    @FindBy(id = "ui-id-25")
    WebElement GearBagButton;


    public WhatisNewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addThreeItemsToWishList (){
        actions = new Actions(driver);
        actions.moveToElement(product1ToBeAddedToWishlist).perform();
        product1WishListButton.click();
        openWhatsNewSection();
        actions = new Actions(driver);
        actions.moveToElement(product2ToBeAddedToWishlist).perform();
        product2WishListButton.click();
        openWhatsNewSection();
        actions = new Actions(driver);
        actions.moveToElement(product3ToBeAddedToWishlist).perform();
        product3WishListButton.click();

    }
    public void removeFirstFromWishList(){
        actions = new Actions(driver);
        actions.moveToElement(firstWishlistEle).perform();
        firstWishlistEleRemoveBtn.click();
    }
    public void lastItemAddToCart(){
        actions = new Actions(driver);
        actions.moveToElement(lastWishlistEle).perform();
        lastWishlistEleAddBtn.click();
        ProductPage obj = new ProductPage(driver);
        obj.selectSizeAndColor();
        obj.clickAddToCart();
    }
    public void visitWishlistPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(viewWishlistBtn));
        viewWishlistBtn.click();
    }

    public void openWhatsNewSection(){
        whatsNewButton.click();
    }
    public void openGearBagsSection(){
        actions  = new Actions(driver);
        actions.moveToElement(GearSection).perform();
        GearBagButton.click();
    }

}
