import java.io.File;
import java.io.FileNotFoundException;
/**
 * FindFile class searches for a target file given a specific path 
 * and return the location of the file, if found.
 * 
 * @author Miriam Mnyuku 
 * @date August 5, 2017
 */
public class FindFile
{
    private int maxFiles;//maximum number of files to find
    private String[] files;
    private int count;
    /**
     * This constructor accepts the maximum number of files to find
     * 
     * @param: max number of files
     * @return: none
     * precondition:none
     * postcondition: create a new findfile object when called
     */
    public FindFile(int maxFiles)
    {
        this.maxFiles = maxFiles;
    }

    /**
     * find the target file from a given directory and save the target file location in some internal memory
     * 
     * @param: target file and directory name
     * @return:none
     * precondition:none
     * postcondition:iterates through a string array of files and and stores the found target file in an array
     */
    public void directorySearch(String target, String dirName) throws Exception
    {
        ArrayList matchesTarget = findFiles(target, new File(dirName), count, maxFiles);
        files = new String[matchesTarget.size()];
        for(int i = 0; i < files.length; ++i)
        {
            files[i] = matchesTarget.get(i).toString();
        }
    }

    /**
     * returns the array of the file location, up to maxFile in size
     * 
     * @param: none
     * @return: size of file array
     * precondition: unknown file array size
     * postcondition: known size of the file array
     */
    public int getCount()
    {
        return files.length;
    }

    /**
     * returns the array of file locations, up to maxFiles in size
     * 
     * @param: none
     * @return: string array of files
     * precondition: an empty array
     * postcondition: an array containing files
     */
    public String[] getFiles()
    {
        return files;
    }

    /**
     * returns the array of file locations, up to maxFiles in size
     * 
     * @param: target file, directory, matchesTargetCount, and maxTargetCount
     * @return: arraylist of files
     * precondition: a directory of files
     * postcondition: target files stored in matchesTarget array
     */
    private ArrayList findFiles(String target, File directory, int matchesTargetCount, int maxTargetCount) throws Exception
    {
        ArrayList matchesTarget = new ArrayList();

        // For each directory under dirName
        File[] children = directory.listFiles();

        for(int i = 0; i < children.length; ++i)
        {
            File child = children[i];
            if(child.isDirectory())
            {
                ArrayList childMatches = findFiles(target, child, matchesTargetCount, maxTargetCount);
                matchesTargetCount += childMatches.size();
                
                for(int j = 0; j < childMatches.size(); ++j)
                {                    
                    matchesTarget.add(childMatches.get(j));                    
                }
            }
            /*else if(!child.isDirectory())
            {
                throw new IllegalArgumentException("Invalid Directory");
            }*/
            else if(child.getName().equals(target))
            {
                // adds the path of a found target file in the arraylist and 
                matchesTarget.add(child.getAbsolutePath());
                ++matchesTargetCount;
                
                if(matchesTargetCount >= maxTargetCount) 
                throw new Exception("File has reached the max number of Files to find");
            }
            else if(!child.getName().equals(target))
            {
                //throw new FileNotFoundException("File not found");
            }
        }

        return matchesTarget;
    }
}
