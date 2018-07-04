package calculator.string.adder;

public class StringAddCalculatorMain {
    public static void main(String[] args) {
        String inputText = StringAddCalculatorView.inputString();
        Spliter spliter = SpliterFactory.createSpliter(inputText);
        StringAddCalculatorView.printResult(StringAddCalculator.sum(spliter.extractNums(inputText)));
    }
}
