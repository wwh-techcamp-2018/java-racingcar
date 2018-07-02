package calculator;

import java.util.*;


public class Calculator {

    int plus(int i, int j){
        return i + j;
    }
    int minus(int i, int j){
        return i - j;
    }
    int divide(int i, int j){
        return i / j;
    }
    int multi(int i, int j){
        return i * j;
    }

    int inputData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = calcData(input);
        return result;
    }

    int calcData(String input) {
        int result = 0;
        String[] values = input.split(" ");

        for(String t : values){
            switch (t){
                case "*":
                    break;
                case "/":
                    break;
                case "+":
                    break;
                case "-":
                    break;
                default:
                    break;
            }
        }




        return 0;
    }


}
