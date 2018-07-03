package namedracing;

import java.util.List;

public class RaceResult {

    private List<Car> racedCar;
    private int maxDistance = 0;

    public int getMaxDistance() {
        return maxDistance;
    }

    public RaceResult(List<Car> racedCar) {
        this.racedCar = racedCar;
        checkMaxDistance();
    }

    public void checkMaxDistance () {
        for(int i = 0; i < racedCar.size(); i++){
            maxDistance = Math.max(racedCar.get(i).getPosition(), maxDistance);
        }
    }

    public String generateOutString(int index) {
        StringBuilder result = new StringBuilder();
        result.append(racedCar.get(index).getName() + " : ");
        for(int i = 0; i < racedCar.get(index).getPosition(); i++) {
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
        if(maxDistance == racedCar.get(index).getPosition()) {
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
