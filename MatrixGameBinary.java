import java.util.Scanner;

/*
Andreas Ährlund-Richter 2020
Problem that simulates the game 2048
https://open.kattis.com/problems/2048
 */

//TODO
//Make this into an actual terminal-based 2048, and a visual one!
//Also, make the visual one web-based with high-score in mongodb or mysql if pos!
// Maybe use a Java Javascript-focused EE instead of Swing/Java-Fx

enum Direction{
    // 0, 1, 2, or 3 that denotes a left, up, right,
    // or down move executed by the player, respectively.
    UP, DOWN, RIGHT, LEFT;
}

public class MatrixGameBinary {

    Scanner scan;
    int[][] input;
    Direction direction;
    //Important NOTE:
    //The matsize used here assumes a symmetric square matrix!
    final int MATSIZE = 4;

    public static void main(String[] args) {

        MatrixGameBinary mb = new MatrixGameBinary();
    }

    public void setDirection(int input) {
        switch (input) {
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

    public MatrixGameBinary() {

        scan = new Scanner(System.in);
        input = gameInput();
        GameBoard game = new GameBoard(input,MATSIZE,direction);
        game.performShift(direction);
        game.printMatrix();
    }

    public int[][] gameInput() {
        int[][] gameArr = new int[MATSIZE][MATSIZE];

        for (int i = 0; i < MATSIZE; i++) {
            String inputStr = scan.nextLine();
            String[] inputArr = inputStr.split(" ");

            for (int j = 0; j < MATSIZE; j++) {
                gameArr[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        setDirection(Integer.parseInt((scan.nextLine().trim())));
        return gameArr;
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

    class GameBoard {

        Direction direction;


       private  int MATSIZE;

        private int[][] matrix = new int[MATSIZE][MATSIZE];

        public int[][] getMatrix() {
            return matrix;
        }

        public void performShift(Direction direction){
            for(int i = 0; i < MATSIZE; i++){
                //Basic flattener goes to the right!
                if(direction == Direction.RIGHT){
                  int[] flattenedRow = flattenArray(matrix[i]);
                  matrix[i]= flattenedRow;
                }
                //Reversal, flattening and reversal back for left
                if(direction == Direction.LEFT){
                    int[] reversed = reverseArray(matrix[i]);
                    int[] flattenedRow = flattenArray(reversed);
                    matrix[i]= reverseArray(flattenedRow);
                }
                if(direction == Direction.DOWN){
                    int[] currCol = getCol(matrix,i);
                    setCol(matrix,i,flattenArray(currCol));
                }
                if(direction == Direction.UP){
                    int[] currCol = flattenArray(reverseArray(getCol(matrix,i)));
                    setCol(matrix,i,reverseArray(currCol));
                }
            }
        }



        public void printMatrix(){
            for(int i = 0; i < matrix.length; i++){
               printArr(matrix[i]);
            }
        }



        public GameBoard(int[][] matrix, int MATSIZE,Direction direction){
            this.matrix = matrix;
            this.MATSIZE = MATSIZE;
            this.direction = direction;
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
            for(int i = 0; i < resultArr.length;i++){
                System.out.print(resultArr[i]+ " " );
            }
            System.out.println();
        }

        public int[] flattenArray(int[] inputArray){
            //We decouple the array with clone.
            int[] array = inputArray.clone();

            //Looks backward for each position, stops at first
            // "Meld" with same val, or "front shuffle".
            // Only one(rightmost) pair gets to combine if u have 2,2,2,2

            for(int i = array.length-1; i>-1; i--){
                boolean breakInner = false;
                for(int j = i-1; j > -1 && !breakInner;j--){
                    //When j matches
                    if(array[j] == array[i] && array[i] != 0){
                        array[i] *=2;
                        array[j] = 0;
                        breakInner = true;
                    }//When i is zero, and encounter anything non zero
                    else if (array[i] == 0 && array[j] != 0 && !breakInner){
                        array[i] = array[j];
                        array[j] = 0;
                    }else if(array[i] != 0 && array[j] != 0 && array[i] != array[j]&& !breakInner){
                        breakInner = true;
                    }
                }
            }

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

    //Reverses lists!
    public int[] reverseArray(int[] arr){
        int[] flipDlist = new int[MATSIZE];
        int flipPos = 0;
        for(int i = arr.length-1 ; i > -1; i--){
            flipDlist[flipPos] = arr[i];
            flipPos++;
        }
        return flipDlist;
    }

}




