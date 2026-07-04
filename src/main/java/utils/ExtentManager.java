package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            // Report Path
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

            // Report Configuration
            spark.config().setDocumentTitle("SauceDemo Automation Report");
            spark.config().setReportName("Selenium Java Automation Framework");

            // Create Extent Report
            extent = new ExtentReports();

            // Attach Reporter
            extent.attachReporter(spark);

            // System Information
            extent.setSystemInfo("Tester", "Vishnu Obelisetty");
            extent.setSystemInfo("Project", "SauceDemo");
            extent.setSystemInfo("Framework", "Selenium + Java + TestNG");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extent;
    }
}