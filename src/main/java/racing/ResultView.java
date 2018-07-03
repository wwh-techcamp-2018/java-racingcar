package racing;

public class ResultView {
    public static void showResult(int[] carPositions) {
        System.out.println("실행 결과\n");
        for (int i = 0; i < carPositions.length; i++) {
            System.out.println(getPositionString(carPositions[i]));
        }
    }

    static String getPositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append('-');
        }
        return builder.toString();
    }
}
