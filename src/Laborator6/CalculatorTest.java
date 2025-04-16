package Laborator6;
import org.junit.jupiter.api.*;
public class CalculatorTest {
    private CalculatorTest test;
    @BeforeEach
    public  void setup(){
        test=new CalculatorTest();
    }
  @Test
  public void testAdd(){
      NewIntCalculator calculator= new NewIntCalculator(5);
      calculator.add(3);
      Assertions.assertEquals(8, calculator.result());
  }

  @Test
    public void testSubstract(){
        NewIntCalculator calculator=new NewIntCalculator(8);
        calculator.substract(2);
        Assertions.assertEquals(6,calculator.result());
  }
  @Test
    public void testMultiply(){
        NewIntCalculator calculator=new NewIntCalculator(2);
        calculator.multiply(2);
        Assertions.assertEquals(4,calculator.result());
  }
    @Test
    public void testAddNegatives(){
        NewIntCalculator calculator= new NewIntCalculator(-5);
        calculator.add(-3);
        Assertions.assertEquals(-8, calculator.result());
    }
    @Test
    public void testSubstractNegatives(){
        NewIntCalculator calculator=new NewIntCalculator(8);
        calculator.substract(-2);
        Assertions.assertEquals(10,calculator.result());
    }
    @Test
    public void testMultiplyNegatives(){
        NewIntCalculator calculator=new NewIntCalculator(-2);
        calculator.multiply(-2);
        Assertions.assertEquals(4,calculator.result());
    }
    @Test
    public void testMultiplyby0(){
        NewIntCalculator calculator=new NewIntCalculator(2);
        calculator.multiply(0);
        Assertions.assertEquals(0,calculator.result());
    }
    @Test
    public void testDividePositives(){
        NewIntCalculator calculator=new NewIntCalculator(8);
        calculator.divide(2);
        Assertions.assertEquals(4,calculator.result());
    }
    @Test
    public void testDivideNegatives(){
        NewIntCalculator calculator=new NewIntCalculator(-8);
        calculator.divide(2);
        Assertions.assertEquals(-4, calculator.result());
    }
}
