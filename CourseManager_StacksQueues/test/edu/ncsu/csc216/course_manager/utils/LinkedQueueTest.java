/**
 * 
 */
package edu.ncsu.csc216.course_manager.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for LinkedQueue class.
 * @author Manaka Green and Jerry Zhang
 */
public class LinkedQueueTest {
	/*
	 Inserting a single element into the queue
	 Inserting multiple elements into the queue
	 Removing a single element from the queue
	 Removing multiple elements from the queue
	 Removing the last element from the queue
	 Interleaved inserts and removes
	 Attempting to remove an element from an empty queue	
	*/
	private LinkedQueue<String> queue;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue = new LinkedQueue<String>();
	}

	/**
	 * Tests linkedQueue.
	 */
	@Test
	public void testLinkedQueue() {
        assertTrue(queue.isEmpty());
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cat");
        assertFalse(queue.isEmpty());
        
        assertTrue(queue.isEmpty());
        queue.enqueue("dog");
        queue.enqueue("egg");
        assertEquals("dog", queue.dequeue());
        assertFalse(queue.isEmpty());
        queue.enqueue("fish");
        assertEquals("egg", queue.dequeue());
        assertEquals("fish", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

}
