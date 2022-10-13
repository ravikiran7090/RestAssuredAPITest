package qa.b2b.api.listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.b2b.api.annotations.FrameworkAnnotations;
import qa.b2b.api.reports.ExtentManager;
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

        ExtentManager.getTest().log(Status.INFO, result.getMethod().getMethodName() + " is executes");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, result.getMethod().getMethodName() + " is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL, result.getThrowable());
        ExtentManager.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " is fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }
}
