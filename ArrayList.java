
/**
 *  ArrayList here.
 * 
 * @author Miriam Mnyuku 
 * @date 07/06/2017
 */
public class ArrayList
{
    private static final int InitialCapacity = 10;// intial array size
    private static final int ReallocationFactor = 2;// how much we multiply the capacity by everytime its full

    private Object[] array = new Object[InitialCapacity];
    private int size;
    private int numElements;
    private Object[] data;
    
    public ArrayList()
    {
    }
    
    /**
     * Method: isEmpty checks if the array is empty
     * 
     * @param:  none
     * @return: boolean
     * precondition: none
     * postcondition: none
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }
    // Add the object at the specified index, shifting other elements over as needed
    /**
     * Method: insert. puts an object in and array,if more objects are added
     *         the previous object is moved to the next index and it's index
     *         is replaced by a new object
     * 
     * @param:  an object and integer
     * @return: void
     * precondition: Empty array
     * postcondition: array filled with objects
     */
    public void insert(Object ob, int index) throws Exception
    {
        if(index < 0 || index > size)// checking if index valid
        {
            throw new Exception("can't use negative value");
        }
        
        if(size == array.length)// checks if array has enough space to take new object
        {
            reallocateArray();// creates new array twice the size of initial array
        }
        
        // makes space to insert object by moving old object to the next index on the right
        for(int i = size - 1; i >= index; i--)   
        {
            array[i + 1] = array[i];
        }
        size++;
        array[index] = ob;
    }
    //this should behave like the corresponding method in java's built in Array-list
    /**
     * Method: remove. Remove and return the object at the specified index.
     * 
     * @param:  an integer
     * @return: Object
     * precondition: Empty/filled array
     * postcondition: array with one less object
     */
    public Object remove(int index) throws Exception
    {
        if(index < 0)// checking if index is valid
        {
            throw new Exception("Can't use negative value");            
        }
        
        if(index > size - 1)
        {
            throw new IndexOutOfBoundsException("ArrayOutOfBound");
        }
        
        Object removedObject = array[index];// holds the removed object
        // iterate the array, remove object of given index, move the object on the right to the empty spot on the left
        for(int i = index; i < size; i++)
        {
            array[i] = array[i + 1];
        }
        size--;
        return removedObject;
    }

    /**
     * Method: size. gets the size of the array.
     * 
     * @param:  none
     * @return: integer
     * precondition: none
     * postcondition: returns a new value each time the array is change and when the method is called
     */
    public int size()
    {
        return size;
    }

    /**
     * Method: toString. Prints the elements in the array front to back
     * 
     * @param:  none
     * @return: string
     * precondition: none
     * postcondition: overrided to print all elements in the array front to back
     */
    public String toString()//first index to last index
    {
        String value = "";
        for(int i = 0; i < size; i++)
        {
            value += array[i].toString();
        }
       return value;
    }

    /**
     * Method: indexOf. returns an index of the specified object
     * 
     * @param:  an object
     * @return: integer
     * precondition: none
     * postcondition: none
     */
    public int indexOf(Object ob) //returns -1 if not found
    {
        //iterate the array, find the index of the given object, return index
        for(int i = 0; i < size; i++)
        {
            if(array[i] == ob) return i;
        } 
        return -1; // if object is not found
    }
    
    /**
     * Method: Equals. Compares parameter object with this.
     * 
     * @param:  an object
     * @return: boolean
     * precondition: none
     * postcondition: none
     */
    public boolean equals(Object ob)// compares sizes and elements in the data structure
    {
        // checks if the object is empty
        if(ob == null)
        {
            return false;
        }

        if(ob == this)// checks if they have the same value
        {
            return true;
        }
        return false;
    }
    
    /**
     * Method: add. puts an object in the last index of an array,if the array is full the reallocateArray()
     *              creates more space for a new object
     * 
     * @param:  an object 
     * @return: void
     * precondition: Empty/full array
     * postcondition: array filled with objects
     */
    public void add(Object obj)
    {
        if(size == array.length)// checks if array has enough space to take new object
        {
            reallocateArray();
        }
        array[size] = obj;
        size++;
    }
    
    /**
     * Method: get object. get the object from a specified index.
     *         (This method is modified so that it can be used by the FindFile class)
     * 
     * @param:  an integer
     * @return: Object
     * precondition: none
     * postcondition: none
     */
    public Object get(int index) throws Exception// returns the object at index specified
    {
        /*if(index < 0)
        {
            throw new Exception("Can't use negative value");
        }
        
        if(index > size - 1)
        {
            throw new Exception("Array index is out of bound");
        }
        Object temp = null;
        array[index] = temp;*/
        return array[index];    
    }
    
    /**
     * Method: reallocate. creates an array (reallocationFactor * original length of array)
     *          for this code the new array is double the size of old array.
     * 
     * @param:  none
     * @return: void
     * precondition: old array
     * postcondition: new array twice the size of old array
     */
    private void reallocateArray()
    {
        Object[] newArray = new Object[array.length * ReallocationFactor];
        for(int i = 0; i < array.length; i++)
        {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    
    /**
     * Method: Constructor will be used in the FindFile class
     * 
     * @param:  an object 
     * @return: void
     * precondition: Empty array
     * postcondition: new array object is created when called
     */
    public ArrayList(Object[] input)
    {
        data = input;
        numElements = input.length;
    }
    
}
