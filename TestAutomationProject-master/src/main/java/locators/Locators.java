package locators;

import org.openqa.selenium.By;

public class Locators {
    public static final By MAGYAR_LANGUAGE_BUTTON_CHECK = By.xpath("//span[text()='Magyar']");
    public static final By ENGLISH_LANGUAGE_BUTTON_CHECK = By.xpath("//span[text()='English']");
    public static final By LANGUAGE_CHANGE_BUTTON = By.xpath("utility-header-language-switch-link");
    public static final By ACCEPT_COOKIES_BUTTON = By.xpath("//button[span[text()='Accept all cookies']]");
    public static final By SEARCH_FIELD = By.id("search-input");
    public static final By SEARCH_BUTTON = By.xpath("//*[@id='search-form']/button");
    public static final By SEARCH_RESULT_FIELD = By.xpath("//h1");
    public static final By ONLINE_CLUB_BUTTON = By.xpath("//a[text()='Online Club']");
    public static final By REGISTER_BUTTON = By.xpath("//span[text()='Register']");
    public static final By EMAIL_FIELD = By.id("email");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By NEXT_BUTTON = By.xpath("//*[text()='Next']");
    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[2]/section/div/div/form/ul/li[2]/div/div");
    public static final By BAKERY_BUTTON = By.xpath("//span[text()='Bakery']");
    public static final By PASTRY_BUTTON = By.xpath("//span[text()='Pastry']");
    public static final By CAKE_BUTTON = By.xpath("//span[text()='Cake']");
}
