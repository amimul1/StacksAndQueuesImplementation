/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: StackInterface.java
* ASSIGNMENT: Programming Assignment 7 - 
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program is the interface having generic implementation
* for implementing ListStach.java . Abstract Methods like push,
* pop peek isEmpty is initiated.
* USAGE: 
* java StackInterface implements StackInterface.
* 
*/


// Generic type E has been used as a parameter.
interface StackInterface<E>{
     // This interface class has all abstract methods.
    /*
     * Add an element to the top of the stack.
     */
    void push(E value);

    /*
     * Remove and return the top element in the stack.
     * 
     * If the user attempts to pop an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return null.
     */
    E pop();

    /*
     * Return (but do NOT remove) the top element 
     * of type E of the stack.
     * 
     * If the user attempts to peek on an empty stack, ignore the
     * request (i.e. make no changes to the stack) and return null.
     */
    E peek();

    /*
     * Returns true if the stack has no elements.
     */
    boolean isEmpty();

    /*
     * Returns the number of elements in the stack.
     */
    int size();

    /*
     * Removes all elements from the stack.
     */
    void clear();

}
