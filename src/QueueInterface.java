/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: QueueInterface.java
* ASSIGNMENT: Programming Assignment 7 - 
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program is the interface having generic implementation
* for implementing ListQueue.java . Abstract Methods like enqueue,
* dequeue,pop peek isEmpty is initiated.
* USAGE: 
* java QueueInterface implements StackInterface.
* 
*/
// Generic type E has been used as a parameter.
interface QueueInterface<E>{

    /*
     * Add an element to the back of the queue.
     */
	
	// this interface class has all abstract methods
    void enqueue(E value);

    /*
     * Remove and return the front element in the queue.
     * 
     * If the user attempts to dequeue from an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return null.
     */
     E dequeue();

    /*
     * Return (but do NOT remove) the front element of the queue.
     * 
     * If the user tries to peek on an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return null.
     */
    E peek();

    /*
     * Returns true if the queue has no elements.
     */
    boolean isEmpty();

    /*
     * Returns the number of elements in the queue.
     */
    int size();

    /*
     * Removes all elements from the queue.
     */
    void clear();
}
