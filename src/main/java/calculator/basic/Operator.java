package calculator.basic;

public abstract class Operator {
    public abstract int operate(int previousOperand, int postOperand) throws IllegalArgumentException;

}