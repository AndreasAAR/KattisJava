import java.util.*;

public class WhatDoesTheFoxSay {

    ArrayList<String> animalNoises = new ArrayList<>();
    private int numLines;
    private Scanner scan;
    public static void main(String[] args){
        WhatDoesTheFoxSay foxAnalyser = new WhatDoesTheFoxSay();
        foxAnalyser.scan = new Scanner(System.in);
        int cases = Integer.parseInt(foxAnalyser.scan.nextLine());

           for(int i = 0; i < cases; i++ ){
              foxAnalyser.handleCase();

           }
    }

    public void handleCase(){
        printFoxNoises( getFoxNoises());

    }

    public ArrayList<String> getFoxNoises(){
        ArrayList<String> foxNoises = new ArrayList<>();
        boolean done = false;
        ArrayList<String> forestNoises = new ArrayList<>();
        forestNoises.addAll( Arrays.asList((scan.nextLine()).split(" ")));

        while(!done){
            String currentLine = scan.nextLine();
            if(! currentLine.equals("what does the fox say?")){
            String animalNoise = currentLine.split(" ")[2];
            animalNoises.add(animalNoise);
            }else{
                done = true;
            }

        }
        forestNoises.removeAll(animalNoises);
        foxNoises = forestNoises;
        return foxNoises;
    }

    public void printFoxNoises(ArrayList<String> foxnoises){
          for(String noise : foxnoises){
              System.out.print(noise+" ");
          }
    }


}
