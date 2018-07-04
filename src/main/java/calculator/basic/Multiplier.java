package calculator.basic;

public class Multiplier extends Operator {
    @Override
    public int operate(int previousOperand, int postOperand) {
        return previousOperand * postOperand;
    }
}
