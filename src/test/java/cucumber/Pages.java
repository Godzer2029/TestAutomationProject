package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pages {

    @FindBy(xpath = "//span[text()='Magyar']")
    WebElement magyarLanguageCheck;

    @FindBy(xpath = "//span[text()='English']")
    WebElement englishLanguageCheck;

    @FindBy(id = "utility-header-language-switch-link")
    WebElement languageChangeButton;

    @FindBy(xpath = "//button[span[text()=\"Accept all cookies\"]]")
    WebElement acceptCookiesButton;

    WebDriver driver;
    WebDriverWait wait;

    public Pages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForAcceptButton(){
        wait.until(ExpectedConditions.visibilityOf(acceptCookiesButton));
    }
    public void acceptCookies(){
        acceptCookiesButton.click();
    }
    public boolean currentLangIsEng(){
        return englishLanguageCheck.getText().equals("English");
    }
    public boolean currentLangIsMagyar(){
        return magyarLanguageCheck.getText().equals("Magyar");
    }
    public void clickOnChangeLanguageButton(){
        languageChangeButton.click();
    }

}
