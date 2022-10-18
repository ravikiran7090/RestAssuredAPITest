package practice.pojolibtest.serialization;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.testng.annotations.Test;
import practice.pojolib.PojoArrayObjectLib;

import java.io.File;
import java.io.IOException;

public class PojoArrayObjectTest {
    @Test
    public void serialization() throws IOException {

        long[] contactNumbers = {1234567890l, 9987654321l, 6789054321l};
        PojoArrayObjectLib pobj = new PojoArrayObjectLib("Suraj","E123","abc@gmail.com",contactNumbers);

        ObjectMapper mapper = new ObjectMapper();
        String creat = mapper.writeValueAsString(pobj);
        System.out.println(creat);

        ObjectWriter value = mapper.writerWithDefaultPrettyPrinter();
        File f = new File("./json/pojoarrayjson.json");
        value.writeValue(f, pobj);
    }
}
