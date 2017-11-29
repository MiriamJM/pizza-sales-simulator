import java.io.File;
import java.util.*;
/**
 * Write a description of class FileSearching here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileSearching
{
    public static void main(String[] args) 
    {
        System.out.println( searchFiles(new File("c:\\"), "hw3.zip") );
    }

    public static String searchFiles(File path, String target) 
    {
        File fileObject = new File(target);
        if(fileObject.isDirectory())
        {
            File[] file = fileObject.listFiles();
            for(int i = 0; i < file.length; i++)
            {
                searchFiles(path, target);
                if(file != null) return target;
            }
        } 
        else
        {
            if(fileObject.getName().equals(target)) return target;
        }
        return "Not found";
    }
    
    public static String searchFile(File path, String target)
    {
        if(!path.isDirectory()) return path + " is not a directory";
        else 
        {
            for(File file: path.listFiles())
            {
                searchFiles(file, target);
            }
        }
        File fileObject = new File(target);
        if(target.equals(fileObject.getName()))
        {
            return fileObject.getName();
        }
        return "Not Found";
    }
    
    
    /*Pseudocode Refinement Step1 - the problem statement
    “Given a target file to find and a starting directory, determine if and where the target file exists.”

    Pseudocode Refinement Step2
    1. An empty string array that will be used to store the target file
    methods used is searchFile(), it takes a string targetFile and String array of directories as parameters
    2. A directory with files inside
    3. Loop through the directory
    while(more directories to look at) {
    look at one file or directory and check for a match and return it if found
    if the current item is a directory, we must repeat these steps for this directory as well
    }

    while(more directories to examine) {
    Get a directory
    If a file, check for match
    If a directory,
    for(each file and directory in the directory) {
    if a file, check for a match and return if found
    if a directory, save this in a structure
    }
    }
    4. targetFile is found or not found
     */

}
