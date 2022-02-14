
/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: ListStack.java
* ASSIGNMENT: Programming Assignment 7 - 
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program creates does the generic implementation
* of Stack by the use of a LinkedList. Methods like push,
* pop peek isEmpty is implemented from the StackInterface class
* and it has been made generic.
* USAGE: 
* java ListStack
* This file is generic and therefore we can instantiate
* a stack of ints or strings or some other data types.
* * Due to generic programming,
* we ensure: type safety, reusability of code.
*/


public class ListStack<E> implements StackInterface<E>{
	// node class of the Linkedlist
	private class Node
	{
		// field variables.
		private E data;    
        private Node next;  
        // constructor of node class  
        public Node (E data) 
        {    
            this.data = data;    
            this.next = null;    
        }    
    }    
    
	public ListStack() {
		head = null;
	}
	
	public ListStack(E data) {
		append(data);
	}
	// constructor of liststack class.
	// <E> parameterized to make it generic.
	public ListStack(ListStack<E> listStackObj) {
		this.head = null;
		Node cur = listStackObj.head;
		while (cur!= null) 
		{
			this.append(cur.data);
			cur = cur.next;
		}
	}
	
    public Node head = null;   
    /*
     * This  method adds a new node at the end to append a new data 
     * into the list
     * @param a generic type E  which will be the last node
     * @ return void
     */
    //-------------------------------------------------------------
    public void append(E data) 
    {    
        // create a new node    
    	Node newNode = new Node(data);    
            
        // check if the list is empty    
        if (head == null) 
        {    
            head = newNode; 
        }    
        else 
        {    
        	Node p = head;
        	// traverse the list until p refers to the last node
            while (p.next != null)
            	p = p.next;    
            p.next = newNode; 
        }   
    }    
    /*
     * This  method returns the boolean value by comparing 
     * the two ListQueue objects if they are equal in contents
     * and size
     * @param object of type object which is later casted
     * to ListStack<E>
     * @ return boolean result.
     */
    //-------------------------------------------------------------
    public boolean equals(Object obj) 
    {	
    	if (obj instanceof ListStack) 
        {
        	ListStack<E> otherList = (ListStack<E>) obj;
        	Node cur = this.head;
        	Node otherObjCur = otherList.head;
            
        	while (cur != null && otherObjCur != null) 
        	{
        		if (cur.data != otherObjCur.data) {
        			return false;
        		}
        		cur = cur.next;
        		otherObjCur = otherObjCur.next;
        	}
        	return (cur == null && otherObjCur == null);    
        }
    	else 
    		return false;   
    }    
    /*
     * A  method that returns a string representation of the
     * array.
     * @param none
     * @ return String representation.
     */    
    //-------------------------------------------------------------
    public String toString() 
    {    
        String str = "{";
        Node curr = head;
        while (curr != null) 
        {
            str += (curr == head ? "" : ",") + curr.data;
            curr = curr.next;
        }
        str += "}";
        return str;   
    }
	 /*
     * Add an element to the top of the stack.
     * @param a generic type E  to push
     */
	@Override
	public void push(E value) {
		append(value);
		
	}
	/*
     * Remove and return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1.
     * @ a generic type E which is popped.
     */
	@Override
	public E pop() 
	
	{
		Node cur = head;
		if (head == null)
		{
			return null;
		}
		else if (head.next==null) 
		{
			E temp = head.data;
			head = null;
			return temp;
		}
		// iterate through until the second last
		// node of the list.
		while (cur.next.next != null) 
		{
			cur = cur.next;
		}
		E temp = cur.next.data;
		cur.next = null;
		return temp;
	}

	/*
     * Return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return -1.
     * @ return a generic type E 
     */
	@Override
	public E peek() 
	{
		Node cur = head;
		if (head == null)
		{
			return null;
		}
		while (cur != null) 
		{
			if (cur.next == null) 
			{
				return cur.data;
			}
			cur = cur.next;
		}
		return null;
	}

	 /*
     * checks and Returns true if the stack has no elements.
     * @return a boolean
     */
	@Override
	public boolean isEmpty() {
		return (head == null); 
	}
	
	@Override
	/*
	 * Returns the size of the Stack 
	 * @return  an int representing the size.
	 */
	public int size() 
	{
		int size = 0;	
		Node cur = head;
		while (cur != null) 
		{
			size += 1;
			cur = cur.next;
		}		
		return size;
	}
    /*
     * Removes all elements from the stack.
     */
	@Override
	public void clear() {
		head = null;	
	}

}
