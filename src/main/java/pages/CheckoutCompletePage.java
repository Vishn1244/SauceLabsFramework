package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import driver.DriverFactory;
import utils.Log;

public class CheckoutCompletePage extends BasePage {

    private WebDriver driver;

    private static final Logger logger =
            Log.getLogger(CheckoutCompletePage.class);

    public CheckoutCompletePage() {

        driver = DriverFactory.getDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    private WebElement successMessage;

    public String getSuccessMessage() {

        logger.info("Reading Success Message");

        return getText(successMessage);
    }
}