package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {
   //pole
   protected WebDriver driver;

    @BeforeSuite
    public void setUp(ITestContext context){
        //Utworzenie obiektu ChromeOptions, dzięki czemu możemy zdefiniować różne parametry startu przeglądarki
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //Wskazanie ścieżki do chromedriver
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        //uruchomienie przeglądarki
        driver = new ChromeDriver();
        //zapisanie drivera do itest context aby był dostępny dla innych klas testowych bez uzycia statecznego drivera
        context.getSuite().setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl");

    }

    @BeforeClass
    public void loadDriverFromContext(ITestContext context) {
        this.driver = (WebDriver) context.getSuite().getAttribute("driver");
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}
