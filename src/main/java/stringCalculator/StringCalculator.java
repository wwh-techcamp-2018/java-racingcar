package stringCalculator;

import java.util.Scanner;

public class StringCalculator {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        System.out.print(result(text));
    }




    static  int result(String text){
        String[] rem = text.split(" ");
        int a=Integer.parseInt(rem[0]);
        int b;
        String con;
        for(int i = 0 ; i<rem.length-2; i+=2){
            con=rem[i+1];
            b=Integer.parseInt(rem[i+2]);

            a=calculate(con,a,b);
        }
        return a;
    }

    static int calculate(String con, int a, int b){
        int result=0;

        switch(con){
            case "+": result=plus(a,b); break;
            case "-": result=minus(a,b); break;
            case "/": result=div(a,b); break;
            case "*": result=multi(a,b); break;
            default: throw new IllegalArgumentException();
        }

        return result;
    }
    static int plus(int a, int b){
        return a+b;
    }
    static int minus(int a, int b){
        return a-b;
    }
    static int div(int a, int b){
        return a/b;
    }
    static int multi(int a, int b){
        return a*b;
    }
}
