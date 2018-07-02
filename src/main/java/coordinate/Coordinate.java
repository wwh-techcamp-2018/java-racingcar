package coordinate;

public class Coordinate {

    int[] parse(String text) {
        String escape = text.substring(1, text.length()-1);
        String[] values = escape.split(",");
        int[] ary = new int[values.length];
        for(int i = 0; i < values.length; i++) {
           int number = Integer.parseInt(values[i]);
           if(number > 24) {
               throw new IllegalArgumentException();
           }
           ary[i] = number;
        }

        return arys;
    }


}
