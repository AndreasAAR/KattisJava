import java.util.Scanner;

public class MatrixGameBinary {
    Scanner scan;
    int [][] input;
    final int MATSIZE = 4;
    public static void main(String[] args){
        MatrixGameBinary mb = new MatrixGameBinary();
    }

    MatrixGameBinary(){
        scan = new Scanner(System.in);
        input = matrixInput();
        Game game = new Game(input);
    }


    public int[][] matrixInput(){
        int[][] gameArr = new int [MATSIZE][MATSIZE];

        for(int i = 0; i < MATSIZE ; i++){
            String inputStr = scan.nextLine();
            String[] numsStr = inputStr.split(" ");
            for(int j = 0; j < MATSIZE ; j++){
                gameArr[i][j] = Integer.parseInt(numsStr[j]);
            }
        }

        return gameArr;
    }


    class Game{

        private int[][] matrix = new int[MATSIZE][MATSIZE];

        public Game(int[][] matrix){
            this.matrix = matrix;
            System.out.println(matrix);
        }
        public int[] flattenArray(int[] array){

            return null;
        }


    }

}




