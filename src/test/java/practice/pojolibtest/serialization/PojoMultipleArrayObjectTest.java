package practice.pojolibtest.serialization;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import practice.pojolib.PojoArrayObjectLib;
import practice.pojolib.PojoMultipleArrayObjectLib;

import java.io.File;
import java.io.IOException;

public class PojoMultipleArrayObjectTest {

    @Test
    public void serialization() throws IOException {
        long[] contactnumber1 = {1234567890l, 2345678901l};
        long[] contactnumber2 = {2345679876l,9876543456709l};

        PojoArrayObjectLib pao1 = new PojoArrayObjectLib("Suraj", "E345", "acded@gmail.com", contactnumber1);
        PojoArrayObjectLib pao2 = new PojoArrayObjectLib("Varun", "E346", "acded@gmail.com", contactnumber2);
        Object[] pao = {pao1, pao2};

        PojoMultipleArrayObjectLib pmaol = new PojoMultipleArrayObjectLib(pao, 456, "line23", "bangalore", "karnataka", "india", 567432);

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(pao1));
        System.out.println(mapper.writeValueAsString(pao2));
        System.out.println(mapper.writeValueAsString(pmaol));


        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./json/multiplearrayobject.json"), pmaol);

    }

}
