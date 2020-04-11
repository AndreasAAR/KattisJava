import java.util.*;

public class ArmyStrength {
    Scanner scan;
    public static void main(String[] args){
        ArmyStrength armyStrength = new ArmyStrength();
    }
    public ArmyStrength(){
        scan = new Scanner(System.in);
        int numCases = Integer.parseInt(scan.nextLine());
        ArrayList<String> program = new ArrayList<>();
        for(int i = 0; i < numCases*4; i++){
            program.add(scan.nextLine());
        }

        for(int i=0; i < numCases; i++){
            newCase(program.get(2),program.get(3));
            for(int j = 0; j < 4; j++)
            program.remove(0);
        }

    }

    public void newCase( String army1, String army2){
        ArrayList<Integer> zilla = generateArmy(army1);
        ArrayList<Integer> mecha = generateArmy(army2);
        System.out.println( war(mecha,zilla));
    }
    public ArrayList<Integer> generateArmy(String army){
        ArrayList<Integer> monsters = new ArrayList<>();
        String[] nums = army.split(" ");
        for(int i = 0; i < nums.length; i++){
            monsters.add(Integer.parseInt(nums[i]));
        }
        return monsters;
    }
    public String war(ArrayList<Integer> mecha, ArrayList<Integer> zilla){
        Collections.sort(mecha);
        Collections.sort(zilla);

        while(!mecha.isEmpty() && !zilla.isEmpty()){

            if(mecha.get(0) <= zilla.get(0) ){
                mecha.remove(0);
            }else if(mecha.get(0) > zilla.get(0)){
                zilla.remove(0);
            }
        }

      return  (mecha.isEmpty() && !zilla.isEmpty())? "Godzilla": (!mecha.isEmpty() && zilla.isEmpty())? "MechaGodzilla" : "uncertain";
    }
}


