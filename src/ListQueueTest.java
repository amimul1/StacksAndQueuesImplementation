import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListQueueTest {
	
	// Test enqueue(), Asserts true
	@Test
	void test1() {
		ListQueue<Integer> myQueue = new ListQueue<Integer>();
		myQueue.enqueue(5);
		
		String result = myQueue.toString();
		assertEquals("{5}", result);
	}
	
	// Test dequeue(), Asserts true
	@Test
	void test2() {
		ListQueue<String> myQueue = new ListQueue<String>();
		
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		myQueue.enqueue("four");
		
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		String result = myQueue.toString();
		System.out.println(myQueue);
		assertEquals("{four}", result);
	}
	
	// Test peek(), Asserts true
	@Test
	void test3() {
		ListQueue<Integer> myQueue = new ListQueue<Integer>();
		
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		
		int val = myQueue.peek();
		assertEquals(1, val);
	}
	
	// Test isEmpty(), Asserts true
	@Test
	void test4() {
		ListQueue<Integer> myQueue = new ListQueue<Integer>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		
		boolean result = myQueue.isEmpty();
		assertEquals(false, result);
	}
	
	// Test isEmpty(), Asserts true
	@Test
	void test5() {
		ListQueue<Integer> myQueue = new ListQueue<Integer>();		
		boolean result = myQueue.isEmpty();	
		
		assertEquals(true, result);
	}
	
	// Test size(), Asserts true
	@Test
	void test6() {
		ListQueue<Integer> myQueue = new ListQueue<Integer>();
		
		myQueue.enqueue(8);
		myQueue.enqueue(9);
		myQueue.enqueue(4);
		myQueue.enqueue(2);
		myQueue.enqueue(6);
		
		int result = myQueue.size();	
		
		assertEquals(5, result);
	}
	
	// Test clear(), Asserts true
	@Test
	void test7() {
		ListQueue<Integer> myQueue = new ListQueue<Integer>();
		
		myQueue.enqueue(8);
		myQueue.enqueue(9);
		myQueue.enqueue(4);
		myQueue.enqueue(2);
		myQueue.enqueue(6);
		
		myQueue.clear();
		boolean result = myQueue.isEmpty();	
		
		assertEquals(true, result);
	}

}