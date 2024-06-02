package testlogic.apitesting;

import java.util.Random;

public class RandomEmailGenerator {
    public static String generateRandomEmail() {
        String emailCharacters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();

        Random random = new Random();
        int emailLength = 10; // panjang email yang diinginkan

        for (int i = 0; i < emailLength; i++) {
            int randomIndex = random.nextInt(emailCharacters.length());
            char randomChar = emailCharacters.charAt(randomIndex);
            email.append(randomChar);
        }

        return email.toString() + "@example.com"; // ganti dengan domain yang diinginkan
    }
}
