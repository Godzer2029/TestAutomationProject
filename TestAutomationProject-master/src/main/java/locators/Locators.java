package locators;

import org.openqa.selenium.By;

public class Locators {
    public static final By MAGYAR_LANGUAGE_BUTTON_CHECK = By.xpath("//span[text()='Magyar']");
    public static final By ENGLISH_LANGUAGE_BUTTON_CHECK = By.xpath("//span[text()='English']");
    public static final By LANGUAGE_CHANGE_BUTTON = By.id("utility-header-language-switch-link");
    public static final By ACCEPT_COOKIES_BUTTON = By.xpath("//button[span[text()='Accept all cookies']]");
    public static final By SEARCH_FIELD = By.id("search-input");
    public static final By SEARCH_BUTTON = By.xpath("//*[@id='search-form']/button");
    public static final By GROCERIES_SEARCH_BUTTON = By.xpath("//button[@data-auto='empty-section--search-button']");
    public static final By SEARCH_RESULT_FIELD = By.xpath("//h1");
    public static final By SHOP_GROCERIES_BUTTON = By.xpath("//a[@data-auto='empty-section--browse-button']");
    public static final By GROCERIES_TREE = By.xpath("//div[@class='menu-tree__inner']");
    public static final By UNSUCCESSFUL_SEARCH_MESSAGE = By.xpath("//h3[contains(text(), \"We didn't find anything for\")]\n");
    public static final By ONLINE_CLUB_BUTTON = By.xpath("//a[text()='Online Club']");
    public static final By ONLINE_CLUB_LOGO = By.xpath("//h5[text()='Online Club']");
    public static final By REGISTER_BUTTON = By.xpath("//span[text()='Register']");
    public static final By EMAIL_FIELD = By.id("email");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By NEXT_BUTTON = By.xpath("//*[text()='Next']");
    public static final By PASSWORD_ERROR_MESSAGE = By.xpath("//div[@class='errors']//ul");
    public static final By BAKERY_BUTTON = By.xpath("//span[text()='Bakery']");
    public static final By PASTRY_BUTTON = By.xpath("//span[text()='Pastry']");
    public static final By CAKE_BUTTON = By.xpath("//span[text()='Cake']");
}
