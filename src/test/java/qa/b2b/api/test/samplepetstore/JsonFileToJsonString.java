package qa.b2b.api.test.samplepetstore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileToJsonString {
    public static void main(String[] args) throws IOException {
        String filepath = "./src/test/resources/requestjsonfiles/postrequestfile.json";
        System.out.println(new String(Files.readAllBytes(Paths.get(filepath))));
    }

}
