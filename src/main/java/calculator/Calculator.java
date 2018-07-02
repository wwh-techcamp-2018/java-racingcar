package calculator;

public class Calculator {

    public static String[] parse(String text) {
        return text.split(" ");
    }

    static int calculate(String[] arr) {
        String[] numbers = new String[2];

        for(int i=0; i < arr.length; i++) {
            int number = Integer.parseInt(arr[i]);

            switch (arr[i]) {
                case "+":
                    break;
                case "-":
                    break;
                case "/":
                    break;
                case "*":
                    break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
