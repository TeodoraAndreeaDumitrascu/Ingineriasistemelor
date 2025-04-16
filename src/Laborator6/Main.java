package Laborator6;

public class Main {
    public static void main(String[] arg) {

        NewIntCalculator calculator = new NewIntCalculator(10);
        calculator.add(5).substract(3).multiply(2);
        System.out.println("Rezultatul operației (10 + 5 - 3) * 2 = " + calculator.result());

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        doubleCalc.add(5.0).substract(3.3).multiply(2.2);
        System.out.println("Rezultatul operației (10 + 5 - 3.3) * 2.2 = " + doubleCalc.result());
    }
}