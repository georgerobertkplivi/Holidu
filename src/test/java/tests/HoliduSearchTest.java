package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoliduSearchTest extends BaseTest {
    public static WebDriver driver;

    @Test
    public void testSearch() {

        // Calculate the check-in date as two days from the current date
        LocalDate checkinDate = LocalDate.now().plusDays(2);
        String checkin = checkinDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Calculate the check-out date as seven days from the current date
        LocalDate checkoutDate = LocalDate.now().plusDays(7);
        String checkout = checkoutDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Use the Page Object to enter the search criteria and submit the form
        homePage.enterSearchCriteria("Spain", "Barcelona", checkin, checkout);
        homePage.submitSearch();
    }

    @Test
    public void testNavigationLinks() {
        homePage.clickNavigationLink("Properties");
        homePage.clickNavigationLink("Partners");

    }

    @Test
    public void testSignUp() {
        homePage.clickSignUpButton();
        homePage.enterSignUpEmail("test@example.com");
        homePage.enterSignUpPassword("password");
        homePage.clickSignUpSubmitButton();

        //  verify the results
        assertEquals("Sign-up successful", homePage.getSignUpMessage());
    }

    @Test
    public void testLanguageSwitch() {
        homePage.clickLanguageSwitch();
        homePage.selectLanguage("Deutsch");

        // verify the results
        assertEquals("Deutsch", homePage.getSelectedLanguage());
        assertEquals("Ferienhäuser & Ferienwohnungen weltweit mieten", homePage.getPageTitle());
    }

    @Test
    public void testLocationAutocomplete() {
        homePage.enterLocation("Pari");
        List<WebElement> autocompleteOptions = homePage.getLocationAutocompleteOptions();

        //  verify the results
        assertTrue(autocompleteOptions.size() > 0);
        for (WebElement option : autocompleteOptions) {
            assertTrue(option.isDisplayed());
            assertTrue(option.getText().contains("Paris"));
        }
    }

    @Test
    public void testSearchResults() {
        // Use the page object to perform actions
        homePage.enterLocation("Paris");
        homePage.clickSearchButton();

        //  verify the results
        assertEquals("Search results for Paris", driver.getTitle());
        List<WebElement> searchResults = homePage.getSearchResults();
        assertTrue(searchResults.size() > 0);
        for (WebElement result : searchResults) {
            assertTrue(result.isDisplayed());
            assertTrue(result.getText().contains("Paris"));
        }
    }

    @Test
    public void testFooter() {
        //  verify the results
        assertTrue(homePage.isFooterDisplayed());
        assertEquals(5, homePage.getFooterLinks().size());
        assertEquals("About us", homePage.getFooterLink(0).getText());
        assertEquals("Careers", homePage.getFooterLink(1).getText());
        assertEquals("Press", homePage.getFooterLink(2).getText());
        assertEquals("Contact", homePage.getFooterLink(3).getText());
        assertEquals("Terms & conditions", homePage.getFooterLink(4).getText());
    }

    @Test
    public void testSearchForm() {
        //  verify the results
        assertTrue(homePage.isSearchFormDisplayed());
        assertEquals("", homePage.getLocationInputText());

        homePage.enterLocation("Paris");
        homePage.clickSearchButton();

        //  verify the results
        assertEquals("Search results for Paris", driver.getTitle());
    }

    @Test
    public void testFilterByPrice() {
        homePage.selectPriceFilter("€100 - €200");
        List<WebElement> searchResults = homePage.getSearchResults();

        //  verify the results
        for (WebElement result : searchResults) {
            String priceText = result.findElement(By.cssSelector(".price")).getText();
            int price = Integer.parseInt(priceText.substring(1));
            assertTrue(price >= 100 && price <= 200);
        }
    }









}


