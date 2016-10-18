package workshop.hello;


import java.math.BigDecimal;
import java.text.NumberFormat;

public class Calculator {
    public double add(int number1, int number2) {
        return number1 + number2;
    }

    public double minus(int number1, int number2) {
        return number1 - number2;
    }

    public double mul(int number1, int number2) {
        return number1 * number2;
    }

    public double divide(int number1, int number2) {
        double result = (double) number1/(double) number2;
        return BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
