package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class MenuPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MenuPage() {

        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public void openMenu() {

        wait.until(ExpectedConditions.elementToBeClickable(menuButton));

        menuButton.click();
    }

    public void logout() {

        wait.until(ExpectedConditions.visibilityOf(logoutLink));

        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));

        logoutLink.click();
    }

}