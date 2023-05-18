package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class Listeners implements ITestListener {
    ExtentReports reports;
    ExtentTest test;

    {
        try {
            reports = ExtentReporterNG.getReporterObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test=reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,"test failed");
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"test skipped");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
