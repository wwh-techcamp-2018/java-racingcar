package game.view;

import java.util.List;

public class ResultView {
    public static final String COMMA = ",";

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void print(List<String> list) {
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }

    public static void print(String str) {
        System.out.println(str + "가 최종 우승했습니다.");
    }


}
