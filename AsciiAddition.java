
import java.util.*;

public class AsciiAddition {
    static HashMap<String,String>  symbols = new HashMap<>();
    ArrayList<String> receivedSymbols = new ArrayList<>();
    final int LET_DEPTH = 7;
    final int LET_WIDTH = 5;
    public static void main(String[] args){
       addAsciiSymbols();
       AsciiAddition asciiAddition = new AsciiAddition();
       asciiAddition.takeInput();
      int result = asciiAddition.calculate();
     ArrayList<String> numberList =  asciiAddition.asciiNumberToArray(result);
       asciiAddition.printArray(numberList);
    }

    public int calculate(){ //Only operator is + so it becomes very easy
        // We just add together all continous numbers
        int totalVal = 0;
        String currentNumber = "";
        for(int i = 0; i < receivedSymbols.size(); i++){
            String currentSymbol = symbols.get(receivedSymbols.get(i));
            if(!currentSymbol.equals("+")){
                    currentNumber += currentSymbol;
            }
            if(currentSymbol.equals("+") || i == receivedSymbols.size()-1){
                totalVal += Integer.parseInt(currentNumber);
                currentNumber =""; //Reset the currentNumber
            }
        }
        return totalVal;
    }

    public void printArray(ArrayList<String> printArray){
        String printString ="";
        for(int i = 0 ; i < LET_DEPTH; i++){
            String printLine = "";
            for(int j = 0; j < printArray.size(); j++){
                String[] symbolLines = printArray.get(j).split("\n");
                printLine += symbolLines[i].replace("\n","");
                if(j != printArray.size()-1){
                    printLine +=".";
                }
           }
           printString += printLine+"\n";
        }
        System.out.print(printString);
    }

    public ArrayList<String> asciiNumberToArray(int number){
        ArrayList<String> printArray = new ArrayList<>();
        char[] chars = (number+"").toCharArray();
        for(char c : chars){
            String s = (c+"");
            Set<String> asciis = symbols.keySet();
            for(String key : asciis){
                if(symbols.get(key).equals(s)){
                    printArray.add(key);
                }
            }
        }
        return printArray;
    }

    public void takeInput(){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        int numLetters;

        for(int i = 0; i < LET_DEPTH; i++){
            lines.add(scan.nextLine());
            lines.get(i);
        }

        numLetters = (lines.get(0).length()+1)/ (LET_WIDTH+1); //every letter except last has +1 space

        int letterSpace = 0;  //Is needed to skip the spaces between digits
        //Going widht-wise through all lines for each lines
        for(int i = 0; i < numLetters; i++){
            //Looping for each letter
            String currentSymbol = null; //nulls the pointer for next symbol
            if(i == 0){
                letterSpace = 0;
            }else{
                letterSpace = 1;
            }
            for(int j = 0; j < LET_DEPTH; j++){
                String currentLine = lines.get(j);
                String toAdd = currentLine.substring(i*(LET_WIDTH+letterSpace),i*(LET_WIDTH+letterSpace)+LET_WIDTH);
                if(currentSymbol == null){
                    currentSymbol = toAdd;
                }else{
                    currentSymbol += toAdd;
                }
                if(j != LET_DEPTH-1){
                    currentSymbol += "\n";
                }
            }
            receivedSymbols.add(currentSymbol); //adds the newly made symbol
        }
    }



    //Adds symbols at start of program
    public static void addAsciiSymbols(){

        symbols.put(
                "xxxxx\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "xxxxx" , "0"


        );
        symbols.put("....x\n" +
                "....x\n" +
                "....x\n" +
                "....x\n" +
                "....x\n" +
                "....x\n" +
                "....x" , "1"
        );
        symbols.put(
                "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "xxxxx\n" +
                        "x....\n" +
                        "x....\n" +
                        "xxxxx" ,"2"


        );
        symbols.put(
                "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "xxxxx" , "3"


        );
        symbols.put(
                "x...x\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "....x" , "4"


        );
        symbols.put(
                "xxxxx\n" +
                        "x....\n" +
                        "x....\n" +
                        "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "xxxxx" , "5"


        );
        symbols.put(
                "xxxxx\n" +
                        "x....\n" +
                        "x....\n" +
                        "xxxxx\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "xxxxx" , "6"


        );
        symbols.put(
                "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "....x\n" +
                        "....x\n" +
                        "....x\n" +
                        "....x" ,"7"


        );
        symbols.put(
                "xxxxx\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "xxxxx\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "xxxxx" , "8"


        );
        symbols.put(
                "xxxxx\n" +
                        "x...x\n" +
                        "x...x\n" +
                        "xxxxx\n" +
                        "....x\n" +
                        "....x\n" +
                        "xxxxx" , "9"


        );
        symbols.put(
                     ".....\n" +
                      "..x..\n" +
                      "..x..\n" +
                      "xxxxx\n" +
                      "..x..\n" +
                      "..x..\n" +
                      ".....", "+"

        );

    }

}
