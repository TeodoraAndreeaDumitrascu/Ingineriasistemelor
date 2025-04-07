package Laborator6;

public class IntCalculator {
  public int state;

public IntCalculator(int state){
    this.state=state;
}

public IntCalculator add(int a){
    this.state += a;
    return this;
}

public IntCalculator substract(int a){
    this.state -= a;
    return this;
}

public IntCalculator multiply(int a){
    this.state *= a;
    return this;
}

public int result() {
    return state;
}

public IntCalculator clear() {
    this.state = 0;
    return this;
}
public static void main(String[] arg){
    IntCalculator calculator=new IntCalculator(5);
    calculator.add(8).multiply(2);
    System.out.println(calculator.result());
}
}
