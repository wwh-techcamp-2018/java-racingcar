package car;

import java.util.List;

public class ResultUI {
    static final String DELIMITER = "\n";
    static final String MOVE_EXPRESSION = "-";
    public static void printGame(List<Integer> positions) {
        StringBuffer sb = new StringBuffer();
        for (int position : positions) {
            sb.append(convertToPrint(position));
            sb.append(DELIMITER);
        }
        System.out.print(sb.toString());
    }


    static String convertToPrint(int position) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < position; i++) {
            output.append(MOVE_EXPRESSION);
        }
        return output.toString();
    }

}
