package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import driver.DriverFactory;
import utils.Log;

public class CartPage extends BasePage {

    private WebDriver driver;

    private static final Logger logger =
            Log.getLogger(CartPage.class);

    public CartPage() {

        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public String getProductName() {

        logger.info("Getting Product Name");
        return getText(productName);
    }

    public void removeProduct() {

        logger.info("Removing Product");
        click(removeButton);
    }

    public void clickCheckout() {

        logger.info("Clicking Checkout Button");
        click(checkoutButton);
    }
}