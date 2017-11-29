# Recurssion
import java.util.Arrays;
/**
 * BinarySearch class searches for a specific word using iterative and recursive methods.
 *                     the class inherits from  SearchAlgorithm class
 * 
 * @author Miriam Mnyuku 
 * @date August 5, 2017
 */
public class BinarySearch extends SearchAlgorithm
{

    /**
     * Constructor for objects of class BinarySearch
     * 
     * @param: none
     * @return: none
     * precondition: none
     * postcondition: creates a new binarySearch object when called
     */
    public BinarySearch()
    {

    }

    /**
     * searches iteratively for a specific word in an array of words and return the index of its position in the array
     * 
     * @param: string array of words and a specific word to search for
     * @return: an integer presenting the number of times the target word if found
     * precondition: an array of words
     * postcondition: an index where the specific word is located
     */
    public int search(String[] words, String wordToFind) throws ItemNotFoundException
    {
        
        Arrays.sort(words);
        int lowIndex = 0, highIndex = words.length-1;
        int midIndex;

        while(lowIndex <= highIndex)
        {
            midIndex = lowIndex + (highIndex - lowIndex) / 2;
            if(wordToFind.equals(words[midIndex]))
            {
                return midIndex;
            }
            else if(wordToFind.compareTo(words[midIndex]) > 0)
            {
                lowIndex = midIndex + 1;
            }
            else if (wordToFind.compareTo(words[midIndex]) < 0)
            {
                highIndex = midIndex - 1;            
            }
            incrementCount();
        }
        throw new ItemNotFoundException();
    }

    /**
     * searches recursively for a specific word in an array of words and return the index of its position in the array
     * 
     * @param: string array of words and a specific word to search for
     * @return: an integer 
     * precondition: an array of words
     * postcondition: the large array of words results in overflow stack because of the fixed size of the array
     *                the program will crush ungracefully.
     */
    public static int searching(String[] words, String wordToFind, int lowIndex, int highIndex ) throws ItemNotFoundException
    {
        lowIndex = 0;
        highIndex = words.length-1;
        int midIndex;

        if(lowIndex > highIndex)
        {
            throw new ItemNotFoundException(); 
        }

        midIndex = lowIndex + (highIndex - lowIndex) / 2;
        if(words[midIndex].equals(wordToFind))
        {
            return midIndex;
        }
        else if(wordToFind.compareTo(words[midIndex]) > 0)
        {
            return searching(words, wordToFind, lowIndex, midIndex -1);
        }
        else //if(wordToFind.compareTo(words[midIndex]) < 0)
        {
            searching(words, wordToFind, midIndex + 1, highIndex);            
        }
        throw new ItemNotFoundException();
    }

    /**
     * searches recursively for a specific word in an array of words and return the index of its position in the array
     * by calling the searching method
     * 
     * @param: string array of words and a specific word to search for
     * @return: an integer 
     * precondition: an array of words
     * postcondition: the large array of words results in overflow stack because of the fixed size of the array
     *                the program will crush ungracefully.
     */
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException
    {
        return searching(words, wordToFind, 0, words.length-1);
    }
}
