package qa.b2b.api.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports report;
    private static ExtentTest test;
    public static String timeStamp = new SimpleDateFormat(("ddMMYYYY hh_mm_ss")).format(new Date());

    public static void initReport() {
        File file = new File("./reports/HTML" + " " + timeStamp);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(file);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Customer App Project");
        extentSparkReporter.config().setReportName("API's Test");
        report = new ExtentReports();
        report.attachReporter(extentSparkReporter);
        report.setSystemInfo("PlatForm", "Android");
        report.setSystemInfo("Build Name", "-----");
        report.setSystemInfo("Reporter Name", "Suraj N");
    }

    public static void tearDownReport() {
        report.flush();
    }

    public static void createTest(String testcasename) {
        test = report.createTest(testcasename);
        ExtentManager.setExtent(test);
    }

    public static void addAuthor(String[] authors ) {
        for (String author : authors) {
            ExtentManager.getTest().assignAuthor(author);
        }
    }

    public static void addCategory(String[] categories){
        for(String category:categories){
            ExtentManager.getTest().assignCategory(category);
        }

    }
    public static void logRequest(RequestSpecification requestSpecification) {
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        test.log(Status.INFO,"Request Body Details");
        ExtentManager.getTest().info(MarkupHelper.createCodeBlock(query.getBody(), CodeLanguage.JSON));
        for (Header header : query.getHeaders()) {
            test.log(Status.INFO,header.getName() + ":" + header.getValue());
        }
    }

    public static void logResponse(String response) {
        test.log(Status.INFO,"Response Body Details");
        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
    }
}
