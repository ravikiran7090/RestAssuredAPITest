package qa.b2b.api.test.reporttest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import qa.b2b.api.annotations.FrameworkAnnotations;
import qa.b2b.api.reports.ExtentReport;

import static io.restassured.RestAssured.given;

@Listeners(qa.b2b.api.listeners.TestListenerImpl.class)
public class GetResource {
    /*
     * There should be a test case matching this test name in RUNMANAGER and TESTDATA sheet
     * If there are multiple data lines in TESTDATA sheet, it will treated as iteration
     * Mark Yes in RUNMANAGER and TESTDATA to run this test case
     * @author Surajkumar N
     */
    @FrameworkAnnotations(author = "Suraj")
    @Test
    public void getResource() {
        int petid = 122;

        Response responce = given()
                .pathParam("petID", petid)
                .get("https://petstore.swagger.io/v2/pet/{petID}");

        responce.prettyPrint();

        responce.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
        ExtentReport.logResponse(responce.asPrettyString());




    }
}
