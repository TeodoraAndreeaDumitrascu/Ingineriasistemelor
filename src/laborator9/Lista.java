package laborator9;

import java.util.*;
import java.util.stream.Collectors;

public class Lista {
    public static void main(String[]args){
        Random random = new Random();

        List<Integer> randomList =random.ints(10,5,25).boxed().toList();
        //randomList.forEach((a)->{System.out.println(a);});
        System.out.println(randomList);
        int sum= randomList.stream().mapToInt(n->n).sum();
        System.out.println("Suma este:"+sum);
        int max= randomList.stream().mapToInt(n->n).max().getAsInt();
        System.out.println("Max este:"+max);
        int min= randomList.stream().mapToInt(n->n).min().getAsInt();
        System.out.println("Min este:"+min);

        // c) Parcurgeti lista si creati o alta lista prin pastrarea doar a elementelor in intervalul [10..20]
        List<Integer> filtered = randomList.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("Elemente in [10..20]: " + filtered);

        // d) Transformati lista de intregi in lista de Double
        List<Double> doubleList = randomList.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("Lista Double: " + doubleList);

        // e) Afisati daca in lista se gaseste valoarea 12
        boolean contains12 = randomList.stream().anyMatch(n -> n == 12);
        System.out.println("Contine 12: " + contains12);

        // 9.3.2 Lista de numere 9, 10, 3, 4, 7, 3, 4
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Patratele distincte: " + squares);

        // 9.3.3 String cu cuvinte
        String text = "Acesta este un program scris cu java 8 si expresii lambda";
        List<String> words = Arrays.asList(text.split(" "));

        // a) Numarati cuvintele cu lungimea >= 5
        List<String> longWords = words.stream()
                .filter(word -> word.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Cuvinte cu lungimea >= 5: " + longWords);

        // b) Ordonati lista noua
        List<String> sortedWords = longWords.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("Lista ordonata: " + sortedWords);

        // c) Afisati un element care incepe cu 'p'
        Optional<String> wordWithP = words.stream()
                .filter(word -> word.startsWith("p"))
                .findFirst();
        if(wordWithP.isPresent()) {
            System.out.println("Cuvant cu 'p': " + wordWithP.get());
        } else {
            System.out.println("Nu s-a gasit cuvant cu 'p'");
        }
    }
}