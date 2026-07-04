package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("===== Test Execution Started =====");
    }

    @Override
    public void onTestStart(ITestResult result) {

        test.set(
                extent.createTest(
                        result.getMethod().getMethodName()));

        System.out.println(
                "Running Test : "
                        + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

        System.out.println(
                result.getMethod().getMethodName()
                        + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("===== TEST FAILED =====");

        if (result.getThrowable() != null) {

            test.get().fail(result.getThrowable());

            result.getThrowable().printStackTrace();
        }

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        result.getMethod().getMethodName());

        try {

            test.get().addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println(
                result.getMethod().getMethodName()
                        + " FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        System.out.println(
                result.getMethod().getMethodName()
                        + " SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("===== Report Generated =====");
    }
}