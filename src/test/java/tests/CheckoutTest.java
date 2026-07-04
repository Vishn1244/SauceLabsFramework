package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Log;

public class CheckoutTest extends BaseTest {

    private static final Logger logger =
            Log.getLogger(CheckoutTest.class);

    @Test
    public void verifyCheckout() {

        logger.info("========== Checkout Test Started ==========");

        // Login
        LoginPage login = new LoginPage();

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        logger.info("Login Successful");

        // Inventory Page
        InventoryPage inventory = new InventoryPage();

        Assert.assertEquals(
                inventory.getProductsTitle(),
                "Products");

        logger.info("Inventory Page Loaded");

        // Add Product
        inventory.addBackpackToCart();

        Assert.assertEquals(
                inventory.getCartCount(),
                "1");

        logger.info("Product Added Successfully");

        // Open Cart
        inventory.clickCart();

        logger.info("Cart Opened");

        // Cart Page
        CartPage cart = new CartPage();

        Assert.assertEquals(
                cart.getProductName(),
                "Sauce Labs Backpack");

        logger.info("Product Verified");

        // Checkout
        cart.clickCheckout();

        logger.info("Checkout Page Opened");

        // Checkout Information
        CheckoutPage checkout = new CheckoutPage();

        checkout.enterCheckoutInformation(
                "John",
                "Smith",
                "500001");

        logger.info("Checkout Details Entered");

        checkout.clickContinue();

        logger.info("Continue Button Clicked");

        // Overview Page
        CheckoutOverviewPage overview =
                new CheckoutOverviewPage();

        overview.clickFinish();

        logger.info("Finish Button Clicked");

        // Complete Page
        CheckoutCompletePage complete =
                new CheckoutCompletePage();

        Assert.assertEquals(
                complete.getSuccessMessage(),
                "Thank you for your order!");

        logger.info("Order Completed Successfully");

        logger.info("========== Checkout Test Passed ==========");
    }
}