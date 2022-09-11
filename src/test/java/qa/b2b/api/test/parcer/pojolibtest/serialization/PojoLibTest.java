package qa.b2b.api.test.parcer.pojo.libtest.serialization;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import qa.b2b.api.parcer.pojolib.PojoLib;

import java.io.File;
import java.io.IOException;

public class PojoLibTest {
    @Test
    public void serialization() throws JsonGenerationException, JsonMappingException, IOException {

        //we are creating an object into library
        PojoLib pobj=new PojoLib("Suraj", "E987", "sjn6724@gmail.com", 7019020148l);


        //converting java object into json
        //creating object of ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //converting printing the json object into the console
        System.out.println(mapper.writeValueAsString(pobj));

        //converting and generating a json file and json data
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./json/pojolibjson.json"), pobj);
    }
}
