package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import driver.DriverFactory;
import utils.Log;

public class LoginPage extends BasePage {

    private WebDriver driver;

    private static final Logger logger =
            Log.getLogger(LoginPage.class);

    public LoginPage() {

        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public void login(String user, String pass) {

        logger.info("Entering Username");
        type(username, user);

        logger.info("Entering Password");
        type(password, pass);

        logger.info("Clicking Login Button");
        click(loginButton);
    }

    public boolean isErrorMessageDisplayed() {

        try {

            logger.info("Checking Login Error Message");

            return errorMessage.isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public String getErrorMessage() {

        try {

            logger.info("Reading Error Message");

            return errorMessage.getText();

        } catch (Exception e) {

            return "";
        }
    }

    public boolean isLoginSuccessful() {

        return driver.getCurrentUrl().contains("inventory.html");
    }
}