package workshop.hello;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorSuccessTest {

    @Test public void
    should_be_2_when_1_add_1() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.add(1, 1);
        assertEquals(2.0, actualResult, 0.0);
    }

    @Test public void
    should_be_3_when_1_add_2() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.add(1, 2);
        assertEquals(3.0, actualResult, 0.0);
    }

    @Test public void
    should_be_0_when_1_minus_1() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.minus(1, 1);
        assertEquals(0.0, actualResult, 0.0);
    }

    @Test public void
    should_be_1_when_2_minus_1() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.minus(2, 1);
        assertEquals(1.0, actualResult, 0.0);
    }

    @Test public void
    should_be__1_when_1_minus_2() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.minus(1, 2);
        assertEquals(-1.0, actualResult, 0.0);
    }

    @Test public void
    should_be_4_when_2_mul_2() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.mul(2, 2);
        assertEquals(4.0, actualResult, 0.0);
    }

    @Test public void
    should_be_6_when_2_mul_3() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.mul(2, 3);
        assertEquals(6.0, actualResult, 0.0);
    }

    @Test public void
    should_be__6_when__2_mul_3() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.mul(-2, 3);
        assertEquals(-6.0, actualResult, 0.0);
    }

    @Test public void
    should_be_2_when_6_divide_3() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.divide(6, 3);
        assertEquals(2.0, actualResult, 0.0);
    }

    @Test public void
    should_be_2_5_when_5_divide_2() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.divide(5, 2);
        assertEquals(2.5, actualResult, 0.0);
    }

    @Test public void
    should_be_2_33_when_7_divide_3() {
        Calculator calculator = new Calculator();
        double actualResult = calculator.divide(7, 3);
        assertEquals(2.33, actualResult, 0.0);
    }

}
