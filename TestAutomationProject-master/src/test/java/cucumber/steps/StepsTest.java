package cucumber.steps;

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

public class StepsTest {

    WebDriver driver;
    WebDriverWait wait;
    MainPageTest mainPageTest;


    //TODO Перенести в класс драйвер
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

    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.TESCO_URL);
        mainPageTest = new MainPageTest(driver);
        mainPageTest.clickAcceptCookies();
    }

    @When("I change language to 'Magyar'")
    public void iChangeLanguageToHungarian() {
        mainPageTest.changeLanguageToMagyar();
    }

    @Then("language is changed to 'Magyar'")
    public void languageIsChangedToHungarian() {
        mainPageTest.isCurrentLanguageMagyar();
    }

    @When("I change language to 'English'")
    public void iChangeLanguageToEnglish() {
        mainPageTest.changeLanguageToEnglish();
    }

    @Then("language is changed to 'English'")
    public void languageIsChangedToEnglish() {
        mainPageTest.currentLanguageIsEnglish();
    }

    @Then("I type {string} into search field")
    public void iTypeIntoSearchField(String inputValue) {
        mainPageTest.inputValuesIntoSearchField(inputValue);
    }

    @When("I press the 'Search' button")
    public void iPressTheSearchButton() {
        mainPageTest.clickOnSearchButton();
    }

    @Then("Search results page is opened")
    public void resultsPageWithEnteredValueIsOpened() {
        mainPageTest.searchResultPageOpened();
    }

    @And("Message about unsuccessful search is shown")
    public void messageAboutUnsuccessfulSearchIsShown() {
        mainPageTest.messageAboutUnsuccessfulSearch();
    }

    @And("Shop and Search buttons are presented on page and clickable")
    public void shopOrSearchButtonArePresentedOnPageAndClickable() {
        mainPageTest.shopAndSearchButtons();
    }

    @When("I click on 'Online Club' button")
    public void iClickOnOnlineClubButton() {
        mainPageTest.clickOnOnlineClubButton();
    }

    @Then("New tab with Online Club information is opened")
    public void newTabWithOnlineClubInformationIsOpened() {
        mainPageTest.switchTabCheck();
    }

    @And("I click on 'Register' button")
    public void iClickOnRegistrationButton() {
        mainPageTest.clickOnRegisterButton();
    }

    @Given("I enter {string} and {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        mainPageTest.enterEmailAndPassword(email,password);
    }

    @When("I click on 'Next' button")
    public void iClickOnNextButton() {
        mainPageTest.clickOnNextButton();
    }
    @Then("I should see {string} for password")
    public void iShouldSeeForPassword(String expectedResult) {
        mainPageTest.validationResultForPassword(expectedResult);
    }

    @And("I click on 'Bakery' button")
    public void iClickOnBakeryButton() {
        mainPageTest.clickBakeryButton();
    }

    @And("I click on 'Pastry' button")
    public void iClickOnPastryButton() {
        mainPageTest.clickPastryButton();
    }

    @When("I click on 'Cake' button")
    public void iClickOnCakeButton() {
        mainPageTest.clickCakeButton();
    }
}
