package calculator.add.controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
//        String input = "//'\n1'2'3";
        System.out.println("input: "+input);
        Calculator calculator = new Calculator();

        if (calculator.checkException(input)) {
            System.out.println(0);
            return;
        }
        System.out.println(calculator.calculate(calculator.getNumbers(input)));
    }
}
