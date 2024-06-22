package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static locators.Locators.*;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
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
}
