package practice.reporttest;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import qa.b2b.api.annotations.FrameworkAnnotations;
import qa.b2b.api.constants.IConstants;
import qa.b2b.api.genericutils.ApiUtils;
import qa.b2b.api.reports.ExtentReport;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

@Listeners(qa.b2b.api.listeners.TestListenerImpl.class)
public class PostResourceTest {
    @FrameworkAnnotations(author = "Suraj")
    @Test
    public void postResource() {
        String resource = ApiUtils.readJsonAndGetAsString("./src/test/resources/postrequestfile.json");

        RequestSpecification requestSpecification = given()
                .body(resource)
                .contentType(ContentType.JSON);

       ExtentReport.logRequest(requestSpecification);

        Response response = requestSpecification.post(IConstants.BASEURI + IConstants.ADD_NEW_PET_STORE);

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(400l), TimeUnit.SECONDS)
                .log().all();
       ExtentReport.logResponse(response.asPrettyString());


    }
}
