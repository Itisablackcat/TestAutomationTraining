package framework;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class PageBase {   ///baza do obsługi klas pagowych
    private WebDriver driver;
    public PageBase(WebDriver driver) {
        this.driver = driver;
        //inicjuje elementy na stronie
        PageFactory.initElements(driver, this);
    }

    //metoda sprawdzajaca czy element jest dostepny na stronie
    public boolean isElementVisible(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            e.printStackTrace();
            Reporter.log(e.toString());
            return false;
        }
    }

    //metoda czekanie aż element jest klikalny
    public void waitForElementToBeClickable (WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //metoda do klikania w element
    public void clickElement(WebElement element, int timeout) {
        waitForElementToBeClickable(element, timeout);
        element.click();
    }

    //metoda do wpisywania tekstu w polu
    public void sendKeysToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    //metoda do wyczyszczenia
    public void clearElement(WebElement element) {
        element.clear();
    }

    //metoda do najechania na element
    public void moveToElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }



}
