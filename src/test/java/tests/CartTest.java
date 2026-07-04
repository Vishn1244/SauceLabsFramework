package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Log;

public class CartTest extends BaseTest {

    private static final Logger logger =
            Log.getLogger(CartTest.class);

    @Test
    public void verifyCartPage() {

        logger.info("Starting Cart Test");

        LoginPage login = new LoginPage();
        login.login(ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        InventoryPage inventory = new InventoryPage();
        inventory.addBackpackToCart();
        inventory.clickCart();

        CartPage cart = new CartPage();

        Assert.assertEquals(cart.getProductName(),
                "Sauce Labs Backpack");

        logger.info("Cart Verification Successful");
    }
}