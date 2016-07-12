package edu.ncsu.csc216.course_manager.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Manaka Green and Jerry Zhang
 *
 */
public class LinkedStackTest {
/*
 Inserting a single element into the stack
 Inserting multiple elements into the stack
 Removing a single element from the stack
 Removing multiple elements from the stack
 Removing the last element from the stack
 Interleaved inserts and removes
 Attempting to remove an element from an empty stack	
*/
	private LinkedStack<String> stack;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack = new LinkedStack<String>();
	}

	@Test
	public void testPush() {
        assertTrue(stack.isEmpty());
        stack.push("apple");
        assertEquals("apple", stack.peek());
        stack.push("banana");
        assertEquals("banana", stack.peek());
        stack.push("cat");
        assertEquals("cat", stack.peek());
        stack.push("dog");
        assertEquals("dog", stack.peek());
    }
	public void testPop() {
        // Add elements to the stack
        stack.push("apple");
        stack.push("banana");
        stack.push("cat");
        stack.push("dog");
        
        // Remove elements from the stack
        assertEquals("dog", stack.pop());
        assertEquals("cat", stack.peek());
        assertEquals("cat", stack.pop());
        assertEquals("banana", stack.pop());
        assertEquals("apple", stack.pop());
        assertTrue(stack.isEmpty());
	}
	public void testPeek() {
        // Add and remove elements to the stack
        assertTrue(stack.isEmpty());
        stack.push("apple");
        assertEquals("apple", stack.peek());
        stack.push("banana");
        assertEquals("banana", stack.peek());
        assertEquals("banana", stack.pop());
        assertEquals("apple", stack.peek());
        stack.push("cat");
	}
}
