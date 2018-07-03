package car;

public class ResultUI {

    public void printGame(int[] positions) {
        StringBuffer sb = new StringBuffer();
        for (int position : positions) {
            sb.append(convertToPrint(position));
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }


    String convertToPrint(int position) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < position; i++) {
            output.append("-");
        }
        return output.toString();
    }

}
