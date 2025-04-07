package Laborator6;

public class Main {
    public static void main(String[] arg){

        NewIntCalculator calculator=new NewIntCalculator(5);
        calculator.add(5).multiply(2);
        System.out.println(calculator.result());
    }
}
