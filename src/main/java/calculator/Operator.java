package calculator;

public abstract class Operator {
    public abstract int operate(int previousOperand, int postOperand) throws IllegalArgumentException;

}