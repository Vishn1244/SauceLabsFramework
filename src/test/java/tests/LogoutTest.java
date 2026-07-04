package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pages.LoginPage;
import pages.MenuPage;
import utils.ConfigReader;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        LoginPage login = new LoginPage();

        login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        MenuPage menu = new MenuPage();

        menu.openMenu();

        menu.logout();

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("saucedemo.com"));

        System.out.println("Logout Successful");
    }
}