package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public  class DriverInitializer {
    public static WebDriver initDriver() {
        return initDriver(BrowserType.CHROME);
    }

    public static WebDriver initDriver(BrowserType type) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}