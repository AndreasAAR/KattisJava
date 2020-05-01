import java.util.*;
import java.util.stream.IntStream;

public class TheGrandAdventure {
    static private Stack<String> backpack = new Stack<>();
    static HashMap<String,String> itemEnemy;
    static final String GROUND = ".";
    static Scanner scanner = new Scanner(System.in);


    public static void loadList(){
       itemEnemy = new HashMap(){
            {
                put("|","t");
                put("$","b");
                put("*","j");

            }
        };
    }

    public static void main(String[] args){
         loadList();
        int numAdventures = Integer.parseInt(scanner.nextLine());
        testAdventures(numAdventures);
    }

    static public void testAdventures(int numAdvntrs){
        for(int i = 0; i < numAdvntrs; i++){
            String answer = (adventurePossible(scanner.nextLine())? "YES":"NO" );
            System.out.println(answer);
        }
    }
   static  public boolean adventurePossible(String adventure){
       backpack.clear();
       ArrayList<String> tiles = new ArrayList<>();
       tiles.addAll( Arrays.asList(adventure.split("")));
        for(int i = 0; i < tiles.size(); i++){
            String currentTile = tiles.get(i);
            String currentItem = itemEnemy.get(currentTile);

            if(currentTile.equals(GROUND)){
                continue;
            }
            //if we find an enemy
            if(currentItem != null){
               backpack.push(currentTile);
            }else{ //Its an enemy!
                if(backpack.isEmpty()){ //Empty backpack we lose
                    return false;
                }else{
                   if(!itemEnemy.get(backpack.pop()).equals(currentTile)){
                       return false;
                   }
                }
            }
        }
        if(backpack.size() > 0){
            return false;
        }
        return true;
    }
}

