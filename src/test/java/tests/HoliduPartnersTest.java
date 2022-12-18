package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.HoliduPartnersPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoliduPartnersTest {
    private WebDriver driver;
    private HoliduPartnersPage partnersPage;

    @BeforeEach
    public void setUp() {
        // Use WebDriverManager to automatically download and manage the WebDriver binary
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.holidu.com/partners");
        partnersPage = new HoliduPartnersPage(driver);
    }

    @Test
    public void testLogin() {
        // Use the page object to perform actions
        partnersPage.enterEmail("test@example.com");
        partnersPage.enterPassword("password");
        partnersPage.clickSubmitButton();

        // Make assertions to verify the results
        assertEquals("Logged in successfully", driver.getTitle());
    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

