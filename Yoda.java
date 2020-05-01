import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Yoda {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> num1 = new ArrayList<>();
    public static ArrayList<Integer>  num2 = new ArrayList<>();
    public static void main(String[] args){
         makeNumArrs();
    }
    public static void makeNumArrs(){
       fillNumArr(num1);
       fillNumArr(num2);
       collideNums();
    }

    private static void collideNums(){
        ArrayList<Integer> orgNum1 = (ArrayList<Integer>) num1.clone();
        ArrayList<Integer> orgNum2 = (ArrayList<Integer>) num2.clone();
        if(isYoda(num1,num2)){
            System.out.println("YODA");
            System.out.println(makeNumStr(num2));
            return;
        }
        throwOut(num1, orgNum2);
        throwOut(num2, orgNum1);
    }

    private static String makeNumStr(ArrayList<Integer> num){
        String strNum = "";

        for(Integer in: num){
            strNum += in;
        }

        return strNum;
    }

    private static boolean isYoda(ArrayList<Integer> smallNum,ArrayList<Integer> bigNum){

        for(Integer s: smallNum){
            for(Integer b: bigNum){
                if(s > b)
                    return false;
            }
        }

        return true;
    }

    private static void throwOut(ArrayList<Integer> targNum,ArrayList<Integer> apNum){
        int shortLen = (targNum.size() < apNum.size())? targNum.size() : apNum.size();

        for(int i = shortLen-1; i > 0; i--){
            
        }
    }

    private static void fillNumArr(ArrayList<Integer> nums){
       String[] numStrs =  takeInput();

       for(String s : numStrs){
           nums.add(Integer.parseInt(s));
       }
       return;
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
