package StringCalculator;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StringCalculator {

    private Stack<String> operators = new Stack<String>();
    private Stack<Integer> numbers = new Stack<Integer>();

    public void run(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(stringCalculator(text));
    }


    public int stringCalculator(String text){
        operators.clear();
        numbers.clear();
        String[] simbols = text.split(" ");
        for(int i = 0; i < simbols.length; i++){
            if(isNumber(simbols[i]))
                numbers.push(Integer.valueOf(simbols[i]));
            if(!isNumber((simbols[i])))
                operators.push(simbols[i]);

            if(numbers.size() == 2){
                numbers.push(calculator());
            }

        }
        return  numbers.pop();
    }

    private int calculator(){
        try{
            String operation = operators.pop();
            switch(operation){
                case "+" :
                    return plus(numbers.pop(),numbers.pop());
                case "-" :
                    return minus(numbers.pop(),numbers.pop());
                case "*" :
                    return multiply(numbers.pop(),numbers.pop());
                case "/" :
                    return divide(numbers.pop(),numbers.pop());
                default:
                    throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
            }

        }catch(EmptyStackException e){
            throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
        }
    }


    int plus(int i, int j){
        return i + j;
    }

    int minus(int i, int j){
        return i -j;
    }
    int multiply(int i, int j){ return i*j; }
    int divide(int i, int j) {return i/j; }
    public boolean isNumber(String simbol){
        try{
            Integer.parseInt(simbol);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
