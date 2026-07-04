package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Log;

public class LoginTest extends BaseTest {

    // Logger for this class
    private static final Logger logger =
            Log.getLogger(LoginTest.class);

    @Test
    public void verifyValidLogin() {

        logger.info("Starting Login Test");

        LoginPage login = new LoginPage();

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        InventoryPage inventory = new InventoryPage();

        Assert.assertEquals(
                inventory.getProductsTitle(),
                "Products");

        logger.info("Login Test Passed");
    }
}