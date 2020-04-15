import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrainPassengers {
    static int passengers = 0;
    static int capacity;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static  int stations;
    public static void main(String[] args){
        try{
           runCase();
        }catch(IOException ie){
            System.out.println(ie);
        }
    }
    public static void runCase() throws IOException{
        String [] startSettings = reader.readLine().split(" ");
        capacity = Integer.parseInt(startSettings[0]);
        stations = Integer.parseInt(startSettings[1]);
        for(int i = 0; i < stations; i++){
            if(!isCaseCorrect(i)){

                System.out.println("impossible");
                return;
            }
        }
        System.out.println("possible");
    }

    public static boolean isCaseCorrect(int i) throws IOException{
        boolean firstOrLast;
        String[] stationCounts = reader.readLine().split(" ");
        int passOff = Integer.parseInt(stationCounts[0]);
        int passOn = Integer.parseInt(stationCounts[1]);
        int passWait = Integer.parseInt(stationCounts[2]);;
        int pasStilWait = passWait;
        int initialPassengers = passengers;
        passengers -= passOff;
        passengers += passOn;
        //Current Passengeramount ok?
        if(passengers < 0 || passengers > capacity){
            return false;
        }
        //More getting of than possible
        if(initialPassengers < passOff){
            return false;
        }

        //Passengers less than capacity but still waiting?
        if(passengers < capacity){
            if (pasStilWait > 0 ) {
                return false;
            }
        }
        //First station should be empty
        if(i == 0){
            if(initialPassengers > 0 ){
                return false;
            }
        }
        if(i == stations-1){
            if(passengers > 0 ){
                return false;
            }
            if(pasStilWait > 0 ){
                return false;
            }
        }
          return true;
    }

}
