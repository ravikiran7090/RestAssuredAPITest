package qa.b2b.api.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.b2b.api.annotations.FrameworkAnnotations;
import qa.b2b.api.reports.ExtentLogger;
import qa.b2b.api.reports.ExtentReport;

public class TestListenerImpl implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }
    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.tearDownReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());

        //find the author and category and then i need to call that extent report method
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
        ExtentReport.addAuthor(authors);

        String[] category = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
        ExtentReport.addCategory(category);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+" IS PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+" IS FAIL");
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skipped(result.getMethod().getMethodName()+" IS SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }
}
