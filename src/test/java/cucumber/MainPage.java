package cucumber;

import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MainPage {

    @FindBy(xpath = "//span[text()='Magyar']")
    WebElement magyarLanguageButtonCheck;

    @FindBy(xpath = "//span[text()='English']")
    WebElement englishLanguageButtonCheck;

    @FindBy(id = "utility-header-language-switch-link")
    WebElement languageChangeButton;

    @FindBy(xpath = "//button[span[text()='Accept all cookies']]")
    WebElement acceptCookiesButton;

    @FindBy(id = "search-input")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='search-form']/button")
    WebElement searchButton;

    //TODO Move to different class as it is not main page
    @FindBy(xpath = "//h1")
    WebElement searchResultField;

    @FindBy(xpath = "//a[text()='Online Club']")
    WebElement onlineClubButton;

    @FindBy(xpath = "//span[text()='Register']")
    WebElement registerButton;

    //TODO Move to different class as it is not main page
    @FindBy(id = "email")
    WebElement emailField;

    //TODO Move to different class as it is not main page
    @FindBy(id = "password")
    WebElement passwordField;

    //TODO Move to different class as it is not main page
    @FindBy(xpath = "//*[text()='Next']")
    WebElement nextButton;

    //TODO Move to different class as it is not main page
    //TODO Make shorter xpath, if possible
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//span[text()='Bakery']")
    WebElement bakeryButton;

    @FindBy(xpath = "//span[text()='Pastry']")
    WebElement pastryButton;

    @FindBy(xpath = "//span[text()='Cake']")
    WebElement cakeButton;

    WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForAcceptButton() {
        wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public boolean magyarButtonPresent() {
        return magyarLanguageButtonCheck.getText().equals("Magyar");
    }

    public boolean currentLangIsMagyar() {
        return englishLanguageButtonCheck.getText().equals("English");
    }

    public void clickOnChangeLanguageButton() {
        languageChangeButton.click();
    }

    //TODO Is it possible to make in more generic and not just Cucumber o_o
    public void inputValueForSearchField() {
        searchField.sendKeys("Cucumber");
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void waitForResultField() {
        wait.until(ExpectedConditions.visibilityOf(searchResultField));
    }

    //TODO Same cucumber here o_o
    public void checkSearchResultValueForCucumber() {
        String textFromResults = searchResultField.getText();
        String expectedText = "Results for “Cucumber”";
        Assertions.assertEquals(textFromResults, expectedText);
    }

    public void clickOnOnlineClubButton() {
        onlineClubButton.click();
    }

    //TODO Loop is not needed
    public void switchTabCheck() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        String expectedUtl = Settings.TESCO_ONLINE_CLUB_URL;
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUtl, currentUrl);
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }
    public void inputValuesForEmailAndPasswordFields(){
        String[][] examplesData = {
                {"123@gmail.com", null},
                {"123@gmail.com", "abc1234"},
                {"123@gmail.com", "abc12345"}
        };

        for (String[] rowData : examplesData){
            String email = rowData[0];
            String password = rowData[1];

            emailField.sendKeys(email);
            if (password != null) {
                passwordField.sendKeys(password);
            }

            emailField.clear();
            passwordField.clear();
        }
    }

    public void clickOnNextButton(){
        nextButton.click();
    }

    public void waitForPasswordErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(passwordErrorMessage));
    }

    public void errorMesageNotDisplayed(){
        boolean isErrorMessageDisplayed = passwordErrorMessage.isDisplayed();
        Assertions.assertFalse(isErrorMessageDisplayed);
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

    public void checkSearchResultValueForCake() {
        String textFromResults = searchResultField.getText();
        String expectedText = "Cake";
        Assertions.assertEquals(textFromResults, expectedText);
    }

}


