package common;

public class Utils {
    public static final String MOVE_TRACK = "-";

    public static String dashString(int position) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < position; i++) {
            stringBuffer.append(MOVE_TRACK);
        }
        return stringBuffer.toString();
    }

}
