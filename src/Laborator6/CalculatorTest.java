package Laborator6;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private CalculatorTest test;

    @BeforeEach
    public void setup() {
        test = new CalculatorTest();
    }

    @Test
    public void testAdd() {
        NewIntCalculator calculator = new NewIntCalculator(5);
        calculator.add(3);
        Assertions.assertEquals(8, calculator.result());
    }

    @Test
    public void testSubstract() {
        NewIntCalculator calculator = new NewIntCalculator(8);
        calculator.substract(2);
        Assertions.assertEquals(6, calculator.result());
    }

    @Test
    public void testMultiply() {
        NewIntCalculator calculator = new NewIntCalculator(2);
        calculator.multiply(2);
        Assertions.assertEquals(4, calculator.result());
    }

    @Test
    public void testAddNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-5);
        calculator.add(-3);
        Assertions.assertEquals(-8, calculator.result());
    }

    @Test
    public void testSubstractNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(8);
        calculator.substract(-2);
        Assertions.assertEquals(10, calculator.result());
    }

    @Test
    public void testMultiplyNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-2);
        calculator.multiply(-2);
        Assertions.assertEquals(4, calculator.result());
    }

    @Test
    public void testMultiplyby0() {
        NewIntCalculator calculator = new NewIntCalculator(2);
        calculator.multiply(0);
        Assertions.assertEquals(0, calculator.result());
    }

    @Test
    public void testDividePositives() {
        NewIntCalculator calculator = new NewIntCalculator(8);
        calculator.divide(2);
        Assertions.assertEquals(4, calculator.result());
    }

    @Test
    public void testDivideNegatives() {
        NewIntCalculator calculator = new NewIntCalculator(-8);
        calculator.divide(2);
        Assertions.assertEquals(-4, calculator.result());
    }

    @Test
    public void testdivide0() {
        DoubleCalculator calculator = new DoubleCalculator(10);
        calculator.divide(0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, (double) calculator.result(), 0);

    }

    @Test
    public void testDivideByZeroInt() {
        NewIntCalculator calculator = new NewIntCalculator(10);
        assertThrows(ArithmeticException.class, () -> //expresie lambda (o funcție anonimă) care conține codul ce ar trebui să arunce excepția.
        {
            calculator.divide(0);
        });
    }
    @Test
    public void testDivideByZeroTryCatch() {
        NewIntCalculator calculator = new NewIntCalculator(10);
        try {
            calculator.divide(0);
            // Dacă ajungem aici, testul trebuie să eșueze deoarece nu s-a aruncat excepția
            fail("Trebuia să arunce ArithmeticException la împărțirea la zero");
        } catch (ArithmeticException e) {
            // Assert - testul trece dacă ajunge aici
            assertTrue(true); // Opțional, doar pentru a arăta că testul trece
        }
    }
    }
