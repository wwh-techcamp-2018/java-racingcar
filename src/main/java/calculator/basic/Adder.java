package calculator.basic;

public class Adder extends Operator {
    @Override
    public int operate(int previousOperand, int postOperand) {
        return previousOperand + postOperand;
    }
}
