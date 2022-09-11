package qa.b2b.api.test.samplepetstore;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DIffWayToPostARequest {
    @Test
    public void bodyAsAString() {

        String reqBodyAsString = "{\n" +
                "  \"id\": 102,\n" +
                "  \"category\": {\n" +
                "    \"id\": 11,\n" +
                "    \"name\": \"animal\"\n" +
                "  },\n" +
                "  \"name\": \"cow\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 22,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        Response response = given()
                .body(reqBodyAsString)
                .header("Content-Type", ContentType.JSON)
                .log().body()
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet");

        System.out.println("----------------------");
        response.prettyPrint();
        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON);

    }


    @Test
    public void bodyAsExternalFile() {
        Response response = given()
                .body(new File("./src/test/resources/postrequestfile.json"))
                .log().body()
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
    }

    @Test
    public void bodyAsExternalFile1() throws IOException {
        //Converting json file to json string

        String reqbodyobj = new String(Files.readAllBytes(Paths.get("./src/test/resources/postrequestfile.json")));
        String replacedbody = reqbodyobj.replace("122", String.valueOf(new Faker().number().numberBetween(101, 999)))
                .replace("animalname", new Faker().name().name());

        Response response = given()
                .body(replacedbody)
                .log().body()
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
    }

    @Test
    public void bodyAsMapANDList() {
        // using map and list from java
        // { } --> Map interface
        // [ ] --> List Interface
        // serializers --> converts program language objects --> byteStream --> json
        //Here converting map object to json language by using jackson-databind dependency

        Map<String, Object> mapobj = new HashMap<>();
        //****************** Body construction started ***************************//
        mapobj.put("id", 122);

        Map<String, Object> categoryobj = new HashMap<>();
        categoryobj.put("id", 11);
        categoryobj.put("name", "animal");
        mapobj.put("category", categoryobj);

        mapobj.put("name", "animalname");

        List<String> photourllist = new ArrayList<>();
        photourllist.add("string1");
        photourllist.add("String2");
        mapobj.put("photoUrls", photourllist);

        List<Object> tagss = new ArrayList();

        Map<String, Object> tag1 = new HashMap<>();
        tag1.put("id", 22);
        tag1.put("name", "qwerty");
        Map<String, Object> tag2 = new HashMap<>();
        tag2.put("id", 22);
        tag2.put("name", "qwerty");

        tagss.add(tag1);
        tagss.add(tag2);

        mapobj.put("tags", tagss);
        mapobj.put("status", "available");
        //****************** body construction end ********************//
        Response response = given()
                .body(mapobj)
                .log().body()
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
    }

    @Test
    public void bodyAsJSONObject(){
        // to overcome above approach problems
        // having some collection that can solve the problems we had while using/creating map and list
        // using external json/json-simple library
        // { } --> json object
        // [ ] --> json array
        JSONObject obj = new JSONObject();
        //****************** Body construction started ***************************//
        obj.put("id", 122);

        JSONObject categoryObject = new JSONObject();
        categoryObject.put("id", 11);
        categoryObject.put("name", "animal");
        obj.put("category",categoryObject);

        obj.put("name", "animalname");


        JSONArray photourllist = new JSONArray();
        photourllist.add("string1");
        photourllist.add("String2");
        obj.put("photoUrls", photourllist);

        JSONArray tagss = new JSONArray();

        JSONObject tag1 = new JSONObject();
        tag1.put("id", 22);
        tag1.put("name", "qwerty");
        JSONObject tag2 = new JSONObject();
        tag2.put("id", 22);
        tag2.put("name", "qwerty");

        tagss.add(tag1);
        tagss.add(tag2);

        obj.put("tags", tagss);
        obj.put("status", "available");

        //********* body construction end **************//

        Response response = given()
                .body(obj)
                .log().body()
                .contentType(ContentType.JSON)
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();

    }
}
