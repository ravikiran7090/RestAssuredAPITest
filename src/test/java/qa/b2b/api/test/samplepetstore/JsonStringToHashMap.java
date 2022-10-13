package qa.b2b.api.test.samplepetstore;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonStringToHashMap {
    public static void main(String[] args) throws IOException {
        String json = "{\r\n\"name\" : \"abc\" ,\r\n\"email id \" : [\"abc@gmail.com\",\"def@gmail.com\",\"ghi@gmail.com\"]\r\n}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
// convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map);
    }

}
