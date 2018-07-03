package calculator;

public class Calculator {

    static int stringToCalculate(String text) {
        String[] values = text.split(" ");

        int result = toInt(values[0]);
        for (int i = 1; i < values.length; i = i + 2) {
            result = calculateNumber(result, toInt(values[i + 1]), values[i]);
        }

        return result;
    }

    static int toInt(String num) {
        return Integer.parseInt(num);
    }

    static int calculateNumber(int first, int second, String n) {
        if (n.equals("+"))
            return plus(first, second);
        if (n.equals("-"))
            return minus(first, second);
        if (n.equals("*"))
            return mul(first, second);
        if (n.equals("/"))
            return div(first, second);

        return 0;
    }

    static int plus(int i, int j) {
        return i + j;
    }

    static int minus(int i, int j) {
        return i - j;
    }

    static int mul(int i, int j) {
        return i * j;
    }

    static int div(int i, int j) {
        return i / j;
    }

}
