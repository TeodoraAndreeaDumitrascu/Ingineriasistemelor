package ro.ulbs.paradigme.lab3.util;

import java.security.SecureRandom;

public class PasswordMaker {
    // Variantă 1: Singleton cu lazy initialization
    private static PasswordMaker instance;

    // Contor pentru a ține evidența accesărilor lui getInstance()
    private static int instanceAccessCounter = 0;

    // Constantă cu valoare între 5 și 10
    private static final int MAGIC_NUMBER = 7;

    // Magic string lung de minim 20 de caractere, generat aleator
    private final String magicString;

    // Constructor privat pentru a preveni instantierea directă
    private PasswordMaker() {
        // Generăm magic string de lungime minimă 20
        this.magicString = StringRandomizer.generateRandomString(25);
    }

    // Metodă synchronized pentru a asigura thread-safety
    public static synchronized PasswordMaker getInstance() {
        instanceAccessCounter++; // Incrementăm contorul de fiecare dată când se accesează

        if (instance == null) {
            instance = new PasswordMaker();
        }
        return instance;
    }

    // Metodă pentru a obține contorul de accesări
    public static int getInstanceAccessCount() {
        return instanceAccessCounter;
    }

    // Metodă pentru generarea parolei (rămâne neschimbată)
    public String getPassword() {
        // 1. Șir random de lungime MAGIC_NUMBER
        String randomPart1 = StringRandomizer.generateRandomString(MAGIC_NUMBER);

        // 2. 10 caractere random din magicString
        StringBuilder randomPart2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            randomPart2.append(StringRandomizer.getRandomCharFromString(magicString));
        }

        // 3. Lungimea numelui convertită la String (folosim un nume default)
        String nameLengthPart = String.valueOf("DefaultName".length());

        // 4. Număr aleator între 0 și 50
        int randomNumber = new SecureRandom().nextInt(51);

        // Concatenăm toate părțile
        return randomPart1 + randomPart2.toString() + nameLengthPart + randomNumber;
    }

    // Metodă ajutătoare pentru a permite verificarea magicString
    public String getMagicString() {
        return magicString;
    }

    // Variantă 2: Singleton cu inițializare statică
    private static final PasswordMaker STATIC_INSTANCE;

    // Bloc static pentru inițializare
    static {
        STATIC_INSTANCE = new PasswordMaker();
    }

    // Metodă statică pentru a obține instanța inițializată static
    public static PasswordMaker getStaticInstance() {
        return STATIC_INSTANCE;
    }
}