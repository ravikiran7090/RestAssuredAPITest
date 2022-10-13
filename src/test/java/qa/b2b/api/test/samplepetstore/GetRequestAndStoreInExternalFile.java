package qa.b2b.api.test.samplepetstore;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;
import static java.nio.file.Paths.get;

public class GetRequestAndStoreInExternalFile {
    @Test
    public void getResource() throws IOException {
        int petid = 122;

        Response responce = given()
                .pathParam("petID", petid)
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/pet/{petID}");

        responce.prettyPrint();

        Files.write(get("./output/responce.json"), responce.asByteArray());
    }
}
