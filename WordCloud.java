import java.util.ArrayList;
import java.util.Scanner;
/*
Wordcloud kattis
 */

public class WordCloud {

    DataSet[] DataSets;
    Scanner scan;
    public static void main(){
       WordCloud wordCloud = new WordCloud();
    }
    public WordCloud(){
        scan = new Scanner(System.in);
        input();
    }

    public void cloudPrint(DataSet dataset){
    }

    public void input(){
        String inputStr;
        String[] lineParts;
        while((inputStr = scan.nextLine()) != null){
            lineParts = inputStr.split(" ");
            if( (isNumeric( lineParts[0]))){

            }
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}



class DataSet {

    int setID;
    int height;
    int maxWidth;
    int numberWords;
   ArrayList<WordCount> wordCounts = new ArrayList<>();

    public DataSet(int maxWidth,int numberWords){
         this.maxWidth = maxWidth;
    }

    public void addWordCount(String word, int count){
        wordCounts.add(new WordCount(word,count));
    }

    class WordCount {
        int count;
        String word;
        public WordCount(String word, int count){
            this.count= count;
            this.word = word;
        }
    }

}