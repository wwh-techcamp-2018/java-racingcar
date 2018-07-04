package race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingResult {
    private Map<String, Integer> resultMap;
    private List<String> winners;

    public RacingResult(Map<String, Integer> resultMap, List<String> winners) {
        this.resultMap = resultMap;
        this.winners = winners;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    public List<String> getWinners() {
        return winners;
    }
}
