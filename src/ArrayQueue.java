/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: ArrayQueue.java
* ASSIGNMENT: Programming Assignment 6 - Stacks and Queues
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program creates a class which implements a
* queue by the use of a dynamic array. Methods like enqueue dequeue,
* peek isempty is implemented from the StackInterface class
* given in the spec.
* USAGE: 
* java ArrayQueue 
* This file is called by testcases.
*/

public class ArrayQueue implements QueueInterface {
	//field variables 
    private int array[];
    private int size;
    private static final int DEFAULT_CAPACITY = 3;
    //Constructor
    public ArrayQueue()
    {
        array = new int[DEFAULT_CAPACITY];
        size=0;
    }
 // Copy Constructor
    public ArrayQueue(ArrayQueue arQueueObj) 
    {
    	this.array = new int[arQueueObj.size()];
    	for (int i = 0; i< arQueueObj.size(); i++) 
    	{
    		this.add(arQueueObj.get(i));	
    	}
    }
    /*
     * A  method that adds an int value to the dynamic array
     * @param int, an int to add to the dynamic array.
     */
    public void add(int value)
    {
        if (size >= array.length)
            resize(2*array.length); 
        array[size] = value;
        size++;
    }
    
    /*
     * A  method that adds an int value to the dynamic array
     * at a specified index
     * @param int, an int to add to the dynamic array.
     */
    
    public void add(int index, int value)
    {
        if (size >= array.length)
            resize(2*array.length); 
        
        // shift all elements from index to the right by 1
        for(int i=size-1;i>=index;i--)
            array[i+1] = array[i];

        // insert the element at the specified index
        array[index] = value;
        size++;
    }
    /*
     * A  method that returns an int value of the dynamic array
     * at the specified index.
     * @param int, an int to return from the dynamic array.
     * @return an int 
     */
    public int get(int index)
    {
        return array[index];
    }
    /*
     * A  method that removes an int value of the dynamic array
     * at the specified index.
     * @param int, an int of the index to remove from the dynamic array.
     * @return none
     */
    public void remove(int index)
    {
        if(index>=size || index<0)
            System.out.println("No element at this index");
        else
        {
            // shift all elements from index+1 to the left by 1
            for(int i=index;i<size-1;i++)
                array[i] = array[i+1];
            size--;
        }
    }
    /*
     * A  method that resizes the dynamic array to twice 
     * of its previous size 
     * @param int, an int of the capacity of the dynamic array.
     * @return none
     */
    private void resize(int capacity)
    {
        int temp[] = new int[capacity];
        
        size = capacity < size ? capacity:size;
        for (int i=0; i < size; i++)
            temp[i] = array[i];
        
        array = temp;
    }
    /*
     * A  method that returns the size (number of elements)
     * @param none
     * @ return void.
     */ 
    public int size()
    {
        return size;
    }
    /*
     * A  method that returns the capacity of the dynamic array
     * @param none
     * @ return int, the capacity of spaces.
     */ 
    public int capacity()
    {
        return array.length;
    }
    /*
     * A  method that returns the boolean if parameter 
     * object array is equal to the listArray in terms of
     * number and value of elements
     * @param Object obj an ArrayStack type we will compare
     * @ return boolean according to the test
     */ 
    public boolean equals(Object obj) 
    {
        if (obj instanceof ArrayQueue) 
        {
        	ArrayQueue other = (ArrayQueue)obj;
            if (this.size == other.size) 
            {
                for (int i = 0; i < size; i++)
                    if (this.array[i] != other.array[i])
                        return false;
                return true;
            }
        }
        return false;
    }
    /*
     * A  method that returns a string representation of the
     * array.
     * @param none
     * @ return String representation.
     */
    public String toString() {
        String str = "{";
        for (int i = 0; i < size; i++) {
            str += (i == 0 ? "" : ",") + array[i];
        }
        str += "}";
        return str;
    }
    /*
     * Add an element to the back of the queue.
     * @param an int we have to add to the queue
     */
	@Override
	public void enqueue(int value) {
		add(value);
		
	}
	/*
     * Remove and return the front element in the queue.
     * 
     * If the user attempts to dequeue from an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     * @return an int we removed
     */
	@Override
	public int dequeue() {
		if (this.isEmpty()) {
			return -1;
		}
		int temp = get(0);
		remove(0);
		return temp;
	}
	/*
     * Return (but do NOT remove) the front element of the queue.
     * 
     * If the user tries to peek on an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     * @ return an int
     */
	@Override
	public int peek() {
		if (isEmpty()) {
			return -1;
		}
		return get(0);
	}
	
	/*
     * Returns true if the queue has no elements.
     */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/*
     * Removes all elements from the queue.
     */
	@Override
	public void clear() {
		while (!isEmpty()) {
			remove(0);	
		}
	}
    


}
