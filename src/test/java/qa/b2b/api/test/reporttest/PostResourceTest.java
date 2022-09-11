package qa.b2b.api.test.samplepetstore.reporttest;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import qa.b2b.api.annotations.FrameworkAnnotations;
import qa.b2b.api.constants.IConstants;
import qa.b2b.api.genericutils.ApiUtils;
import qa.b2b.api.reports.ExtentLogger;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

@Listeners(qa.b2b.api.listeners.ListenerImpl.class)
public class PostResourceTest {
    @FrameworkAnnotations(author = "Suraj")
    @Test
    public void postresource() {
        String resourc = ApiUtils.readJsonAndGetAsString("./src/test/resources/postrequestfile.json");

        RequestSpecification requestSpecification = given()
                .body(resourc)
                .contentType(ContentType.JSON);

       ExtentLogger.logRequest(requestSpecification);

        Response responce = requestSpecification.post(IConstants.BASEURI + IConstants.ADD_NEW_PET_STORE);

        responce.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(Matchers.lessThan(400l), TimeUnit.SECONDS)
                .log().all();
       ExtentLogger.logResponse(responce.asPrettyString());


    }
}
