import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Babelfish {

    static HashMap<String, String> dictionary = new HashMap<>();
    static ArrayList<String> query = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> dictInput = new ArrayList<String>();

    public static void main(String[] args) {
        try{
        takeInput(dictInput);
        takeInput(query);

        }catch(IOException io){
            System.out.println(io);
        }

        getDictionary();
        translate();
    }

    static void splitInput() {

    }

    static void getDictionary() {
        for (String s : dictInput) {
            if (s == null || s.equals("")) {
                break;
            }
            String[] translation = s.split(" ");
            dictionary.put(translation[1], translation[0]);
        }
    }

    static void takeInput(ArrayList<String> input) throws IOException {
        //Enter data using BufferReader

        // Reading data using readLine
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            input.add(line);
        }
        // Printing the read line


    }

    static void translate(){
        String output;
        String dictRes;
        for(String q : query){
           output = "eh";
           dictRes = null;
           if((dictRes = dictionary.get(q)) != null)
               output = dictRes;
            System.out.println(output);
        }
    }
}
