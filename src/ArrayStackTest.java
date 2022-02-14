import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayStackTest {

	//push once
	@Test
	void test1() 
	{
		ArrayStack stack1 = new ArrayStack();
		stack1.push(1);
		String stackString = stack1.toString();
		assertEquals(stackString, "{1}");
	}
	
	//create empty arraystack
	@Test
	void test2() 
	{
		ArrayStack stack1 = new ArrayStack();
		String stackString = stack1.toString();
		assertEquals(stackString, "{}");
	}
	
	//popping empty stack
	@Test
	void test3() 
	{
		ArrayStack stack1 = new ArrayStack();
		stack1.pop();
	}
	
	//peeking empty stack
	@Test
	void test4() 
	{
		ArrayStack stack1 = new ArrayStack();
		stack1.peek();
	}
	
	//comparing empty stacks
	@Test
	void test5() 
	{
		ArrayStack stack1 = new ArrayStack();
		ArrayStack stack2 = new ArrayStack();
		boolean bool = stack1.equals(stack2);
		assertEquals(bool, true);
	}

	//multiple pushes
	@Test
	void test6() 
	{
		ArrayStack stack1 = new ArrayStack();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		String stackString = stack1.toString();
		assertEquals(stackString, "{1,2,3,4}");
	}
	
	//multiple pops
	@Test
	void test7() 
	{
		ArrayStack stack1 = new ArrayStack();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		
		System.out.println("Popped " + stack1.pop());
		System.out.println("Popped " + stack1.pop());
		String stackString = stack1.toString();
		assertEquals(stackString, "{1,2}");
	}
	
	//peek, assert should be true
	@Test
	void test8() 
	{
		ArrayStack stack1 = new ArrayStack();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);

		assertEquals(stack1.peek(), 4);
	}
	// Deep Copy, assert should be false

    @Test
    void test9() 
    {
        ArrayStack s1 = new ArrayStack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        ArrayStack s2 = new ArrayStack(s1);

        s2.push(5);
        System.out.println(s1);
        System.out.println(s2);
    }
 // Deep Copy, assert should be true
    @Test
    void test10() 
    {
    	System.out.println("test10start");
        ArrayStack myStack = new ArrayStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        ArrayStack stackTwo = new ArrayStack(myStack);
        myStack.push(5);
        

        System.out.println(stackTwo.toString());
        System.out.println(myStack.toString());

        boolean result = myStack == stackTwo;
        assertEquals(result, false);
        System.out.println("Test 10 ended");
    } 

}