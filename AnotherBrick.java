import java.util.Scanner;
public class AnotherBrick {

   int height;
   int width;
   int number;

   public static void main(String[] args){
       AnotherBrick anotherBrick = new AnotherBrick();
   }
   public AnotherBrick(){
        Scanner scan = new Scanner(System.in);
        String [] firstInputs = scan.nextLine().split(" ");
        height = Integer.parseInt(firstInputs[0]);
        width = Integer.parseInt(firstInputs[1]);
        number = Integer.parseInt(firstInputs[2]);
        int numberLines = 0;
        int currentLine = 0;
        String [] bricks = scan.nextLine().split(" ");

        boolean failed = true;

       for(int i = 0; i < bricks.length; i++){
            currentLine += Integer.parseInt(bricks[i]);
            if(currentLine == width){
                currentLine = 0;
                numberLines++;
            }
           if(numberLines == height){
               failed = false;
               break;
           }
            if(i == bricks.length-1 && currentLine != width){
                failed = true;
                break;
            }
        }
        String answer  = (failed)?  "NO":"YES";
        System.out.println(answer);
    }


}
