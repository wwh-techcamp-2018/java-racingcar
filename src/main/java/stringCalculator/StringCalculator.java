package stringCalculator;

import calculator.Calculator;
import sun.util.resources.ca.CalendarData_ca;

import java.util.Scanner;

public class StringCalculator {
    pulbic static Calculator cal;

    public StringCalculator() {
        cal = new Calculator();
    }

    public void getString(){
        Calculator cal = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(",");
    }

    private enum Calculations {
        //ADDITION("+", cal.add());
    }
}
