package cucumber.steps;

import cucumber.steps.MainPage;
import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;

    //TODO Maybe it is better to make iOpenTescoWebsite and iAcceptCookies methods as @Before
    @Before
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @After
    public void closeDriver(){
        driver.quit();
    }

    //TODO ****
    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.TESCO_URL);
        mainPage = new MainPage(driver);
        mainPage.waitForAcceptButton();
    }

    //TODO ****
    @And("I accept cookies")
    public void iAcceptCookies() {
        mainPage.acceptCookies();
    }

    @And("'Magyar' button is present on page")
    public void languageIsSetToEnglish() {
        mainPage.magyarButtonPresent();
    }

    //TODO Magyar - not Hungarian
    @When("I change language to 'Magyar'")
    public void iChangeLanguageToHungarian() {
        mainPage.clickOnChangeLanguageButton();
    }

    //TODO Magyar - not Hungarian
    @Then("language is changed to 'Magyar'")
    public void languageIsChangedToHungarian() {
        mainPage.currentLangIsMagyar();
    }

    //TODO Bad naming. May be confusing
    @And("'English' button is present on page")
    public void englishButtonIsPresentOnPage() {
        mainPage.currentLangIsMagyar();
    }

    @When("I change language to 'English'")
    public void iChangeLanguageToEnglish() {
        mainPage.clickOnChangeLanguageButton();
    }

    @Then("language is changed to 'English'")
    public void languageIsChangedToEnglish() {
        mainPage.magyarButtonPresent();
    }


    @And("I type 'Cucumber' into search field")
    public void iTypeCucumberIntoSearchField() {
        mainPage.inputValueForSearchField();
    }

    @When("I press the 'Search' button")
    public void iPressTheSearchButton() {
        mainPage.clickOnSearchButton();
    }

    @Then("Search results page is opened")
    public void resultsPageWithEnteredValueIsOpened() {
        mainPage.waitForResultField();
    }

    @And("'Cucumber' value is shown on page")
    public void cucumberValueIsShownOnPage() {
        mainPage.checkSearchResultValueForCucumber();
    }

    @When("I click on 'Online Club' button")
    public void iClickOnOnlineClubButton() {
        mainPage.clickOnOnlineClubButton();
    }

    @Then("New tab with Online Club information is opened")
    public void newTabWithOnlineClubInformationIsOpened() {
        mainPage.switchTabCheck();
    }

    @And("I click on 'Register' button")
    public void iClickOnRegistrationButton() {
        mainPage.clickOnRegisterButton();
    }

    @Given("I enter {string} and {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        mainPage.inputValuesForEmailAndPasswordFields();
    }

    @When("I click on 'Next' button")
    public void iClickOnNextButton() {
        mainPage.clickOnNextButton();
    }

    @Then("I see validation error for password")
    public void iSeeValidationErrorForPassword() {
        mainPage.waitForPasswordErrorMessage();
    }

    @Then("I don't see validation error for password")
    public void iDonTSeeValidationErrorForPassword() {
        mainPage.errorMesageNotDisplayed();
    }

    @And("I click on 'Bakery' button")
    public void iClickOnBakeryButton() {
        mainPage.clickBakeryButton();
    }

    @And("I click on 'Pastry' button")
    public void iClickOnPastryButton() {
        mainPage.clickPastryButton();
    }

    @When("I click on 'Cake' button")
    public void iClickOnCakeButton() {
        mainPage.clickCakeButton();
    }

    //TODO result is for all
    @Then("'Cake' category page is opened")
    public void cakeCategoryPageIsOpened() {
        mainPage.waitForResultField();
    }

    @And("'Cake' value is shown on page")
    public void cakeValueIsShownOnPage() {
        mainPage.checkSearchResultValueForCake();
    }
}
