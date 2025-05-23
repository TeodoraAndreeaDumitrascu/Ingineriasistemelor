package ro.ulbs.paradigme.lab2;

import ro.ulbs.paradigme.lab2.doublechained.DoubleChainedList;
import ro.ulbs.paradigme.lab2.simplechained.SimpleChainedList;
import ro.ulbs.paradigme.lab3.util.PasswordMaker;

import static ro.ulbs.paradigme.lab2.simplechained.SimpleChainedList.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");

        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);

        Triangle tri2 = new Triangle(1.1F, 2.0F, "red");
        System.out.println("Triangle2 equals to Triangle1: " + tri.equals(tri2));

        Triangle tri3 = new Triangle(1.1F, 2.0F, "brown");
        System.out.println("Triangle3 equals to Triangle1: " + tri.equals(tri3));

        // Lista simplu înlănțuită
        SimpleChainedList simpleList = new SimpleChainedList();

        // Adăugare valori
        int[] simpleValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int value : simpleValues) {
            simpleList.addValue(value);
        }

        // Ștergere elemente
        int[] removeSimpleValues = {4, 6, 8, 10};
        for (int value : removeSimpleValues) {
            simpleList.removeNodeByValue(value);
        }

        // Afișare lista
        System.out.println("Lista simplu înlănțuită:");
        simpleList.listNodes();

        // Calculare sumă
        int simpleSum = simpleList.calculateSum();
        System.out.println("Suma valorilor listei simple: " + simpleSum);

        // Lista dublu înlănțuită
        DoubleChainedList doubleList = new DoubleChainedList();

        // Adăugare valori
        int[] doubleValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int value : doubleValues) {
            doubleList.addValue(value);
        }

        // Ștergere elemente
        int[] removeDoubleValues = {1, 2, 3};
        for (int value : removeDoubleValues) {
            doubleList.removeNodeByValue(value);
        }

        // Afișare lista
        System.out.println("\nLista dublu înlănțuită:");
        doubleList.listNodes();

        // Calculare sumă
        int doubleSum = doubleList.calculateSum();
        System.out.println("Suma valorilor listei duble: " + doubleSum);

        // Demonstrație Singleton cu lazy initialization
        System.out.println("Demonstrație Singleton cu lazy initialization:");

        // Primul apel la getInstance()
        PasswordMaker instance1 = PasswordMaker.getInstance();
        System.out.println("Prima parolă: " + instance1.getPassword());

        // Al doilea apel la getInstance()
        PasswordMaker instance2 = PasswordMaker.getInstance();
        System.out.println("A doua parolă: " + instance2.getPassword());

        // Verificăm dacă sunt aceeași instanță
        System.out.println("Sunt aceeași instanță: " + (instance1 == instance2));

        // Verificăm numărul de accesări
        System.out.println("Număr de accesări getInstance(): " + PasswordMaker.getInstanceAccessCount());

        // Demonstrație Singleton cu inițializare statică
        System.out.println("\nDemonstrație Singleton cu inițializare statică:");
        PasswordMaker staticInstance = PasswordMaker.getStaticInstance();
        System.out.println("Parolă cu instanța statică: " + staticInstance.getPassword());

        // Verificăm magic string-ul
        System.out.println("Magic String: " + instance1.getMagicString());
    }
}