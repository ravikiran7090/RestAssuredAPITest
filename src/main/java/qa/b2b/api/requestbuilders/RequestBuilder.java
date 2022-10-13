package qa.b2b.api.requestbuilders;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import qa.b2b.api.genericutils.PropertyUtils;

import static io.restassured.RestAssured.given;

public class RequestBuilder{

    private RequestBuilder(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return given()
               // .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .baseUri(PropertyUtils.getValue("baseuri"))
                //.baseUri(IConstants.PROPERTY_FILE_PATH)
                .log()
                .all();
    }
    public static RequestSpecification buildRequestForPostCalls(){
        return buildRequestForGetCalls()
                .contentType(ContentType.JSON);
    }
}
