package calculator;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    private int plus (int a, int b) {
        return a + b;
    }

    private int minus (int a, int b) {
        return a - b;
    }

    private int multiply (int a, int b) {
        return a * b;
    }

    private int divide (int a, int b) {
        return a / b;
    }

    public int calculate() {
        String[] splitted = inputString.split(" ");
        int tempInt=0;

        for(int i = 0 ; i < splitted.length - 2; i+=2){
            //int tempInt = Integer.parseInt(splitted[i]) + Integer.parseInt(splitted[i+2]);
            tempInt = multyplexCalc(splitted,i);
        }
        return tempInt;
    }

    private int multyplexCalc(String[] splitted, int i){
        switch (splitted[i+1]){
            case "+":
                return plus(Integer.parseInt(splitted[i]),Integer.parseInt(splitted[i+2]));
            case "-":
                return minus(Integer.parseInt(splitted[i]),Integer.parseInt(splitted[i+2]));
            case "*":
                return multiply(Integer.parseInt(splitted[i]),Integer.parseInt(splitted[i+2]));
            case "/":
                return divide(Integer.parseInt(splitted[i]),Integer.parseInt(splitted[i+2]));

        }
    }


}
