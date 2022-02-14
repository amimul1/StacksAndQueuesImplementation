/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: ArrayQueue.java
* ASSIGNMENT: Programming Assignment 6 - Stacks and Queues
* COURSE: CSc 210; Fall 2021
* PURPOSE: This program creates a class which implements a
* queue by the use of a dynamic array. Methods like peek pop,
* push is empty is implemented from the StackInterface class
* given in the spec.
* USAGE: 
* java ArrayQueue 
* This file is called by testcases.
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	//enqueue once
	@Test
	void test1() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.enqueue(1);
		String qString = queue1.toString();
		assertEquals(qString, "{1}");
	}
	
	//create empty arrayqueue
	@Test
	void test2() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		String qString = queue1.toString();
		assertEquals(qString, "{}");
	}
	
	//popping empty 
	@Test
	void test3() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.dequeue();
	}
	
	//peeking empty stack
	@Test
	void test4() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.peek();
	}
	
	//comparing empty stacks
	@Test
	void test5() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		ArrayQueue stack2 = new ArrayQueue();
		boolean bool = queue1.equals(stack2);
		assertEquals(bool, true);
	}

	//multiple pushes
	@Test
	void test6() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);
		String stackString = queue1.toString();
		assertEquals(stackString, "{1,2,3,4}");
	}
	
	//multiple pops
	@Test
	void test7() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);
		
		System.out.println("Popped " + queue1.dequeue());
		System.out.println("Popped " + queue1.dequeue());
		String stackString = queue1.toString();
		assertEquals(stackString, "{3,4}");
	}
	
	//peek, assert should be true
	@Test
	void test8() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);

		assertEquals(queue1.peek(), 1);
	}
	@Test
	void test9() 
	{
		ArrayQueue queue1 = new ArrayQueue();
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.enqueue(4);

		ArrayQueue queue2 = new ArrayQueue(queue1);
		
		queue1.enqueue(5);
		System.out.println(queue1);
		System.out.println(queue2);
	}
	
    @Test
    void test10() 
    {
        ArrayQueue s1 = new ArrayQueue();
        s1.enqueue(1);
        s1.enqueue(2);
        s1.enqueue(3);
        s1.enqueue(4);

        ArrayQueue s2 = new ArrayQueue(s1);

        s2.enqueue(5);
        System.out.println(s1);
        System.out.println(s2);
    }
 // Deep Copy, assert should be true
    @Test
    void test11() 
    {
    	System.out.println("test11start");
        ArrayQueue myStack = new ArrayQueue();
        myStack.enqueue(1);
        myStack.enqueue(2);
        myStack.enqueue(3);
        myStack.enqueue(4);

        ArrayQueue stackTwo = new ArrayQueue(myStack);
        myStack.enqueue(5);


        System.out.println(stackTwo.toString());
        System.out.println(myStack.toString());

        boolean result = myStack == stackTwo;
        assertEquals(result, false);
        System.out.println("Test 11 ended");
    } 


}