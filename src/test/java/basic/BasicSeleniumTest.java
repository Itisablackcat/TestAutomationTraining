package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicSeleniumTest {
    //Deklaracja WebDriver na poziomie pola klasy, dzięki czemu będzie on dostępny dla innych metod w tej klasie
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        //Utworzenie obiektu ChromeOptions, dzięki czemu możemy zdefiniować różne parametry startu przeglądarki
        ChromeOptions options = new ChromeOptions();
        //Wskazanie, że chcemy uruchomić przeglądarkę w trybie incognito
        options.addArguments("--incognito");
        //Wskazanie ścieżki do chromedriver
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        //uruchomienie przeglądarki
        driver = new ChromeDriver();  //to jest tylko obiekt
        //potrezbujemy sterownika - pliku wykonywalnego
        //Ustawienie domyślnego timeout - tyle czasu driver będzie czekał na dany element, jeżeli nie ustawimy domyślnego timeout,
//To w przypadku dłuższego wczytywania strony poleci momentalnie poleci wyjątek NoSuchElementException, ponieważ domyślnie
//timeout jest ustawiony na 0 i żeby Selenium znalazło element, to musi on momentalnie być dostępny na stronie
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Maksymalizacja okna
        driver.manage().window().maximize();
        //wejscie na strone
        driver.get("http://www.automationpractice.pl");

    }

    @Test
    public void loginTest(){
        //driver.findElement(By.cssSelector("#header > div.nav > div.container > div.row > nav > div.header_user_info > a")).click();
        driver.findElement(By.xpath("//a[@class='login']")).click();
        //driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Izabela.grempka@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Dodoptak71");
        driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();

        //String title = driver.getCurrentUrl();
        //String url = "http://www.automationpractice.pl/index.php?controller=my-account";
        //String myAccount = "a[title='View my customer account'] span";
        //Weryfikacja wyświetlenia przycisku account
        //driver.findElement(By.cssSelector("div.header_user_info > a.account")).isDisplayed();
        //driver.findElement(By.cssSelector("a[title='View my customer account'] span")).isDisplayed();
        //Assert.assertEquals(title, "http://www.automationpractice.pl/index.php?controller=my-account");

        try {
            //proba uruchomienia asercji
            Assert.assertTrue(driver.findElement(By.cssSelector("div.header_user_info > a.account")).isDisplayed());
            //w przypadku wystapienia NoSuchExpection zostanie to wykonane to, co zadeklarowaliśmy w srodku bloku catch
        } catch (NoSuchElementException e) {
            //e.printStackTrace();
            Reporter.log(e.toString());
            throw new AssertionError("Button My Account was not displayed.");

        }
    }


    @AfterClass
    public void closeBrowser() {
        //Zamknięcie okna przeglądarki i ubicie chromedriver'a
        driver.quit();
    }
}
