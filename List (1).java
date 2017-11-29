
/**
 *  List here.
 * 
 * @author Miriam Mnyuku 
 * @date 07/25/2017
 */
public class List
{
    Node head;

    public List()
    {
        head = null;
    }

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
    public void insert(Object object, int index)
    {
        //finds a node and puts in the data
        Node node = new Node(object);

        if(head == null)
        {
            if(index != 0) throw new LinkedListException();

            head = node;            
        }
        else if(index == 0)
        {
            head.setNext(node);
            head = node;
        }
        // We have more than one item.
        // We need to find the node after which we insert our new node.
        else
        {
            int currentIndex = 0;
            Node current = head;
            while(current != null)
            {
                if(currentIndex == index - 1)
                {
                    node.setNext(current.getNext());
                    current.setNext(node);

                    return;
                }

                current = current.getNext();
                ++currentIndex;
            }

            // index >= size
            throw new LinkedListException();
        }
    }

    /**
     * Method: remove. Remove and return the object at the specified index.
     * 
     * @param:  an integer
     * @return: Object
     * precondition: Empty/filled array
     * postcondition: array with one less object
     */
    public Object remove(int index) //throws Exception
    {        
        if(index == 0 && head != null)
        {
            Object removedObject = head.getData();
            head = head.getNext();
            return removedObject;
        }
        else
        {
            int currentIndex = 0;
            Node current = head;
            while(current != null)
            {
                if(currentIndex == index - 1)
                {
                    Node removedNode = current.getNext();
                    current.setNext(removedNode.getNext());
                    return removedNode.getData();
                }

                current = current.getNext();
                ++currentIndex;
            }
        }

        // index >= size
        throw new LinkedListException();
    }

    /**
     * Method: size. gets the size of the array.
     * 
     * @param:  none
     * @return: integer
     * precondition: none
     * postcondition: returns a new value each time the array is change and when the method is called
     */
    public void append(Object object)
    {
        Node tail = getTail();
        Node node = new Node(object);

        if(tail == null)
        {
            System.out.println("tail is null");
            head = node;
        }
        else
        {
            System.out.println("tail is " + tail.getData());
            tail.setNext(node);
        }
    }

    public void delete(int index) //throws LinkedListException
    {
        remove(index);
        //throw new LinkedListException();
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
        int size = 0;
        Node current = head;
        while(current != null)
        {
            current = current.getNext();
            ++size;
        }
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
    public String toString()
    {
        String result = "";

        Node current = head;
        while(current != null)
        {
            result += current.getData().toString();
            current = current.getNext();
            if(current != null)
            {
                result += ", ";
            }
        }

        return result;
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
        return size() == 0;
    }

    /**
     * Method: indexOf. returns an index of the specified object
     * 
     * @param:  an object
     * @return: integer
     * precondition: none
     * postcondition: none
     */
    public int indexOf(Object object)
    {
        int index = -1;

        int currentIndex = 0;
        Node current = head;
        while(current != null && index == -1)
        {
            if(current.getData() == object)
            {
                index = currentIndex;
            }

            current = current.getNext();
            ++currentIndex;
        }

        return index;
    }

    /**
     * Method: Equals. Compares parameter object with this.
     * 
     * @param:  an object
     * @return: boolean
     * precondition: none
     * postcondition: none
     */
    public boolean equals(Object other)// compares sizes and elements in the data structure
    {
        // checks if the object is empty
        if(other == null)
        {
            return false;
        }
        else if (getClass() != other.getClass()) 
        {
            return false;
        }
        else
        {
            List that = (List) other;
            Node thisPosition = this.head;
            Node otherPosition = that.head;
            while(thisPosition != null && otherPosition != null)
            {

                if(thisPosition._data != otherPosition._data)// checks if they have the same value
                {
                    return false;
                }
                else
                {
                    thisPosition = thisPosition._next; 
                    otherPosition = otherPosition._next;
                }
            }
            if(thisPosition == null && otherPosition != null) return false;
            else if(thisPosition != null && otherPosition == null) return false;
            
        }

        return true;
    }

    /**
     * Method: indexOf. returns an index of the specified object
     * 
     * @param:  an object
     * @return: integer
     * precondition: none
     * postcondition: none
     */
    private Node getTail()
    {
        Node tail = head;
        while(tail != null && tail.getNext() != null)
        {
            tail = tail.getNext();
        }
        return tail;
    }

    /**
     * Method: indexOf. returns an index of the specified object
     * 
     * @param:  an object
     * @return: integer
     * precondition: none
     * postcondition: none
     */
    public class Node
    {
        Node _next;
        Object _data;

        /**
         * Method: indexOf. returns an index of the specified object
         * 
         * @param:  an object
         * @return: integer
         * precondition: none
         * postcondition: none
         */
        public Node(Object data)
        {
            _data = data;
        }

        /**
         * Method: indexOf. returns an index of the specified object
         * 
         * @param:  an object
         * @return: integer
         * precondition: none
         * postcondition: none
         */
        public Node()
        {
            this._data = 0;
            this._next = null;
        }

        /**
         * Method: indexOf. returns an index of the specified object
         * 
         * @param:  an object
         * @return: integer
         * precondition: none
         * postcondition: none
         */
        public Node getNext()
        {
            return _next;
        }

        /**
         * Method: indexOf. returns an index of the specified object
         * 
         * @param:  an object
         * @return: integer
         * precondition: none
         * postcondition: none
         */
        public void setNext(Node next)
        {
            _next = next;
        }

        /**
         * Method: getData. returns an object
         * 
         * @param:  none
         * @return: object
         * precondition: none
         * postcondition: none
         */
        public Object getData()
        {
            return _data;
        }
    }

    /*public static void main(String[] args)throws Exception
    {
    List empty = new List();
    List one = new List();
    List multiple = new List();

    one.append(5);
    multiple.append(10);
    multiple.append(20);
    multiple.append(30);

    System.out.println("Empty:"+empty);
    System.out.println("One:"+one);
    System.out.println("Multiple:"+ multiple);  

    one.delete(0);
    multiple.delete(1);
    System.out.println("One (upon delete):"+one);
    System.out.println("Multiple (upon delete):"+ multiple);

    //one.insert(600, 1);
    multiple.insert(400, 2);
    System.out.println("One (on insert):"+one);
    System.out.println("Multiple(on insert):"+ multiple);
    }*/
}
