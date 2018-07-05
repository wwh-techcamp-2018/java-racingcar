package racingcar.dto;

public class RacingGameInput {
    private String[] names;
    private int numTrial;

    public RacingGameInput(String[] names, int numTrial) {
        this.names = names;
        this.numTrial = numTrial;
    }

    public String[] getNames() {
        return names;
    }

    public int getNumTrial() {
        return numTrial;
    }
}
