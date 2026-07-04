package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import driver.DriverFactory;
import utils.Log;

public class CheckoutOverviewPage extends BasePage {

    private WebDriver driver;

    private static final Logger logger =
            Log.getLogger(CheckoutOverviewPage.class);

    public CheckoutOverviewPage() {

        driver = DriverFactory.getDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void clickFinish() {

        logger.info("Clicking Finish Button");

        click(finishButton);
    }
}