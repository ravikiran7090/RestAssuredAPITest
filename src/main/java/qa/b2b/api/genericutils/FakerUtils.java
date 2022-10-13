package qa.b2b.api.genericutils;

import com.github.javafaker.Faker;

public class FakerUtils {
    private FakerUtils(){}

    private static final Faker faker = new Faker();

    static int getNumber(int startvalue,int endvalue){
        return faker.number().numberBetween(startvalue, endvalue);
    }
    static String getFirstName(){
        return faker.name().firstName();
    }
    static String getLastName(){
        return faker.name().lastName();
    }


}
