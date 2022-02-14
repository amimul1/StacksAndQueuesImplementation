/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: ArrayStack.java
* ASSIGNMENT: Programming Assignment 6 - Stacks and Queues
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program creates a class which implements a
* stack by the use of a dynamic array. Methods like peek pop,
* push is empty is implemented from the StackInterface class
* given in the spec.
* USAGE: 
* java ArrayStack 
* This file is called by testcases.
* 
* ----------- EXAMPLE INPUT COMMAND -------------
* 		ArrayStack stack1 = new ArrayStack();
*		stack1.push(1);
*		stack1.push(2);
*		stack1.push(3);
*		stack1.push(4);
*/

public class ArrayStack implements StackInterface {
	//field variables 
    private int array[];
    private int size;
    private static final int DEFAULT_CAPACITY = 3;
    //Constructor
    public ArrayStack()
    {
        array = new int[DEFAULT_CAPACITY];
        size=0;
    }
    // Copy Constructor
    public ArrayStack(ArrayStack arStackObj) {
    	this.array = new int[arStackObj.size()];
    	for (int i = 0; i< arStackObj.size(); i++) {
    		this.add(arStackObj.get(i));	
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
    // to get an element at an index
    
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
        if (obj instanceof ArrayStack) 
        {
        	ArrayStack other = (ArrayStack)obj;
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
    

	@Override
	 /*
     * Add an element to the top of the stack.
     * @param a int to push
     */
	public void push(int value) {
		add(value);
		
	}
	/*
     * Remove and return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1.
     * @ return an int
     */
	@Override
	public int pop() {
		
		if (this.isEmpty()) {
			return -1;
		}
		int temp = get(size()-1);
		remove(size()-1);
		return temp;
	}
	/*
     * Returns the element to peek 
     * @return an int
     */
	@Override
	public int peek() {

		if (isEmpty()) {
			return -1;
		}
		return get(size()-1);
	}

    /*
     * Returns true if the stack has no elements.
     * @return a boolean
     */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

    /*
     * Removes all elements from the stack.
     */
	@Override
	public void clear() {
		while (!isEmpty()) {
			remove(0);	
		}
	}

	


}
