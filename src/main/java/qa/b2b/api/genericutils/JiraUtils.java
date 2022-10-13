package qa.b2b.api.genericutils;

import io.restassured.response.Response;
import qa.b2b.api.constants.IConstants;

import static io.restassured.RestAssured.given;

public class JiraUtils {

    private JiraUtils(){}

    public static String createIssueInJira(String errormessage){
        String body = ApiUtils.readJsonAndGetAsString(IConstants.REQUEST_JSON_FILE_PATH+"/postrequestfile.json")
                .replace("KEY","DEM")
                .replace("description",errormessage);

        Response response = given()
                .auth()
                .basic("testingminibytes","Ambattur1!")
                //.header("Authorization","dGVzdGluZ21pbmlieXRlczpBbWJhdHR1cjEh")
                .header("Content-Type","application/json")
                .log()
                .all()
                .body(body)
                .post("http://localhost:8080/rest/api/2/issue/");

        response.prettyPrint();
        return response.jsonPath().getString("key");
    }
}
