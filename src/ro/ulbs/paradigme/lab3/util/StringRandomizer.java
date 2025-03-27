package ro.ulbs.paradigme.lab3.util;
import java.security.SecureRandom;
public class StringRandomizer {
    private static final SecureRandom random = new SecureRandom();

    // Generează un șir aleatoriu de o anumită lungime
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    // Generează un caracter aleator dintr-un șir dat
    public static char getRandomCharFromString(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("Șirul sursă nu poate fi null sau gol");
        }
        return source.charAt(random.nextInt(source.length()));
    }
}

