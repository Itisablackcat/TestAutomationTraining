package pages;

import framework.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBarPage extends PageBase {
    @FindBy(css = "a.login")
    private WebElement signInButton;

    @FindBy(css = "a.account")
    private WebElement myAccountButton;

    @FindBy(css = "a.logout")
    private WebElement signOutButton;

    public TopBarPage(WebDriver driver) {
        super(driver);
    }

    //metody spr widoczność
    public boolean isSignInButtonVisible(int timeout) {
        return isElementVisible(signInButton, timeout);
    }

    public boolean isMyAccountButtonVisible(int timeout) {
        return isElementVisible(myAccountButton, timeout);
    }

    public boolean isSignOutButtonVisible(int timeout) {
        return isElementVisible(signOutButton, timeout);
    }

    //metody klikajace

    public void clickSignInButton(int timeout) {
        clickElement(signInButton, timeout);
    }
    public void clickMyAccountButton(int timeout) {
        clickElement(myAccountButton, timeout);
    }
    public void clickSignOutButton(int timeout) {
        clickElement(signOutButton, timeout);
    }




}
