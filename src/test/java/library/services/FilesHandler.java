package library.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class FilesHandler {
    public static void createTextFileFromStringSet(Set<String> set, String filePath) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String courseName : set){
                writer.write(courseName);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException exception){}
    }

    public static boolean deleteCreatedFile(String filePath){
        return new File(filePath).delete();
    }

    public static boolean fileExists(String filePath){
        return new File(filePath).exists();
    }
}
