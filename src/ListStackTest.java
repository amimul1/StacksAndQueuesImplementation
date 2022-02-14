import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListStackTest {

	// Test pop(), asserts True
    @Test
    void test3() {
        ListStack<Integer> myList = new ListStack<>();

        myList.push(1);
        myList.push(2);
        myList.push(3);

        myList.pop();
        String result = myList.toString();

        assertEquals("{1,2}", result);
    }
    @Test
    void test4() {
        ListStack<Integer> myList = new ListStack<Integer>();

        myList.push(1);
        myList.push(2);
        myList.push(3);

        ListStack<Integer> listTwo = new ListStack<Integer>(myList);

        String original = myList.toString();
        System.out.println(original);

        String duplicate = listTwo.toString();
        System.out.println(duplicate);

        assertEquals(duplicate, original);
    }
    @Test
    void test5() {
        ListStack<String> myList = new ListStack<String>();

        myList.push("first");
        myList.push("second");
        myList.push("third");
        myList.pop();

        String result = myList.toString();

        assertEquals("{first,second}", result);
    }
    @Test
    void test6() {
        ListStack<String> myList = new ListStack<String>();

        myList.push("one");
        myList.push("too");
        myList.push("thee");

        ListStack<String> listTwo = new ListStack<String>(myList);

        String original = myList.toString();
        System.out.println(original);

        String duplicate = listTwo.toString();
        System.out.println(duplicate);

        assertEquals(duplicate, original);
    }
        
    }
    
    



