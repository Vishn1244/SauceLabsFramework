package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.BrowserFactory;
import driver.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        System.out.println("Selected Browser : " + browser);

        driver = BrowserFactory.createDriver(browser);

        DriverFactory.setDriver(driver);

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}