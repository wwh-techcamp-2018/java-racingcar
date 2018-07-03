package calculator;

public class Multiplier extends Operator {
   /* public Multiplier( int operand){
        super(operand);
    }
    */
    @Override
    public int operate(int previousOperand, int postOperand){
        return previousOperand * postOperand;
    }
}
