package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static locators.Locators.*;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
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
}
