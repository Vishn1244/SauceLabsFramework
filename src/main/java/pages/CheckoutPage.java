package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import driver.DriverFactory;
import utils.Log;

public class CheckoutPage extends BasePage {

    private WebDriver driver;

    private static final Logger logger =
            Log.getLogger(CheckoutPage.class);

    public CheckoutPage() {

        driver = DriverFactory.getDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void enterCheckoutInformation(String fn, String ln, String zip) {

        logger.info("Waiting for Checkout Page");

        logger.info("Current URL : " + driver.getCurrentUrl());
        logger.info("Current Title : " + driver.getTitle());

        wait.until(ExpectedConditions.visibilityOf(firstName));

        logger.info("Entering First Name");
        type(firstName, fn);

        logger.info("Entering Last Name");
        type(lastName, ln);

        logger.info("Entering Postal Code");
        type(postalCode, zip);
    }

    public void clickContinue() {

        logger.info("Clicking Continue");

        click(continueButton);
    }
}