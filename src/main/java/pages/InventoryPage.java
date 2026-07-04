package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import driver.DriverFactory;
import utils.Log;

public class InventoryPage extends BasePage {

    private WebDriver driver;

    private static final Logger logger =
            Log.getLogger(InventoryPage.class);

    public InventoryPage() {

        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpack;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public void clickCart() {

        logger.info("Clicking Cart Icon");
        click(cartIcon);
    }

    public String getProductsTitle() {

        logger.info("Reading Products Title");
        return getText(productsTitle);
    }

    public void addBackpackToCart() {

        logger.info("Clicking Add To Cart");
        click(addBackpack);
    }

    public String getCartCount() {

        logger.info("Reading Cart Badge");
        return getText(cartBadge);
    }
}