package pages;

import framework.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends PageBase {
    //deklaracja konstruktora klasy
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement passwordInput;

   @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement submitLoginButton;

    //metody spr widoczność
    public boolean isEmailInputVisible(int timeout) {
        return isElementVisible(emailInput, timeout);
    }
    public boolean isPasswordInputVisible(int timeout) {
        return isElementVisible(passwordInput, timeout);
    }
    public boolean isSubmitLoginButtonVisible(int timeout) {
        return isElementVisible(submitLoginButton, timeout);
    }

    public void enterEmail(String email) {
        sendKeysToElement(emailInput, email);
    }
    public void enterPassword(String password) {
        sendKeysToElement(passwordInput, password);
    }
    public void clickSubmitLoginButton(int timeout) {
        clickElement(submitLoginButton, timeout);

    }
}
