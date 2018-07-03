package racing;

import java.util.List;

public class RacingUtil {

    public static String[] parseCarNames(String inputString) {
        return inputString.split(",");
    }

    static String buildResult(Car car) {
        return String.format(RacingConst.RESULT_FORMAT, car.getName(), buildDash(car.getPosition()));
    }

    static String buildDash(int length) {
        if (length < 0)
            throw new IllegalArgumentException();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(RacingConst.DASH);
        }
        return builder.toString();
    }

    static int getMaxPosition(List<Car> carList) {
        if (carList.isEmpty())
            throw new IllegalArgumentException();

        int maxPosition = carList.get(0).getPosition();
        for (int i = 1; i < carList.size(); i++) {
            maxPosition = Math.max(maxPosition, carList.get(i).getPosition());
        }
        return maxPosition;
    }
}
