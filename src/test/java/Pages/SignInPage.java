package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;
    String email = "name@0001gmail.com";
    String password = "admin@123";
    @FindBy(id = "email")
    WebElement emailInputBox;

    @FindBy(css = ".login-container #pass")
    WebElement passwordInputBox;

    @FindBy(css = ".login-container #send2")
    WebElement signInButton;


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmailValue() {
        emailInputBox.sendKeys(email);
    }

    public void setPasswordValue(){
        passwordInputBox.sendKeys(password);
    }
    public void clickSignInButton(){
        signInButton.click();
    }

}
