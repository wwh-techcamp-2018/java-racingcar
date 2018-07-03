package util;

import java.util.Random;

public class IntegerUtil {
    public static int getRandomNo() {
        Random r = new Random();
        return r.nextInt(10);
    }
}
