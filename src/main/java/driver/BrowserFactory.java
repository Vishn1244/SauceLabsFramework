package driver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

        case "chrome":

            ChromeOptions chromeOptions = new ChromeOptions();

            HashMap<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            chromeOptions.setExperimentalOption("prefs", prefs);

            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--incognito");

            driver = new ChromeDriver(chromeOptions);

            break;

        case "firefox":

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            driver = new FirefoxDriver(firefoxOptions);

            break;

        case "edge":

            EdgeOptions edgeOptions = new EdgeOptions();

            edgeOptions.addArguments("--disable-notifications");
            edgeOptions.addArguments("--disable-popup-blocking");
            edgeOptions.addArguments("--inprivate");

            driver = new EdgeDriver(edgeOptions);

            break;

        default:

            throw new RuntimeException("Browser Not Supported : " + browser);
        }

        return driver;
    }
}