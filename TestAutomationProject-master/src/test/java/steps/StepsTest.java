package steps;

import pages.MainPage;
import driver.DriverInitializer;
import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OnlineClubPage;
import pages.RegistrationPage;
import pages.SearchPage;

public class StepsTest {

    protected WebDriver driver;
    private final MainPage mainPage;
    private final SearchPage searchPage;
    private final RegistrationPage registrationPage;
    private final OnlineClubPage onlineClubPage;

public StepsTest(){
    this.driver = DriverInitializer.initDriver();
    this.searchPage = new SearchPage(this.driver);
    this.registrationPage = new RegistrationPage(this.driver);
    this.onlineClubPage = new OnlineClubPage(this.driver);
    this.mainPage = new MainPage(this.driver);
}
    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.TESCO_URL);
        mainPage.clickAcceptCookies();
    }

    @When("I change language to 'Magyar'")
    public void iChangeLanguageToHungarian() {
        mainPage.changeLanguageToMagyar();
    }

    @Then("language is changed to 'Magyar'")
    public void languageIsChangedToHungarian() {
        mainPage.isCurrentLanguageMagyar();
    }

    @When("I change language to 'English'")
    public void iChangeLanguageToEnglish() {
        mainPage.changeLanguageToEnglish();
    }

    @Then("language is changed to 'English'")
    public void languageIsChangedToEnglish() {
        mainPage.currentLanguageIsEnglish();
    }

    @Then("I type {string} into search field")
    public void iTypeIntoSearchField(String inputValue) {
        searchPage.inputValuesIntoSearchField(inputValue);
    }

    @When("I press the 'Search' button")
    public void iPressTheSearchButton() {
        searchPage.clickOnSearchButton();
    }

    @Then("Search results page is opened")
    public void resultsPageWithEnteredValueIsOpened() {
        searchPage.searchResultPageOpened();
    }

    @And("Message about unsuccessful search is shown")
    public void messageAboutUnsuccessfulSearchIsShown() {
        searchPage.messageAboutUnsuccessfulSearch();
    }

    @And("Shop and Search buttons are presented on page and clickable")
    public void shopOrSearchButtonArePresentedOnPageAndClickable() {
        searchPage.shopAndSearchButtons();
    }

    @When("I click on 'Online Club' button")
    public void iClickOnOnlineClubButton() {
        onlineClubPage.clickOnOnlineClubButton();
    }

    @Then("New tab with Online Club information is opened")
    public void newTabWithOnlineClubInformationIsOpened() {
        onlineClubPage.switchTabCheck();
    }

    @And("I click on 'Register' button")
    public void iClickOnRegistrationButton() {
        registrationPage.clickOnRegisterButton();
    }

    @Given("I enter {string} and {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        registrationPage.enterEmailAndPassword(email,password);
    }

    @When("I click on 'Next' button")
    public void iClickOnNextButton() {
        registrationPage.clickOnNextButton();
    }
    @Then("I should see {string} for password")
    public void iShouldSeeForPassword(String expectedResult) {
        registrationPage.validationResultForPassword(expectedResult);
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

    @Then("{string} category page is opened")
    public void cakeCategoryPageIsOpened(String expectedResult) {
        mainPage.checkSearchResultValue(expectedResult);
    }
}
