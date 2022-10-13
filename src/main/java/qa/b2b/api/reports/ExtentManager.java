package qa.b2b.api.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    static void setExtent(ExtentTest test) {
        extentTest.set(test);
    }
}
