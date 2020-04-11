import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Babelfish {

    static HashMap<String,String> dictionary = new HashMap<>();
    static ArrayList<String> query = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args){
        getDictionary();
        manageInput();
    }
    static void getDictionary(){
        String currLine = "";
        while(!(currLine = scan.nextLine()).equals("")){
            String[] translation = currLine.split(" ");
            dictionary.put(translation[1],translation[0]);
        }
    }
    static void manageInput(){
        while(scan.hasNextLine()){
            String output = "eh";
            String current = scan.nextLine();
            String dictFound = dictionary.get(current);
            if(dictFound != null)
                output = dictFound;
            System.out.println(output);
        }
    }
}
