package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ExcelDataProvider;

public class LoginDataDrivenTest extends BaseTest {

    @Test(dataProvider = "loginData",
          dataProviderClass = ExcelDataProvider.class)
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {

        LoginPage login = new LoginPage();

        login.login(username, password);

        if (expectedResult.equalsIgnoreCase("Pass")) {

            InventoryPage inventory = new InventoryPage();

            Assert.assertEquals(
                    inventory.getProductsTitle(),
                    "Products");

        } else {

            Assert.assertTrue(
                    login.isErrorMessageDisplayed());

        }
    }
}