package utils;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        try {

            WebDriver driver = DriverFactory.getDriver();

            if (driver == null) {
                System.out.println("Driver is NULL. Screenshot not captured.");
                return null;
            }

            // Create Screenshots folder if it doesn't exist
            File folder = new File(System.getProperty("user.dir") + "/Screenshots");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String path = folder.getAbsolutePath() + File.separator
                    + testName + "_" + timeStamp + ".png";

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destination = new File(path);

            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved at:");
            System.out.println(path);

            return path;

        } catch (Exception e) {

            System.out.println("Error while capturing screenshot:");
            e.printStackTrace();

            return null;
        }
    }
}