package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Log;

public class AddToCartTest extends BaseTest {

    private static final Logger logger =
            Log.getLogger(AddToCartTest.class);

    @Test
    public void verifyAddProductToCart() {

        logger.info("Starting Add To Cart Test");

        LoginPage login = new LoginPage();

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        InventoryPage inventory = new InventoryPage();

        Assert.assertEquals(inventory.getProductsTitle(), "Products");

        inventory.addBackpackToCart();

        Assert.assertEquals(inventory.getCartCount(), "1");

        logger.info("Product Added Successfully");
    }
}