package laborator5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
    try {
        // Citim fișierul de intrare
        Path inPath = Paths.get("in.txt");
        List<String> linii = Files.readAllLines(inPath);

        // a) Adăugăm un rând nou suplimentar pentru fiecare linie și afișăm
        System.out.println("a) Adăugarea unui rând nou suplimentar pentru fiecare linie:");
        List<String> liniiCuNewlineSuplimentar = new ArrayList<>();
        for (String linie : linii) {
            System.out.println(linie + "\n");
            liniiCuNewlineSuplimentar.add(linie + "\n");
        }

        // b) Adăugăm un rând nou după fiecare punct și afișăm
        System.out.println("\nb) Adăugarea unui rând nou după fiecare punct:");
        List<String> liniiCuNewlineDupaPunct = new ArrayList<>();
        for (String linie : linii) {
            String linieModificata = linie.replace(". ", ".\n");
            System.out.println(linieModificata);
            liniiCuNewlineDupaPunct.add(linieModificata);
        }

        // c) Salvăm ambele modificări în out.txt
        System.out.println("\nc) Salvarea modificărilor în out.txt");
        Path outPath = Paths.get("out.txt");

        // Combinăm ambele modificări
        List<String> modificariCombinate = new ArrayList<>();
        modificariCombinate.add("a) Adăugarea unui rând nou suplimentar pentru fiecare linie:");
        modificariCombinate.addAll(liniiCuNewlineSuplimentar);
        modificariCombinate.add("\nb) Adăugarea unui rând nou după fiecare punct:");
        modificariCombinate.addAll(liniiCuNewlineDupaPunct);

        // Scriem în fișier
        try (BufferedWriter writer = Files.newBufferedWriter(outPath)) {
            for (String linie : modificariCombinate) {
                writer.write(linie);
                writer.newLine();
            }
        }

        System.out.println("Procesarea s-a finalizat cu succes!");

    } catch (IOException e) {
        e.printStackTrace();
    }

        try {
            // Creăm fișierul outrand.txt cu cuvinte aleatorii de 4 caractere
            genereazaFisierCuvinteAleatoare("outrand.txt", 5, 10);
            System.out.println("Fișierul cu cuvinte aleatorii a fost generat cu succes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void genereazaFisierCuvinteAleatoare(String numeFisier, int numarLinii, int cuvintePeLinie) throws IOException {
        Path path = Paths.get(numeFisier);
        Random random = new Random();

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int linie = 0; linie < numarLinii; linie++) {
                // Generăm cuvinte pentru această linie
                List<String> cuvinte = new ArrayList<>();
                for (int i = 0; i < cuvintePeLinie; i++) {
                    cuvinte.add(genereazaCuvantAleator(4, random));
                }

                // Sortăm cuvintele în ordine alfabetică
                Collections.sort(cuvinte);

                // Scriem cuvintele sortate în fișier
                for (int i = 0; i < cuvinte.size(); i++) {
                    writer.write(cuvinte.get(i));
                    if (i < cuvinte.size() - 1) {
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
        }
    }

    /**
     * Generează un cuvânt aleator de lungime specificată cu caractere [a-z]
     * @param lungime Lungimea cuvântului
     * @param random Generator de numere aleatorii
     * @return Un cuvânt aleator
     */
    private static String genereazaCuvantAleator(int lungime, Random random) {
        StringBuilder cuvant = new StringBuilder();
        for (int i = 0; i < lungime; i++) {
            // Generăm o literă mică aleatorie (a-z)
            char c = (char) (random.nextInt(26) + 'a');
            cuvant.append(c);
        }
        return cuvant.toString();
    }
}
