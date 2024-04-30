package cucumber;

import driver.BrowserType;
import driver.DriverInitializer;
import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    WebDriver driver;
    WebDriverWait wait;
    Pages pages;

    @Before
    public  void initializeDriver(){
        driver = DriverInitializer.initDriver(BrowserType.CHROME);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        pages = new Pages(driver);
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.TESCO_URL);
        pages = new Pages(driver);
        pages.waitForAcceptButton();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        pages.acceptCookies();
    }

    @And("language is set to 'English'")
    public void languageIsSetToEnglish() {
        pages.currentLangIsEng();
    }

    @When("I change language to 'Hungarian'")
    public void iChangeLanguageToHungarian() {
        pages.clickOnChangeLanguageButton();
    }

    @Then("language is changed to 'Hungarian'")
    public void languageIsChangedToHungarian() {
        pages.currentLangIsMagyar();
    }
}
