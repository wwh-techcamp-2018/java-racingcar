package namedracing;

import java.util.List;

public class RaceResult {

    private List<Car> racedCar;

    public RaceResult(List<Car> racedCar) {
        this.racedCar = racedCar;
        checkMaxDistance();
    }

    public int checkMaxDistance () {
        int curMaxDistance = 0;
        for(int i = 0; i < racedCar.size(); i++){
            curMaxDistance = racedCar.get(i).curMaxPosition(curMaxDistance);
        }
        return curMaxDistance;
    }

    public int getCarPositionOfIndex(int index) {
        return racedCar.get(index).getPosition();
    }

    public String generateOutString(int index) {
        StringBuilder result = new StringBuilder();
        result.append(racedCar.get(index).getName() + " : ");
        for(int i = 0; i < getCarPositionOfIndex(index); i++) {
            result.append("-");
        }
        return result.toString();
    }

    public void printCarPositions() {
        System.out.println("실행 결과\n");
        for(int i = 0; i < racedCar.size(); i++) {
            System.out.println(generateOutString(i));
        }
    }

    public void assertWinner(StringBuilder result, int index) {
        if(racedCar.get(index).isMaxPosition(checkMaxDistance())) {
            result.append(racedCar.get(index).getName() + ", ");
        }
    }

    public void printWinners() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < racedCar.size(); ++i) {
            assertWinner(result, i);
        }
        System.out.println(result.toString().substring(0, result.length() - 2) + "가 최종 우승했습니다.");
    }

    public void printResultGame(){
        printCarPositions();
        printWinners();
    }

}
