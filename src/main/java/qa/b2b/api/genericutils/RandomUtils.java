package qa.b2b.api.genericutils;

import java.security.SecureRandom;

public class RandomUtils {
    private static final SecureRandom random = new SecureRandom();

    private RandomUtils() {}

    public static int getId(){
        return FakerUtils.getNumber(1000,2000);
    }
    public static String getFirstName(){
        return FakerUtils.getFirstName().toLowerCase();
    }
    public static String getLastName(){
        return FakerUtils.getLastName().toLowerCase();
    }

    public static String generateRandomString(int length) {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(text.charAt(random.nextInt(text.length())));
        return sb.toString();
    }

    public static String generateRandomNumericString(int length) {
        String textnumber = "0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(textnumber.charAt(random.nextInt(textnumber.length())));
        return sb.toString();
    }

    public static String generateRandomMasterBillNumber() {
        return "MAMU" + generateRandomString(1) + generateRandomNumericString(2);
    }

    public static String generateRandomMasterFileNumber() {
        return generateRandomString(6) + generateRandomNumericString(3);
    }


    public static String generateRandomHBnumber() {
        return generateRandomString(3) + generateRandomNumericString(3);
    }
}
