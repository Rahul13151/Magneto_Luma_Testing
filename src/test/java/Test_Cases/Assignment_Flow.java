package Test_Cases;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assignment_Flow {
    WebDriver driver;
    AddressPage objectAddressPage;
    BagsPage objectBagsPage;
    CompareProductPage objectCompareProductPage;
    HomePage objectHomePage;
    NewAddressPage objectNewAddressPage;
    ProductPage objectProductPage;
    SignInPage objectSignInPage;
    UserAccountPage objectUserAccountPage;
    WhatisNewPage objectWhatisNewPage;
    CartPages objectCartPage;
    public Assignment_Flow(){

    }
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        objectHomePage = new HomePage(driver);
        objectSignInPage = new SignInPage(driver);
        objectAddressPage = new AddressPage(driver);
        objectBagsPage = new BagsPage(driver);
        objectCompareProductPage = new CompareProductPage(driver);
        objectNewAddressPage = new NewAddressPage(driver);
        objectUserAccountPage = new UserAccountPage(driver);
        objectProductPage = new ProductPage(driver);
        objectWhatisNewPage = new WhatisNewPage(driver);
        objectCartPage = new CartPages(driver);

    }
    @Test(priority = 0)
    public void TestCase1(){
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        objectHomePage.getTitle();
    }
    @Test(priority = 1)
    public void SignIn(){
        objectHomePage.clickSignInButton();
        objectSignInPage.setEmailValue();
        objectSignInPage.setPasswordValue();
        objectSignInPage.clickSignInButton();

    }
    @Test(priority = 2)
    public void addAddress()  {
        objectHomePage.openUserAccountPage();
        objectUserAccountPage.clickManageAddress();
        objectAddressPage.clickAddNewAddressButton();
        objectNewAddressPage.enterAddressDetails();
        objectNewAddressPage.clickSaveAddressButton();
    }
    @Test(priority = 3)
    public void changeShippingAddress(){
        objectAddressPage.clickChangeShippingAddressBtn();
        objectNewAddressPage.updateCityAndZip("12346","Washington");
        objectNewAddressPage.clickSaveAddressButton();
        objectNewAddressPage.redirectToHomePage();

    }
    @Test(priority = 4)
    public void wishlistTest(){
        objectHomePage.openWhatsNewSection();
        objectWhatisNewPage.addThreeItemsToWishList();
        objectWhatisNewPage.visitWishlistPage();
        objectWhatisNewPage.removeFirstFromWishList();
        objectWhatisNewPage.lastItemAddToCart();
    }
    @Test(priority = 5)
    public void compareTest(){
        objectWhatisNewPage.openGearBagsSection();
        objectBagsPage.add2ItemsToCompareList();
        objectBagsPage.openCompareProductPage();
        objectCompareProductPage.addElementToCartWithMoreReviews();
        objectCompareProductPage.removeComparedElements();
    }
    @Test(priority = 6)
    public void cartFunctionality(){
        objectCompareProductPage.openCartPage();
        objectCartPage.printSizeOfCart();
        objectCartPage.increaseQuantityOfFirstCartItem();
        objectCartPage.printSizeOfCart();
        objectCartPage.printOrderTotal();
        objectCartPage.clickProceedToCheckout();
        objectCartPage.selectFixedShippingMethod();
        objectCartPage.clickOnNextButton();
        objectCartPage.clickPlaceOrder();
        objectCartPage.printOrderNumber();
    }
    @AfterTest
    public void TearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
