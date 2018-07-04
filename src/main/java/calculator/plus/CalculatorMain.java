package calculator.plus;

public class CalculatorMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Calculator calculator = new Calculator(inputView.getInput());
        resultView.print(calculator.calculate());
    }
}
