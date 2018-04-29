/*
 * Battle.csv can be found on kaggle at https://www.kaggle.com/mylesoneill/game-of-thrones/data
 * Input: website link
 * Output: Confirmation that file has been savd locally
*/

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Download {
    public static void main (String[] args) throws MalformedURLException, IOException {
        /* Replace link and filename with the appropriate values */

        getFile(link,filename);
        
    }

    public static void getFile(String link, String filename) throws MalformedURLException, IOException {
        URL url = new URL(link);
        File fileDir = new File("temp"), filePath;

        //Check response code
        int response = ((HttpURLConnection)url.openConnection()).getResponseCode();
        if(response == 200){
            if (!fileDir.exists()){
                fileDir.mkdir();
                System.out.println("Dir created.");
            }
            filePath = new File(fileDir, filename);
            InputStream openStream = url.openStream();
            Files.copy(openStream, filePath.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File added");
        } else {
            System.out.println("....So...yea..this did not work");
        }
    }
}