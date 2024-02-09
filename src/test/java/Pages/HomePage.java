package Pages;
import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    String tempEmail = "name@0001gmail.com";
    String tempPassword = "admin@123";
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void SignIn(){
        driver.findElement(By.cssSelector(".panel .authorization-link a")).click();
        driver.findElement(By.id("email")).sendKeys(tempEmail);
        driver.findElement(By.cssSelector(".login-container #pass")).sendKeys(tempPassword);
        driver.findElement(By.cssSelector(".login-container #send2")).click();
        System.out.println(driver.getTitle());
    }
//       @Test(priority = 1)
        public void my_account(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".panel button")));
            driver.findElement(By.cssSelector(".panel button")).click();
           wait = new WebDriverWait(driver, Duration.ofSeconds(7));
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='panel header']//a[contains(text(),'My Account')]")));
            driver.findElement(By.xpath("//*[@class='panel header']//a[contains(text(),'My Account')]")).click();
    //        driver.findElement(By.xpath("//a[@data-ui-id='Rahuldefault-billing-edit-link']")).click();
            //*[@class='panel header']//a[contains(text(),'My Account')]
            //a[@data-ui-id="default-billing-edit-link"]
           driver.findElement(By.cssSelector(".block-title a")).click();
           driver.findElement(By.cssSelector("button[title='Add New Address']")).click();
            driver.findElement(By.id("telephone")).sendKeys("4674052952");

    //        driver.findElement(By.id("country")).click();
            driver.findElement(By.xpath("//option[@value='US']")).click();

            driver.findElement(By.xpath("//option[@value='62']")).click();
            driver.findElement(By.id("zip")).clear();
            driver.findElement(By.id("zip")).sendKeys("98103");
            driver.findElement(By.id("city")).sendKeys("Seattle");
            driver.findElement(By.id("street_1")).sendKeys("House No-1");
            driver.findElement(By.xpath("//button[@title='Save Address']")).click();
        }


        @Test(priority = 2)
        public void wishlist(){
    //        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("ui-id-17"))).click();
            driver.findElement(By.id("ui-id-3")).click();
            WebElement target = driver.findElement(By.xpath("(//*[@class='product-item']//div[@class='product-item-details'])[1]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//a[@class='action towishlist'])[1]")).click();
    //        driver.findElement(By.xpath("(//a[@class='action towishlist'])[2]")).click();
    //        driver.findElement(By.xpath("(//a[@class='action towishlist'])[3]")).click();

            driver.findElement(By.id("ui-id-3")).click();
            target = driver.findElement(By.xpath("(//*[@class='product-item-details'])[2]"));
            actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//a[@class='action towishlist'])[2]")).click();



            driver.findElement(By.id("ui-id-3")).click();
            target = driver.findElement(By.xpath("(//*[@class='product-item-details'])[3]"));
            actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//a[@class='action towishlist'])[3]")).click();



            target = driver.findElement(By.xpath("(//*[@class='product-item-info'])[1]"));
            actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//*[@class='product-item-info'])[1]//a[@title='Remove Item']")).click();

            target = driver.findElement(By.xpath("(//*[@class='product-item-info'])[2]"));
            actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//*[@class='product-item-info'])[2]//button")).click();
            driver.findElement(By.xpath("(//div[contains(@id,'option-label-size')])[1]")).click();
            driver.findElement(By.xpath("(//div[contains(@id,'option-label-color')])[1]")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
            driver.findElement(By.id("product-addtocart-button")).click();
        }



        @Test(priority = 3)
        public void compareList(){


            WebElement target = driver.findElement(By.id("ui-id-6"));
            Actions actions  = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.id("ui-id-25")).click();

            target = driver.findElement(By.xpath("(//*[@class='product details product-item-details'])[1]"));
            actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]")).click();

            target = driver.findElement(By.xpath("(//*[@class='product details product-item-details'])[2]"));
            actions = new Actions(driver);
            actions.moveToElement(target).perform();
            driver.findElement(By.xpath("(//a[@title='Add to Compare'])[2]")).click();

        }

        @Test(priority=4)
        public void compareList2(){
            driver.findElement(By.cssSelector("a[title='Compare Products']")).click();
            String reviewText1 = driver.findElement(By.xpath("(//a[@class='action view'])[1]")).getText();
            int reviewCount1 = Integer.parseInt((reviewText1.split(" "))[0]);
            String reviewText2 = driver.findElement(By.xpath("(//a[@class='action view'])[2]")).getText();
            int reviewCount2 = Integer.parseInt((reviewText2.split(" "))[0]);
            if(reviewCount1>=reviewCount2){
                driver.findElement(By.xpath("(//div[@class='product-item-actions hidden-print'])[1]//button")).click();
            }else{
                driver.findElement(By.xpath("(//div[@class='product-item-actions hidden-print'])[2]//button")).click();
            }
            driver.findElement(By.xpath("(//a[@title='Remove Product'])[1]")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-accept")));
            driver.findElement(By.cssSelector(".action-accept")).click();

            wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@title='Remove Product'])[1]")));
            driver.findElement(By.xpath("(//a[@title='Remove Product'])[1]")).click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-accept")));
            driver.findElement(By.cssSelector(".action-accept")).click();
        }


    @Test(priority = 5)
    public void cart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".showcart")));
        driver.findElement(By.cssSelector(".showcart")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".viewcart")));
        driver.findElement(By.cssSelector(".viewcart")).click();
        int cartSize = Integer.parseInt(driver.findElement(By.cssSelector(".counter-number")).getText());
        System.out.println("Cart Size = "+cartSize);
        String orderTotal = (driver.findElement(By.cssSelector(".grand .price")).getText());
        System.out.println("Order Total : "+orderTotal);

        driver.findElement(By.cssSelector("button[data-role='proceed-to-checkout']")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shipping-method-buttons-container > div > button")));
        driver.findElement(By.id("label_method_flatrate_flatrate")).click();

        driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement x =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Place Order']")));
        x.click();

        String orderNumber = driver.findElement(By.cssSelector(".order-number")).getText();
        System.out.println("Order Number is : " + orderNumber);
    }




    @AfterTest
    void tearDown(){
        driver.quit();
    }

}
