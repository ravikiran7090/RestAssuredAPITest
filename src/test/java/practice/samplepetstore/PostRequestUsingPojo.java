package practice.samplepetstore;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.pojoclasses.Category1;
import practice.pojoclasses.PetStorePojo;
import practice.pojoclasses.Tags;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostRequestUsingPojo {

    // [] --> List type
    // {} --> class file
    // plain old java object
    @Test
    public void pojoTest() {
        Tags tag1 = new Tags(234, "qwerty");
        Tags tag2 = new Tags(567, "zxcvb");
        List<Tags> listOfTags = Arrays.asList(tag1, tag2);

        Category1 category1 = new Category1(23, "mammals");
        List<String> listofphotourl = Arrays.asList("url1", "url2");
        PetStorePojo obj = new PetStorePojo(235, category1, "buffalo", listofphotourl, listOfTags, "Unavailable");

        Response response = given()
                .body(obj)
                .log().all()
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet");
        System.out.println("**************************************");

        response.prettyPrint();
        System.out.println("**************************************");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");
        System.out.println(response.jsonPath().getString("name"));
        List<Object> listoftags = response.jsonPath().getList("tags");
        System.out.println(listoftags);
        System.out.println("**************************************");

        PetStorePojo deserlizedPetStorePojo = response.as(PetStorePojo.class);
        List<String> photourls = deserlizedPetStorePojo.getPhotoUrls();
        System.out.println(photourls);
        System.out.println("**************************************");

      response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/schema.json")));
    }
}
