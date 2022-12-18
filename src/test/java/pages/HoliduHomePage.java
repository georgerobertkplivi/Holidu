package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoliduHomePage {

    private WebDriver driver;

    @FindBy(id = "destination")
    private WebElement destinationInput;

    @FindBy(id = "checkin")
    private WebElement checkinInput;

    @FindBy(id = "checkout")
    private WebElement checkoutInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(css = ".sign-up-button")
    private WebElement signUpButton;

    @FindBy(css = "input[name='email']")
    private WebElement signUpEmailInput;

    @FindBy(css = "input[name='password']")
    private WebElement signUpPasswordInput;

    @FindBy(css = ".sign-up-form button[type='submit']")
    private WebElement signUpSubmitButton;

    @FindBy(css = ".sign-up-form .message")
    private WebElement signUpMessage;

    @FindBy(css = ".language-switch")
    private WebElement languageSwitch;

    @FindBy(css = ".language-options li")
    private List<WebElement> languageOptions;

    @FindBy(css = "input[name='location']")
    private WebElement locationInput;

    @FindBy(css = ".autocomplete-options li")
    private List<WebElement> locationAutocompleteOptions;

    @FindBy(css = ".navigation a")
    private List<WebElement> navigationLinks;

    @FindBy(css = ".filters .price-range input[name='min']")
    private WebElement minPriceInput;

    @FindBy(css = ".filters .price-range input[name='max']")
    private WebElement maxPriceInput;

    @FindBy(css = ".filters .price-range button")
    private WebElement priceRangeSubmitButton;

    @FindBy(css = ".search-results .result .price")
    private List<WebElement> searchResultPrices;

    @FindBy(css = "form[name='searchForm']")
    private WebElement searchForm;

    @FindBy(css = ".search-results .result")
    private List<WebElement> searchResults;


    @FindBy(css = ".filters label")
    private List<WebElement> filterLabels;

    @FindBy(css = "footer")
    private WebElement footer;

    @FindBy(css = "footer a")
    private List<WebElement> footerLinks;


    public HoliduHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchFormDisplayed() {
        return searchForm.isDisplayed();
    }

    public String getLocationInputText() {
        return locationInput.getAttribute("value");
    }

    public void enterMinPrice(int minPrice) {
        minPriceInput.clear();
        minPriceInput.sendKeys(Integer.toString(minPrice));
    }

    public void enterMaxPrice(int maxPrice) {
        maxPriceInput.clear();
        maxPriceInput.sendKeys(Integer.toString(maxPrice));
    }



    public void clickPriceRangeSubmitButton() {
        priceRangeSubmitButton.click();
    }

    public List<WebElement> getSearchResultPrices() {
        return searchResultPrices;
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void enterSearchCriteria(String destination, String checkin, String checkout, String s) {
        destinationInput.sendKeys(destination);
        checkinInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
    }

    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }

    public List<WebElement> getFooterLinks() {
        return footerLinks;
    }


    public void enterLocation(String location) {
        locationInput.sendKeys(location);
    }

    public List<WebElement> getLocationAutocompleteOptions() {
        return locationAutocompleteOptions;
    }

    public void clickNavigationLink(String linkText) {
        for (WebElement link : navigationLinks) {
            if (link.getText().equals(linkText)) {
                link.click();
                return;
            }
        }
    }


    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void enterSignUpEmail(String email) {
        signUpEmailInput.sendKeys(email);
    }

    public void enterSignUpPassword(String password) {
        signUpPasswordInput.sendKeys(password);
    }

    public void clickSignUpSubmitButton() {
        signUpSubmitButton.click();
    }

    public String getSignUpMessage() {
        return signUpMessage.getText();
    }

    public void clickLanguageSwitch() {
        languageSwitch.click();
    }

    public void selectLanguage(String language) {
        for (WebElement option : languageOptions) {
            if (option.getText().equals(language)) {
                option.click();
                return;
            }
        }
    }

    public String getSelectedLanguage() {
        for (WebElement option : languageOptions) {
            if (option.getAttribute("class").contains("selected")) {
                return option.getText();
            }
        }
        return "";
    }

    public String getPageTitle() {
        return driver.getTitle();
    }




    public void submitSearch() {
        searchButton.click();
    }
}

