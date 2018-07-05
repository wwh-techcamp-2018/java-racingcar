package common;

import java.util.List;
import java.util.Random;

public class Utils {
    public static final String MOVE_TRACK = "-";

    public static String dashString(int position) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < position; i++) {
            stringBuffer.append(MOVE_TRACK);
        }
        return stringBuffer.toString();
    }

    public static int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static void print(List<String> list) {
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }

    public static void print(String str) {
        System.out.println(str.toString());
    }

}
