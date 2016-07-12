package edu.ncsu.csc216.course_manager.utils;

import java.util.EmptyStackException;

/**
 * Uses LinkedList as a queue.
 * @author Manaka Green and Jerry Zhang
 */
public class LinkedQueue<E> implements Queue<E> {

	/** Accesses LinkedList's methods. */
	private LinkedList<E> list;
	
	/**
	 * Creates an instance of a linked list.
	 */
	public LinkedQueue() {
		list = new LinkedList<E>();
	}

	/**
	 * Adds the given element to the end of the queue.
	 */
	@Override
	public void enqueue(E element) {
		list.add(list.size(), element);
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 * @throws NoSuchElementException If the queue is empty
	 */
	@Override
	public E dequeue() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.remove(0);
	}

	/**
	 * Returns true if the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}
}