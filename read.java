/*
 * Battle.csv can be found on kaggle at https://www.kaggle.com/mylesoneill/game-of-thrones/data
 * Input: file path
 * Output: Print info from the file
*/
import java.io.*;
import java.util.*;

public class read {
    public static void main (String[] args) throws FileNotFoundException {
        String path = "battles.csv";
        File file = new File(path);

        Scanner input = new Scanner(file);
        input.useDelimiter(",");
        input.nextLine();
        while(input.hasNext()){
            System.out.print(input.next() + "*");
        }
    }
}