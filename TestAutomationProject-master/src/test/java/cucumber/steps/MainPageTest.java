package cucumber.steps;

import driver.Settings;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static locators.Locators.*;

public class MainPageTest {

    @FindBy(xpath = "//span[text()='Bakery']")
    WebElement bakeryButton;

    @FindBy(xpath = "//span[text()='Pastry']")
    WebElement pastryButton;

    @FindBy(xpath = "//span[text()='Cake']")
    WebElement cakeButton;

    protected WebDriver driver;
    protected WebDriverWait wait;

    //конструктор класса
    public MainPageTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //TODO Вынести вэйт
    public void clickAcceptCookies() {
        WebElement acceptCookiesElement = wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BUTTON));
        acceptCookiesElement.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ACCEPT_COOKIES_BUTTON));
    }
    public void changeLanguageToMagyar() {
    WebElement currentLanguageIsEnglish = driver.findElement(MAGYAR_LANGUAGE_BUTTON_CHECK);
    if (!currentLanguageIsEnglish.getText().equals("English")) {
        WebElement languageChangeButtonElement = driver.findElement(LANGUAGE_CHANGE_BUTTON);
        languageChangeButtonElement.click();
    }
    }
    public void isCurrentLanguageMagyar(){
        String expectedUrl = Settings.TESCO_MAGYAR_URL;
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,currentUrl);
    }
    public void changeLanguageToEnglish() {
        WebElement currentLanguageIsMagyar = driver.findElement(ENGLISH_LANGUAGE_BUTTON_CHECK);
        if (!currentLanguageIsMagyar.getText().equals("Magyar")) {
            WebElement languageChangeButtonElement = driver.findElement(LANGUAGE_CHANGE_BUTTON);
            languageChangeButtonElement.click();
        }
    }
    public void currentLanguageIsEnglish(){
        String expectedUrl = Settings.TESCO_ENGLISH_URL;
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,currentUrl);
    }
    public void clickOnSearchButton(){
        WebElement searchButtonElement = driver.findElement(SEARCH_BUTTON);
        searchButtonElement.click();
    }
    public void inputValuesIntoSearchField(String inputValue){
        WebElement searchFieldElement = driver.findElement(SEARCH_FIELD);
        searchFieldElement.clear();
        searchFieldElement.sendKeys(inputValue);
    }
    public void searchResultPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_RESULT_FIELD));
    }
    public void messageAboutUnsuccessfulSearch(){
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(UNSUCCESSFUL_SEARCH_MESSAGE));
        Assertions.assertTrue(messageElement.isDisplayed());
    }
    public void shopAndSearchButtons(){
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(GROCERIES_SEARCH_BUTTON));
        searchButtonElement.click();
        WebElement shopGroceriesButtonElement = wait.until(ExpectedConditions.elementToBeClickable(SHOP_GROCERIES_BUTTON));
        shopGroceriesButtonElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(GROCERIES_TREE));
    }

    public void clickOnOnlineClubButton() {
        WebElement onlineClubButtonElement = wait.until(ExpectedConditions.elementToBeClickable(ONLINE_CLUB_BUTTON));
        onlineClubButtonElement.click();
    }

    public void switchTabCheck() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(ONLINE_CLUB_LOGO));
        String expectedUtl = Settings.TESCO_ONLINE_CLUB_URL;
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUtl, currentUrl);
    }

    public void clickOnRegisterButton(){
        WebElement registerButtonElement = wait.until(ExpectedConditions.elementToBeClickable(REGISTER_BUTTON));
        registerButtonElement.click();
    }

    public void enterEmailAndPassword(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FIELD));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(password);
    }

    public void clickOnNextButton(){
        WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        nextButtonElement.click();
    }
    public void validationResultForPassword(String expectedResult) {
        if (!expectedResult.equals("valid")) {
            WebElement validationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_ERROR_MESSAGE));
            String actualResult = validationMessageElement.getText();

            if (expectedResult.equals("required")) {
                Assertions.assertTrue(actualResult.contains("Please provide a password"));
            } else if (expectedResult.equals("invalid")) {
                Assertions.assertTrue(actualResult.contains("Password must be at least 8 letters and must include both numbers and letters."));
            } else {
                Assertions.fail("Unexpected validation result: " + expectedResult);
            }
        }
    }

    public void clickBakeryButton(){
        bakeryButton.click();
    }

    public void clickPastryButton(){
        wait.until(ExpectedConditions.visibilityOf(pastryButton));
        pastryButton.click();
    }

    public void clickCakeButton(){
        wait.until(ExpectedConditions.visibilityOf(cakeButton));
        cakeButton.click();
    }

//    public void checkSearchResultValueForCake() {
//        String textFromResults = searchResultField.getText();
//        String expectedText = "Cake";
//        Assertions.assertEquals(textFromResults, expectedText);
//    }

}


