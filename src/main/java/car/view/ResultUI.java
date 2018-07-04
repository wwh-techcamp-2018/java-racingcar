package car.view;

import car.domain.CarDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultUI {
    static final String LINE_DELIMITER = "\n";
    static final String NAME_DELIMITER = " : ";
    static final String MOVE_EXPRESSION = "-";
    static final String WINNER_DELIMITER = ", ";
    static final String WINNER_MENT = "가 최종 우승했습니다.";
    public static void printByPositions(List<Integer> positions) {
        StringBuffer sb = new StringBuffer();
        for (int position : positions) {
            sb.append(convertToPrint(position));
            sb.append(LINE_DELIMITER);
        }
        System.out.print(sb.toString());
    }

    public static void printByDTO(List<CarDTO> carDTOs) {
        StringBuffer sb = new StringBuffer();

        for (CarDTO dto : carDTOs) {
            sb.append(convertToPrint(dto));
            sb.append(LINE_DELIMITER);
        }
        sb.append(getWinner(carDTOs));
        sb.append(LINE_DELIMITER);
        System.out.print(sb.toString());
    }
    static String convertToPrint(CarDTO carDTO) {
        StringBuffer output = new StringBuffer();
        output.append(carDTO.getName());
        output.append(NAME_DELIMITER);
        for (int i = 0; i < carDTO.getPosition(); i++) {
            output.append(MOVE_EXPRESSION);
        }
        return output.toString();
    }
    static String convertToPrint(int position) {
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < position; i++) {
            output.append(MOVE_EXPRESSION);
        }
        return output.toString();
    }
    static String getWinner(List<CarDTO> carDTOs){
        StringBuffer winnerOutput = new StringBuffer();
        List<CarDTO> winners = getWinners(carDTOs);
        winnerOutput.append(winners.get(0).getName());
        for(int i = 1 ; i < winners.size() ; i++){
            winnerOutput.append(WINNER_DELIMITER);
            winnerOutput.append(winners.get(i).getName());
        }
        winnerOutput.append(WINNER_MENT);
        winnerOutput.append(LINE_DELIMITER);
        return winnerOutput.toString();
    }

    static List<CarDTO> getWinners(List<CarDTO> carDTOs){
        int max = getMaxPosition(carDTOs);
        return carDTOs.stream().filter(car -> car.isMaxPosition(max)).collect(Collectors.toList());
    }


    static int getMaxPosition(List<CarDTO> carDTOs){
        return carDTOs.stream().mapToInt(CarDTO::getPosition).max().orElse(0);
    }

}
