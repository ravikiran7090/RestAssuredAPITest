package practice.pojolibtest.deserialization;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import practice.pojolib.PojoLib;

import java.io.File;
import java.io.IOException;

public class Deserialization {
    @Test
    public void deserialization() throws IOException {

        PojoLib obj = new ObjectMapper().readValue(new File("./json/pojolibjson.json"), PojoLib.class);
        System.out.println(obj.getName());
        System.out.println(obj.getEmpId());
        System.out.println(obj.getEmailId());
        System.out.println(obj.getContactNumber());
    }
}
