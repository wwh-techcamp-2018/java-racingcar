package calculator;

public class Divider extends Operator {
    @Override
    public int operate(int previousOperand, int postOperand) throws IllegalArgumentException {
        if (postOperand == 0) throw new IllegalArgumentException();
        return previousOperand / postOperand;
    }
}
