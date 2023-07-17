package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Scanner scanner;

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        scanner = new Scanner(System.in);
    }

    @Test
    void calculator() {
//        String value = scanner.nextLine();
        String value = "2 + 3 * 4 / 2";
        String[] values = value.split(" ");
        int before = 0;

        for(int i=0; i<values.length; i++) {
            if(i==0) {
                before = Integer.parseInt(values[i]);
            }

            if(values[i].equals("+")) {
                before = calculator.add(before, Integer.parseInt(values[i+1]));
            }
            if(values[i].equals("-")) {
                before = calculator.subtract(before, Integer.parseInt(values[i+1]));
            }
            if(values[i].equals("*")) {
                before = calculator.multiply(before, Integer.parseInt(values[i+1]));
            }
            if(values[i].equals("/")) {
                before = calculator.divide(before, Integer.parseInt(values[i+1]));
            }
        }
        assertThat(before).isEqualTo(10);
    }

}

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}