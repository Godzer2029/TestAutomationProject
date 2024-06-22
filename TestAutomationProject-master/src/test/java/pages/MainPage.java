package pages;

import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static locators.Locators.*;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver){
        super(driver);
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

    public void clickBakeryButton(){
        WebElement bakeryButtonElement = wait.until(ExpectedConditions.elementToBeClickable(BAKERY_BUTTON));
        bakeryButtonElement.click();
    }

    public void clickPastryButton(){
        WebElement pastryButtonElement = wait.until(ExpectedConditions.elementToBeClickable(PASTRY_BUTTON));
        pastryButtonElement.click();
    }

    public void clickCakeButton(){
        WebElement cakeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(CAKE_BUTTON));
        cakeButtonElement.click();
    }

    public void checkSearchResultValue(String expectedValue) {
        WebElement searchResultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_RESULT_FIELD));
        String searchActualResult = searchResultElement.getText();
        Assertions.assertEquals(searchActualResult, expectedValue);
    }

}


