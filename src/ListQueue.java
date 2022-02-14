/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: ListQueue.java
* ASSIGNMENT: Programming Assignment 7 - 
* Generic Implementation of Stacks and Queues
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program is the generic implementation of  a
* queue by the use of a LinkedList. Methods like enqueue,
* dequeue isEmpty is implemented from of the StackInterface class
* given in the spec.
* USAGE:
* java ListQueue 
* * This file is generic and therefore we can instantiate
* a stack of int or strings or some other data types.
* Due to generic programming,
* we ensure: type safety, reusability of code.
*/

public class ListQueue<E> implements QueueInterface<E>
{
	//  Node class of LinkedList
	private class Node
	{
		private E data;    
        private Node next;  
        // constructor of node class   
        public Node(E data) 
        {    
            this.data = data;    
            this.next = null;    
        }    
    }    
    // Constructor
	public ListQueue() {
		head = null;
	}
	
	public ListQueue(E data) {
		append(data);
	}
	// copy constructor
	public ListQueue(ListQueue<E> listQueueObj) {
		this.head = null;
	    Node cur = listQueueObj.head;
		while (cur!= null) {
			this.append(cur.data);
			cur = cur.next;
		}
	}
	
    public Node head = null;   
    /*
     * This  method adds a new node at the end to append a new data 
     * into the list
     * @param a generic type E which will be the last node
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
     * the two ListQueue objects if theya re equal in contents
     * and size
     * @param object of type object which is later casted
     * to ListQueue<E>
     * @ return boolean result.
     */
    //-------------------------------------------------------------
    public boolean equals(Object obj) 
    {	
    	if (obj instanceof ListQueue) 
        {
        	ListQueue<E> otherList = (ListQueue<E>) obj;
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
     * Add an element to the back of the queue.
     * @param a generic type E we have to add to the queue
     */
	@Override
	public void enqueue(E value) {
		append(value);	
	}
	/*
     * Remove and return the front element in the queue.
     * 
     * If the user attempts to dequeue from an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     * @return a generic type E we removed
     */
	public E dequeue() 
	{
		if (head==null) 
		{
			return null;
		}
		else 
		{
			E temp = head.data;
			head = head.next;
			return temp;
		}	
	}
	/*
     * Return (but do NOT remove) the front element of the queue.
     * 
     * If the user tries to peek on an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     * @ return a generic type E
     */
	public E peek() 
	{
		if (head==null) 
		{
			return null;
		}
		else {
			return head.data;	
		}	
	}
	/*
     * Returns true if the queue has no elements.
     * @return boolean result of the test
     */
	
	@Override
	public boolean isEmpty() 
	{
		return (head == null); 
	}
	
	/*
     * Returns the size elements.
     * @return int the size
     */
	@Override
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
     * Removes all elements from the queue.
     */
	@Override
	public void clear() {
		head = null;	
	}

	


}
