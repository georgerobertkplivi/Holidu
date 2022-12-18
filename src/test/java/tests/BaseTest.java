package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HoliduHomePage;


public abstract class BaseTest {
    public static WebDriver driver;

    public static HoliduHomePage homePage;

    @BeforeAll
    public static void setUp() {
        // Use the WebDriverManager to automatically download and configure the Chrome driver
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();

        // Use the WebDriverManager to automatically download and configure the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        homePage = PageFactory.initElements(driver, HoliduHomePage.class);

        // Navigate to the Holidu home page
        driver.get("https://www.holidu.com/");
    }

    public WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement findElementByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
