package pages;

import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static locators.Locators.ONLINE_CLUB_BUTTON;
import static locators.Locators.ONLINE_CLUB_LOGO;

public class OnlineClubPage extends BasePage{
    public OnlineClubPage(WebDriver driver) {
        super(driver);
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
}
