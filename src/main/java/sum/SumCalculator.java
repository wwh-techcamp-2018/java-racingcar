package sum;

public class SumCalculator {
    public static int calculate(int[] inputArray) {
        int sum = 0;
        for (int i : inputArray) {
            sum += i;
        }
        return sum;
    }
}
