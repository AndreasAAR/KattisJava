import java.util.Scanner;

//TODO
//Make this into an actual terminal-based 2048, and a visual one!
//Also, make the visual one web-based with high-score in mongodb or mysql if pos!

enum Direction{
    // 0, 1, 2, or 3 that denotes a left, up, right,
    // or down move executed by the player, respectively.
    UP, DOWN, RIGHT, LEFT;
}

public class MatrixGameBinary {
    Scanner scan;
    int [][] input;
    Direction direction;
    //Important NOTE:
    //The matsize used here assumes a symmetric square matrix!
    final int MATSIZE = 4;
    public static void main(String[] args){
        MatrixGameBinary mb = new MatrixGameBinary();
    }

    public void setDirection(int input){
        switch(input){
            case 0:
                direction = Direction.LEFT;
                break;
            case 1:
                direction = Direction.UP;
                break;
            case 2:
                direction = Direction.RIGHT;
                break;
            case 3:
                direction = Direction.DOWN;
                break;
        }
    }

   /*
   Array to test on

   2 0 0 2
4 16 8 2
2 64 32 4
1024 1024 64 0
   0

    */

    public MatrixGameBinary(){
        scan = new Scanner(System.in);
        input = gameInput();
        GameBoard game = new GameBoard(input);
    }

    public int[][] gameInput(){
        int[][] gameArr = new int [MATSIZE][MATSIZE];

        for(int i = 0; i < MATSIZE ; i++){
            String inputStr = scan.nextLine();
            String[] numsStr = inputStr.split(" ");
            for(int j = 0; j < MATSIZE ; j++){
                gameArr[i][j] = Integer.parseInt(numsStr[j]);
            }
        }
        setDirection(Integer.parseInt(scan.nextLine()));
        return gameArr;
    }


    class GameBoard {

        public int[][] getMatrix() {
            return matrix;
        }

        public void performShift(Direction direction){

        }

        public void printMatrix(){

        }

        private int[][] matrix = new int[MATSIZE][MATSIZE];

        public GameBoard(int[][] matrix){
            this.matrix = matrix;
        }

        public int[] getCol(int[][] matrix, int colNum){

            int [] colArr = new int[MATSIZE];

            for(int i = 0; i < MATSIZE; i++){
                colArr[i] = matrix[i][colNum];
            }

            return colArr;
        }

        public void setCol(int[][] matrix, int colNum,int[] inputArr){
            for(int i = 0; i < MATSIZE; i++){
                matrix[i][colNum] = inputArr[i];
            }
        }

        public void printArr(int[] resultArr){
            for(int i = 0; i < resultArr.length;i++)
                System.out.println(resultArr[i]);
        }

        public int[] flattenArray(int[] inputArray){
            //We decouple the array with clone.
            int[] array = inputArray.clone();

            while(needsShuffling(array)){
                //Arrays merge liek this
                // 0 2 2 0 2 = 0 0 0 2 4 ->
                for(int i = MATSIZE-2; i > -1; i--){
                    //If we are zero do nothing
                    if(array[i] != 0){
                        //If position in front is zero
                        if(array[i+1] == 0){
                            array[i+1] =  array[i];
                            array[i] = 0;
                        }
                        //If array in front is like us
                        if(array[i] == array[i+1]){
                            array[i+1] *= 2;
                            array[i] = 0;
                        }
                    }
                }

            }
            //Check if ther
            return array;
        }
        private boolean needsShuffling(int[] array){
            //check if there needs to be more flattening
            boolean needShuffling = false;
            for(int i = 1; i < MATSIZE && !needShuffling; i++) {
                //This will be the case if there is an empty(0) space
                //with a un-empty space next to it
                if (array[i] == 0 && array[i-1] != 0) {
                    needShuffling = true;
                }
                //OR two similar ones next to eachother.
                //Important that zeroes get to exist!
                if (array[i] ==  array[i-1] && array[i] != 0) {
                    needShuffling = true;
                }
            }
            return needShuffling;
        }
    }
    //Reverses lists!
    public int[] reverseList(int[] arr){
        int[] flipDlist = new int[MATSIZE];
        int flipPos = 0;
        for(int i = arr.length-1 ; i > -1; i--){
            flipDlist[flipPos] = arr[i];
            flipPos++;
        }
        return flipDlist;
    }

}



