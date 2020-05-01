import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SumOfTheOthers {

    static int totalNegative = 0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static final int MAXLINES = 200;

    public static void main(String[] args) throws IOException {
        String line = null;
        for(int i = 0; i < MAXLINES  ; i++){
            line = reader.readLine();


            if(line != null && !line.isEmpty()){
             handleCase(line);
            }else{
                return;
            }
        }


    }
    public static void handleCase(String line){
        String[] ints = line.split(" ");
        //combines all numbers and divides the sum, as the end result will be n+n.
        //Example 3 -1 + 1 + 3 = 6 /2 = 3, which was the sum.
        int sum = 0;
        for(int i = 0; i < ints.length; i++ ){
             sum += Integer.parseInt(ints[i]);
        }
        System.out.println(sum/2);
    }
}
