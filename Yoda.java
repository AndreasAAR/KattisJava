import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoda {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int[] num1;
    public static int[]  num2;
    public static void main(String[] args){
         makeNumArrs();
    }
    public static void makeNumArrs(){
       fillNumArr(num1);
       fillNumArr(num2);
    }

    private static void fillNumArr(int[] nums){
       String[] numStrs =  takeInput();

    }

    private static String [] takeInput(){
        try{
           return reader.readLine().split("");
        }catch(IOException ie){
            System.out.println(ie);
        }finally{
            System.out.println("");
        }
        return null;
    }


}
